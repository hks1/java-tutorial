package com.lrucache;

public class Main {
    public static void main(String[] args) {
        //LRUCache<Integer, LRUNode> lruCache = new LRUCache<>(3);
        LRUCache<Integer, String> lruCache = new LRUCache<>(3);
        System.out.println(lruCache);
        lruCache.put(1, "one");
        lruCache.put(2, "two");
        lruCache.put(3, "three");

        System.out.println(lruCache);
        lruCache.get(1);
        lruCache.get(5);
        System.out.println(lruCache.head);
        lruCache.get(3);

        LRUNode<Integer, String> LRUNode6 = new LRUNode<>(6, "six");
        //lruCache.put(LRUNode6.key, LRUNode6);
        System.out.println(lruCache.head);
        lruCache.put(4, "four");
        System.out.println(lruCache + " , head is: " + lruCache.head);

    }
}
