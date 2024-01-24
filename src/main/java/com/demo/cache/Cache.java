package com.demo.cache;

import java.util.Optional;

public interface Cache<K,V> {
    boolean set(K key, V Value);
    Optional<V> get(K key);
    int size();
    boolean isEmpty();
    void clear();
}

