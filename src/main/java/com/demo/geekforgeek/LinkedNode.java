package com.demo.geekforgeek;


import com.demo.Java2blog.ListNode;
import com.demo.geekforgeek.LinkedNode;

import java.util.List;

public class LinkedNode implements LinkedList{
    int val;
    LinkedNode next;

    public LinkedNode(){
    }
    public LinkedNode(int val){
        this.val= val;
    }

    public LinkedNode(int val, LinkedNode next){
        this.next= next;
    }

    void display(){
        LinkedNode current = this; // Start from the current node
        while (current != null) {
            System.out.print(current.val + " "); // Print the current node's value
            current = current.next; // Move to the next node
        }
        System.out.println(); // Print a newline at the end
    }



    @Override
    public  LinkedNode reverseLinkedList(LinkedNode node) {
        LinkedNode current=node;
        LinkedNode previous= null;
        LinkedNode next=null;

        while(current!= null){
            next=current.next;
            current.next=previous;
            previous=current;
            current=next;
        }
        return previous;
    }

    @Override
    public int searchElementInLinkedList(LinkedNode node, int elem) {
        LinkedNode current=node;
        int index=0;
        while(current != null){
            if(current.val==elem){
                return index;
            }
            current=current.next;
            index++;
        }
        return -1;
    }

    @Override
    public LinkedNode removeDuplicatesFromSortedLinkedList(LinkedNode node) {
        LinkedNode current=node;

        while(current!=null && current.next != null){
            if(current.val==current.next.val){
                current.next=current.next.next;
            }else{
                current=current.next;
            }
        }
        return node;
    }

    @Override
    public LinkedNode removeKeyFromLinkedList(LinkedNode node, int key) {
        return null;
    }

    @Override
    public LinkedNode insertAtGivenPositionLinkedList(LinkedNode node, int pos) {
        return null;
    }

    @Override
    public LinkedNode deleteLastNodeLinkedList(LinkedNode node) {
        return null;
    }

    @Override
    public int findMiddleNodeLinkedList(LinkedNode node) {
        return 0;
    }
}
