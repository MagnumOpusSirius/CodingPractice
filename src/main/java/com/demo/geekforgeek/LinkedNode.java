package com.demo.geekforgeek;

public class LinkedNode {
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

}
