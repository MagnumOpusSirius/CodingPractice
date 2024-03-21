package com.demo.geekforgeek;


public interface LinkedList {
    LinkedNode reverseLinkedList(LinkedNode node);
    int searchElementInLinkedList(LinkedNode node, int elem);
    LinkedNode removeDuplicatesFromSortedLinkedList(LinkedNode node);
    LinkedNode removeKeyFromLinkedList(LinkedNode node, int key);
    LinkedNode insertAtGivenPositionLinkedList(LinkedNode node, int pos);
    LinkedNode deleteLastNodeLinkedList(LinkedNode node);
    int findMiddleNodeLinkedList(LinkedNode node);
}
