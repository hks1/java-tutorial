package com.collections.custom;

public class ListNode <T>{
    T val;
    ListNode next;
    public ListNode(){};
    public ListNode(T t){
        this.val = t;
        this.next = null;
    }
    public ListNode(T t, ListNode next){
        this.val = t;
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
