package com.kd.DSA.LinkedList;

import java.util.HashMap;
import java.util.Map;

class LRUCache {

    private class Node {
        Node next, prev;
        int key;
        int val;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private int capacity;
    private Map<Integer, Node> cacheMap;
    private Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cacheMap = new HashMap<>();
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!cacheMap.containsKey(key)) {
            return -1;
        }
        Node node = cacheMap.get(key);
        removeKey(node);
        addNode(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (cacheMap.containsKey(key)) {
            Node node = cacheMap.get(key);
            cacheMap.remove(key);
            removeKey(node);
        }
        if (cacheMap.size() == capacity) {
            cacheMap.remove(tail.prev.key);
            removeKey(tail.prev);
        }
        Node node = new Node(key, value);
        cacheMap.put(key, node);
        addNode(node);
    }

    private void removeKey(Node node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }

    private void addNode(Node node) {
        node.prev = head;
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
    }
}
