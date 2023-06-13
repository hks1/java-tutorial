package com.tutorial.lil.linkedlist;

public class CustomLinkedList {
    Node head;

    public void display(){
        Node current = head;
        while (current != null){
            System.out.print(current.data + "->");
            current = current.next;
        }
        System.out.println();
    }

    public int size(){
        Node current = head;
        int size = 0;
        while(current != null){
            size++;
            current = current.next;
        }
        return size;
    }

    public void deleteKthFromLast(int k){
        Node current = head;
        Node prev = null;
        if(k > size()){
            System.out.println("Size error");
            return;
        }
        k = this.size() - k + 1;
        int count = 0;
        for(int i = 1; i < k; i++){
            prev = current;
            current = current.next;
        }
        prev.next = current.next;
        current.next = null;
    }
}
