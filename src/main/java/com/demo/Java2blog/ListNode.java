package com.demo.Java2blog;

public class ListNode {
    int val;
    ListNode next;
    public ListNode(){

    }
    public ListNode(int val){
        this.val=val;
    }
    public ListNode(int val, ListNode next){
        this.val=val;
        this.next= next;
    }

    // Utility method to print the linked list
    void printList() {
        ListNode current = this;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}
