package com.kd.DSA.Comany.Amazon.Cache;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class LRUCache<K, V> implements Cache<K, V> {
    private final int capacity;
    private final Map<K, Node<K, V>> map;
    private final DoublyLinkedList<K, V> dll;
    ExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
    ReentrantLock reentrantLock = new ReentrantLock();
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.dll = new DoublyLinkedList<>();
    }

    @Override
    public V get(K key) {
        if (!map.containsKey(key)) return null;
        Node<K, V> node = map.get(key);
        dll.moveToFront(node);
        return node.value;
    }

    @Override
    public int getSize() {
        return this.capacity;
    }

    @Override
    public void put(K key, V value) {
        if (map.containsKey(key)) {
            Node<K, V> node = map.get(key);
            node.value = value;
            dll.moveToFront(node);
        } else {
            if (map.size() == capacity) {
                Node<K, V> lru = dll.removeTail();
                if (lru != null) {
                    map.remove(lru.key);
                }
            }
            Node<K, V> newNode = new Node<>(key, value);
            dll.addToFront(newNode);
            map.put(key, newNode);
        }
    }
}

