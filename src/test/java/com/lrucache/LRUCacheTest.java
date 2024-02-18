package com.lrucache;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LRUCacheTest {

    LRUCache<Integer, Integer> cache;

    @BeforeEach
    void setUp() {
        cache = new LRUCache<>(2);
        cache.put(1,1);
        cache.put(2,2);
    }

    @Test
    public void test1(){
        LRUCache<Integer, Integer> lruCache = new LRUCache<>(2);
        lruCache.put(2,1);
        lruCache.put(2,2);
        assertEquals(2, lruCache.get(2));
    }

    // ["LRUCache","put","put","put","put","get","get"]
    //[[2],[2,1],[1,1],[2,3],[4,1],[1],[2]]
    @Test
    public void test2(){
        LRUCache<Integer, Integer> lruCache = new LRUCache<>(2);
        lruCache.put(2,1);
        lruCache.put(1,1);
        lruCache.put(2,3);
        lruCache.put(4,1);
        assertEquals(null, lruCache.get(1));
        assertEquals(3, lruCache.get(2));
        assertEquals(2, cache.kvMap.size());
    }

    // ["LRUCache","put","put","get","put","get","put","get","get","get"]
    // [[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]
    @Test
    public void test3(){
        LRUCache<Integer, Integer> lru = new LRUCache<>(2);
        lru.put(1,1);
        lru.put(2,2);
        assertEquals(1, lru.get(1));
        lru.put(3,3);
        assertEquals(null, lru.get(2));
        lru.put(4,4);
        assertEquals(null, lru.get(1));
        assertEquals(3, lru.get(3));
        assertEquals(4, lru.get(4));
        assertEquals(2, cache.kvMap.size());
    }

    @Test
    void get() {
        assertEquals(1, cache.get(1));
        assertEquals(2, cache.get(2));
    }

    @Test
    void put() {
        cache.put(3, 3);
        assertEquals(3, cache.get(3));
        assertEquals(null , cache.get(1));
        assertEquals(2, cache.get(2));
        cache.put(3,1);
        assertEquals(1, cache.get(3));
        assertEquals(2, cache.kvMap.size());
    }

    @Test
    void extractAndRemove() {
    }

    @Test
    void testToString() {
    }
}