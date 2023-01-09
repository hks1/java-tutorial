package com.collections.custom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestListNode {
    ListNode node;
    @BeforeEach
    public void setUP(){
        //node = new ListNode();
    }
    @Test
    public void testListNode(){
        node = new ListNode(4);
        Assertions.assertEquals(4, node.val);
    }
}
