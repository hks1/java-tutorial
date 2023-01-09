package com.collections.custom;

import java.util.NoSuchElementException;

public class LinkedList<E> implements ILinkedList<E>{
    ListNode<E> head;
    ListNode<E> tail;
    int size = 0;

    public LinkedList(){}
    public LinkedList(ListNode<E> head){
        this.head = head;
        this.tail = head;
        size++;
    }

    @Override
    public String toString() {
        return "LinkedList{" +
                "head=" + head +
                '}';
    }

    @Override
    public void add(E e) {
        ListNode<E> node = new ListNode<>(e);
        tail.next = node;
        tail = tail.next;
        size++;
    }

    @Override
    public E remove() {
        if(head == null){
            throw new NoSuchElementException("List is Empty");
        }
        ListNode<E> node = tail;

        ListNode prev = null;
        ListNode curr = this.head;

        while(curr.next != null){
            prev.next = curr;
            curr = curr.next;
        }
        tail = prev;
        prev.next = null;
        size--;
        return node.val;
    }
}
