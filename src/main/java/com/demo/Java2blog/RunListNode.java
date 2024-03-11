package com.demo.Java2blog;


public class RunListNode {
    static ListNode addTwoNumbers(ListNode l1, ListNode l2){
        //[1,2,3]+[2,3,4]=[3,5,7]
        ListNode dummy = new ListNode();
        ListNode result=dummy;
        int total=0;
        int carry=0;
        while(l1 != null || l2 != null){
            total=carry;
            if(l1!=null){
                total+=l1.val;
                l1= l1.next;
            }
            if(l2 != null){
                total+=l2.val;
                l2= l2.next;
            }
            int remainder= total%10;
            carry= total /10;
            dummy.next= new ListNode(remainder);
            dummy= dummy.next;
        }

        return result.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2, new ListNode(3, new ListNode(4)));
        ListNode l2 = new ListNode(8, new ListNode(3, new ListNode(4)));;


        ListNode result= addTwoNumbers(l1,l2);
        result.printList();

    }
}
