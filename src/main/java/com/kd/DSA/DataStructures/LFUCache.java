package com.kd.DSA.DataStructures;

import java.util.HashMap;
import java.util.Map;

import java.util.*;

class LFUCache {

    private class Node {
        int key, value, freq;
        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.freq = 1;
        }
    }

    private final int capacity;
    private int minFreq;

    private final Map<Integer, Node> keyNodeMap;
    private final Map<Integer, LinkedHashSet<Integer>> freqMap;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFreq = 0;
        this.keyNodeMap = new HashMap<>();
        this.freqMap = new HashMap<>();
    }

    public int get(int key) {
        if (!keyNodeMap.containsKey(key)) return -1;
        Node node = keyNodeMap.get(key);
        updateFreq(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (capacity == 0) return;

        if (keyNodeMap.containsKey(key)) {
            Node node = keyNodeMap.get(key);
            node.value = value;
            updateFreq(node);
        } else {
            if (keyNodeMap.size() >= capacity) {
                evictLFU();
            }
            Node newNode = new Node(key, value);
            keyNodeMap.put(key, newNode);
            freqMap.computeIfAbsent(1, k -> new LinkedHashSet<>()).add(key);
            minFreq = 1;
        }
    }

    private void updateFreq(Node node) {
        int freq = node.freq;
        freqMap.get(freq).remove(node.key);
        if (freqMap.get(freq).isEmpty()) {
            freqMap.remove(freq);
            if (freq == minFreq) minFreq++;
        }

        node.freq++;
        freqMap.computeIfAbsent(node.freq, k -> new LinkedHashSet<>()).add(node.key);
    }

    private void evictLFU() {
        LinkedHashSet<Integer> keys = freqMap.get(minFreq);
        int evictKey = keys.iterator().next(); // Least recently used in minFreq
        keys.remove(evictKey);
        if (keys.isEmpty()) freqMap.remove(minFreq);
        keyNodeMap.remove(evictKey);
    }
}
