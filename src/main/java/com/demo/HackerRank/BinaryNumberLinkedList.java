package com.demo.HackerRank;

public class BinaryNumberLinkedList {
    //properties we can access are: data, next
    public static long getNumber(SinglyLinkedListNode binary){
        long decimalNum=0;
        int length=0;
        //traverse to the end of the linked list to reach the most significant bit
//        SinglyLinkedListNode current= binary;
//        while(current.next!=null){
//            current= current.next;
//        }

        // calculate the length of the linked list:
        SinglyLinkedListNode current= binary;
        while(current!=null){
            length++;
            current= current.next;
        }

        current= binary;
        while(current!=null){
            if(current.data==1){
                decimalNum+= Math.pow(2, length-1);

            }
            length--;
            current= current.next;
        }
        return decimalNum;
    }
    public static void main(String[] args){
        SinglyLinkedListNode binary= new SinglyLinkedListNode(1);
        binary.next= new SinglyLinkedListNode(0);
        binary.next.next= new SinglyLinkedListNode(1);
        binary.next.next.next= new SinglyLinkedListNode(1);
        binary.next.next.next.next= new SinglyLinkedListNode(1);

        long decimalNum= getNumber(binary);
        System.out.println(decimalNum);
        System.out.println(binary.data+" "+binary.next.data+" "+binary.next.next.data+" "+binary.next.next.next.data+" "+binary.next.next.next.next.data);
    }
}
