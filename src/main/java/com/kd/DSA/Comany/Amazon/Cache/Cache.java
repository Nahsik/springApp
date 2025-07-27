package com.kd.DSA.Comany.Amazon.Cache;

public interface Cache<K, V> {
    void put(K key, V value);
    V get(K key);
    int getSize();
}
