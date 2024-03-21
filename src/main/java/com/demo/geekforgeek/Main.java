package com.demo.geekforgeek;

public class Main {
    public static void main(String[] args) {
        LinkedNode l1=new LinkedNode(11);
        LinkedNode l2=new LinkedNode(2);
        LinkedNode l3=new LinkedNode(32);
        LinkedNode l4=new LinkedNode(32);
        LinkedNode l5=new LinkedNode(4);
        l1.next=l2;
        l2.next=l3;
        l3.next=l4;
        l4.next=l5;

        LinkedNode obj= new LinkedNode();

        LinkedNode rev= obj.removeDuplicatesFromSortedLinkedList(l1);
        rev.display();
    }
}
