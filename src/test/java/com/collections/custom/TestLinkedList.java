package com.collections.custom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestLinkedList {
    ILinkedList<Integer> list;
    @BeforeEach
    public void setup(){
        list = new LinkedList<>();
    }
    @Test
    public void testLinkedList(){
        ListNode<Integer> head = new ListNode<>(1);
        LinkedList<Integer>  list = new LinkedList<>(head);
        Assertions.assertEquals(head, list.head);
        Assertions.assertEquals(head, list.tail);
        System.out.println(list);
        list.add(2);
        System.out.println(list);
    }
}
