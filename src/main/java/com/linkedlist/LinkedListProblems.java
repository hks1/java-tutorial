package com.linkedlist;

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
}
