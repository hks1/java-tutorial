package com.utils;

import java.util.Comparator;
import java.util.Objects;

public class ListNode  {
    public int val;
    public ListNode next;
    public ListNode(){};
    public ListNode(int val){
        this.val = val;
    }
    public ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
    //implements Comparator<ListNode>
    /*@Override
    public int compare(ListNode o1, ListNode o2) {
        while(o1 != null && o2 != null){
            if(o1.val != o2.val) return o1.val - o2.val;
            o1 = o1.next;
            o2 = o2.next;
        }
        if(o1 == null && o2 == null) return 0;
        if(o1 != null) return 1;
        else return -1;
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListNode listNode = (ListNode) o;
        return val == listNode.val && Objects.equals(next, listNode.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, next);
    }
}
