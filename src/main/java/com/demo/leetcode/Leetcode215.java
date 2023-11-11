package com.demo.leetcode;

import java.util.PriorityQueue;

public class Leetcode215 {
    public int findKthLargest(int[] nums, int k){
        //this sorts the array in descending order? ans: yes
        PriorityQueue<Integer> queue= new PriorityQueue<>((a,b)-> nums[b] - nums[a]);

        //add the elements in the queue:
        for(int i=0; i<nums.length; i++){
            queue.add(i);

        }
        int kthLargest=0;
        for(int i=0; i<k; i++){
            kthLargest= queue.poll();
        }

        return nums[kthLargest];
    }

    public static void main(String[] args) {
        Leetcode215 lc215= new Leetcode215();
        int[] nums= {3,2,1,5,6,44,33};
        int k=2;
        System.out.println(lc215.findKthLargest(nums, k));
    }

}
