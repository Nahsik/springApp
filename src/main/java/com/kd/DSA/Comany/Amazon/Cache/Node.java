package com.kd.DSA.Comany.Amazon.Cache;

public class Node<K, V> {
    K key;
    V value;
    Node<K, V> prev, next;

    public Node(K key, V value) {
        this.key = key;
        this.value = value;
    }
}


