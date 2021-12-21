package com.lrucache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache<K,V> {

    int capacity;
    Map<K, LRUNode<K, V>> kvMap;
    LRUNode<K, V> head;
    LRUNode<K, V> tail;

    public LRUCache(int  capacity){
        this.capacity = capacity;
        kvMap = new HashMap<>(capacity);
        this.head = null;
        this.tail  = null;
    }
    public V get(K key){
        if(!kvMap.containsKey(key)) return null;
        LRUNode<K, V> node = kvMap.get(key);
        extractAndRemove(node);
        return node.getValue();
    }

    public void put(K key,V value){
        LRUNode<K, V> node = new LRUNode<>(key, value);

        if(kvMap.containsKey(key)){
            kvMap.put(key, node);
            extractAndRemove(node);
        } else {
            if(kvMap.size() == this.capacity){
                System.out.println("cache full:: " + kvMap.size());
                kvMap.remove(tail.key);
                LRUNode<K, V> penultimate = tail.prev;
                if(penultimate != null){
                    penultimate.next = null;
                }
                tail = penultimate;
            }
        }

        if(head == null){
            head = node;
            tail = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }
        kvMap.put(key, node);
    }

    public void extractAndRemove(LRUNode<K, V> node){
        if(head == node) return;

        LRUNode<K, V> prev = node.prev;
        LRUNode<K, V> next = node.next;

        //
        prev.next = next;
        if(next != null){
            next.prev = prev;
        } else {
            tail = prev;
        }

        node.next = head;
        head.prev = node;
        head = node;

        node.prev = null;


    }

    @Override
    public String toString() {
        return "LRUCache{" +
                "capacity=" + capacity +
                ",\n kvMap=" + kvMap +
                '}';
    }
}
