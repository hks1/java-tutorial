package com.linkedlist;

import com.utils.ListNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestLinkedListProblems {
    LinkedListProblems obj;
    @BeforeEach
    public void setUp(){
        obj = new LinkedListProblems();
    }
    @Test
    @DisplayName("// reverse linked list")
    public void testReverseList(){
        ListNode list = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode reverseList = new ListNode(5, new ListNode(4, new ListNode(3, new ListNode(2, new ListNode(1)))));
        Assertions.assertEquals(reverseList, obj.reverseList(list));
        //Assertions.assert
    }
}
