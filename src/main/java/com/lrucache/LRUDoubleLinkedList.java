package com.lrucache;

public class LRUDoubleLinkedList<K, V> {
    LRUNode<K, V> head;
    LRUNode<K, V> tail;

    public LRUDoubleLinkedList(){
        head = new LRUNode<>();
        tail = new LRUNode<>();
        head.next = tail;
        tail.prev = head;
    }

    public void remove(LRUNode<K, V> node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.next = null;
        node.prev = null;
    }

    public LRUNode<K, V> removeLRUNode(){
        LRUNode<K, V> node = tail;
        if(tail.prev == null){
            tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        node.prev = null;
        return node;
    }
}
