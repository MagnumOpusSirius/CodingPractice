package com.demo.cache;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class LRUCache<T> {

    private int size, capacity;
    private Map<String, Node> hashmap;
    private DoublyLinkedList internalQueue;
    public LRUCache(int capacity){
        this.capacity=capacity;
        this.size= 0;
        this.hashmap=new HashMap<>();
        this.internalQueue=new DoublyLinkedList();
    }

    public T get(String key){
        //fetch the data from hashmap with the key:
        Node node= hashmap.get(key);
        if(node==null){
            return null;
        }
        internalQueue.moveNodeToFront(node);
        return hashmap.get(key).value;
    }
    public void put(String key, T value){
        //if the same key already there then replace:
        Node currentNode=hashmap.get(key);
        if(currentNode  != null){
            currentNode.value=value;
            internalQueue.moveNodeToFront(currentNode);
        }

        if(size==capacity){
            String rearNodeKey= internalQueue.getRearKey();
            internalQueue.removeNodeFromRear();
            hashmap.remove(rearNodeKey);
            size--;
        }

        Node node= new Node(key,value);
        internalQueue.addNodeToFront(node);
        hashmap.put(key,node);
        size++;
    }

    private class Node{
        String key;
        T value;
        Node next, prev;
        public Node(String key, T value){
            this.key=key;
            this.value=value;
            this.next=null;
            this.prev=null;
        }
    }

    private class DoublyLinkedList{
        private Node front, rear;
        public DoublyLinkedList(){
            front=rear=null;
        }
        private void addNodeToFront(Node node){
            if(rear==null){
                front=rear =node;
                return;
            }
            node.next=front;
            front.prev=node;
            front=node;
        }
        public void moveNodeToFront(Node node){
            if(front==node){
                return;
            }
            if(node==rear){
                rear=rear.prev;
                rear.next=null;
            }else{
                node.prev.next=node.next;
                node.next.prev=node.prev;
            }
            node.prev=null;
            node.next=front;
            front.prev=node;
            front=node;

        }
        public void removeNodeFromRear(){
            if(rear==null){
                return;
            }
            System.out.println("Deleting key: "+ rear.key);
            if(front==rear){
                front=rear=null;
            }
            else{
                rear=rear.prev;
                rear.next=null;
            }
        }
        private String getRearKey(){
            return rear.key;
        }
    }

}
