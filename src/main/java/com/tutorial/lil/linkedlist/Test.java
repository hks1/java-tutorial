package com.tutorial.lil.linkedlist;

public class Test {
    public static void main(String[] args) {
        CustomLinkedList linkedList = new CustomLinkedList();

        Node firstNode = new Node(1);
        Node secondNode = new Node(2);
        Node thirdNode = new Node(3);
        Node fourthNode = new Node(4);
        Node fifthNode = new Node(5);
        Node sixthNode = new Node(6);

        linkedList.head = firstNode;
        firstNode.next = secondNode;
        secondNode.next = thirdNode;
        thirdNode.next = fourthNode;
        fourthNode.next = fifthNode;
        fifthNode.next = sixthNode;

        linkedList.display();

        System.out.println(linkedList.size());

        // kth from last is size-k+1 from start

        linkedList.deleteKthFromLast(2);
        linkedList.display();

        CustomLinkedList linkedList1 = new CustomLinkedList();
        Node node1 = new Node(1);
        Node node2 = new Node(1);
        Node node3 = new Node(2);
        linkedList1.deleteKthFromLast(1);

    }
}
