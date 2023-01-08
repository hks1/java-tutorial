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
    @Test
    public void testHasCycle(){
        //Example 1:
        //
        //
        //Input: head = [3,2,0,-4], pos = 1
        //Output: true
        //Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).
        //Example 2:
        //
        //
        //Input: head = [1,2], pos = 0
        //Output: true
        //Explanation: There is a cycle in the linked list, where the tail connects to the 0th node.
        //Example 3:
        //
        //
        //Input: head = [1], pos = -1
        //Output: false
        //Explanation: There is no cycle in the linked list.
    }
    @Test
    public void testDetectCycle(){
        //Example 1:
        //
        //
        //Input: head = [3,2,0,-4], pos = 1
        //Output: tail connects to node index 1
        //Explanation: There is a cycle in the linked list, where tail connects to the second node.
        //Example 2:
        //
        //
        //Input: head = [1,2], pos = 0
        //Output: tail connects to node index 0
        //Explanation: There is a cycle in the linked list, where tail connects to the first node.
        //Example 3:
        //
        //
        //Input: head = [1], pos = -1
        //Output: no cycle
        //Explanation: There is no cycle in the linked list.
    }
}
