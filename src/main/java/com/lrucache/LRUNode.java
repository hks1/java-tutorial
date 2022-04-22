package com.lrucache;

public class LRUNode<K, V> {
    K key;
    V value;
    LRUNode<K, V> next;
    LRUNode<K, V> prev;

    public LRUNode(){}

    public LRUNode(K key, V value){
        this.key = key;
        this.value = value;
        this.next = null;
        this.prev = null;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    /*@Override
    public String toString() {
        return "Node{" +
                "key=" + key +
                ", value=" + value +
                //", next=" + next +
                //", prev=" + prev +
                '}';
    }*/

    @Override
    public String toString() {
        //return "LRUNode{"+"key:" + key +", value:" + value +'}';
        //return "{"+"key :" + key +", value :" + value +'}';
        return "{"+ key +": " + value +"}";
    }
}
