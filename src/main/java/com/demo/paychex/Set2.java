package com.demo.paychex;

public class Set2 {
    //perform binary search to find the target value:
    //return that elements position if its target:

    static int binarySearch(int[] arr, int target){
        int start=0;
        int end=arr.length-1;

        while(start<=end){
            int mid=(start+end)/2;
            if(target>arr[mid]){
                start=mid+1;
            }else if(target<arr[mid]){
                end=mid-1;
            }else{
                return mid;
            }
        }
        return -1;
    }

    //find the top k frequent elements:

    //valid anagram:

    //remove duplicate elements from array:

    //find the nth fibonacci number:

    //find elements closest to 0:

    //find k closest elements:


    public static void main(String[] args) {
        int[] arr= {1,2,3,4,5,6,7};
        int target= 9;
        System.out.println(binarySearch(arr, target));
    }

}
