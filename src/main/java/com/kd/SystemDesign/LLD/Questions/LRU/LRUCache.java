package com.kd.SystemDesign.LLD.Questions.LRU;

import java.util.HashMap;
import java.util.Map;

class LRUCache {
    class Node {
        Node prev, next;
        int val;
        int key;

        Node(int key, int val) {
            this.val = val;
            this.key = key;
        }
    }

    private Map<Integer, Node> hash;
    private int capacity;
    private Node start, last;

    public LRUCache(int capacity) {
        hash = new HashMap<>();
        this.capacity = capacity;
        this.start = new Node(0, 0);
        this.last = new Node(0, 0);
        start.next = last;
        last.prev = start;
    }

    public int get(int key) {
        if (!hash.containsKey(key)) {
            return -1;
        }
        Node node = hash.get(key);
        remove(node);
        addNode(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (hash.containsKey(key)) {
            Node node = hash.get(key);
            hash.remove(key);
            remove(node);
        }
        if (hash.size() == capacity) {
            hash.remove(last.prev.key);
            remove(last.prev);
        }
        Node node = new Node(key, value);
        hash.put(key, node);
        addNode(node);
    }

    private void remove(Node node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }

    private void addNode(Node node) {
        Node tamp = start.next;
        start.next = node;
        node.next = tamp;
        node.prev = start;
        tamp.prev = node;
    }


}


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
