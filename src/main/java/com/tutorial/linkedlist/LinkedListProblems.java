package com.tutorial.linkedlist;

import com.utils.ListNode;

public class LinkedListProblems {
    public ListNode reverseList(ListNode head){
        ListNode curr = head;
        ListNode prev = null;
        while(curr != null){
            ListNode tempNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tempNode;
        }
        return prev;
    }

    //141. Linked List Cycle
    //Given head, the head of a linked list, determine if the linked list has a cycle in it.
    //
    //There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.
    //
    //Return true if there is a cycle in the linked list. Otherwise, return false.
    public boolean hasCycle(ListNode head) {
        return false;
    }

    //142. Linked List Cycle II
    //Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.
    //
    //There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to (0-indexed). It is -1 if there is no cycle. Note that pos is not passed as a parameter.
    //
    //Do not modify the linked list.
    public ListNode detectCycle(ListNode head) {
        return null;
    }
}
