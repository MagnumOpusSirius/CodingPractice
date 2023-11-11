package com.demo.practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ArrayProblem {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //[1,2,3,4] and [2,3,4,5]
        // to find the middle of the array
        //medianFormula= nums[i] + nums[]
        //[3,4,5,6,7] => arr.length/2.ceil()=> median
        //[3,4,5,6,7,8]= 9/2 => arr.length/2=3 => arr[3]= 6 => arr[3-1]= 5 => 6+5/2 = median
        /*
         - step 1: to merge the 2 sorted array, it should be done in O(m+n) time.
            -
         - find the arr.length and if its odd then you get the index which is middle = (start+end)/2
         - if it total length is even, then you
        */
        int[] merged=merge(nums1, nums2);
        int len= merged.length;

        //if even then:
        if(len%2==0){
            int val= len/2;
            double store1= merged[val];
            double store2= merged[val-1];

            return (store1+store2)/2;
        }
        else{
            //if odd then:
            return merged[len/2];
        }

    }
    public static int[] merge(int[] arr1, int[] arr2){
        int len1= arr1.length;
        int len2= arr2.length;

        int[] finalArr=new int[len1+len2]; //total length of the final array
        int i =0, j=0, k=0;

        while(i < len1 && j < len2){
            //check if the array1[i] is less than array2[j]
            if(arr1[i]<arr2[j]){
                finalArr[k]=arr1[i];
                i++;
            }
            else{
                finalArr[k]=arr2[j];
                j++;
            }
            k++;
        }
        while(i<len1){
            finalArr[k]=arr1[i];
            i++;
            k++;
        }
        while(j<len2){
            finalArr[k]=arr2[j];
            j++;
            k++;
        }
        return finalArr;
    }

    static int[] twoSum(int[] arr, int target){
        //int maxSum=Integer.MIN_VALUE;
        /*for(int i =0; i< arr.length; i++){
            for(int j= i+1; j<arr.length; j++){
                if(arr[i]+arr[j]==target){
                    return new int[]{i,j};
                }
            }
        }*/
        Map<Integer, Integer> newMap=new HashMap();
        //hashtable: key: value
        //compleemnt=?
        int[] store=new int[2];
        for(int i =0; i< arr.length; i++){
            int complement= target-arr[i];
            if(newMap.containsKey(complement)){
                store[0]= newMap.get(complement);
                store[1]= i;
                //return new int[]{newMap.get(complement), i};
                return store;
            }
            else{
                newMap.put(arr[i], i);
            }
        }
        return new int[]{};
    }
    public static void main(String[] args){
//        int[] arr= {3,4,5,6};
//        int target=9;
//        System.out.println(Arrays.toString(twoSum(arr, target)));
//        System.out.println(5/2);
        //==================================
        int[] nums1= {1,2};
        int[] nums2= {3,4};
        //findMedianSortedArrays(nums1, nums2); //why is this ignored?
        //System.out.println(findMedianSortedArrays(nums1, nums2));
        System.out.println(Arrays.toString(merge(nums1, nums2)));






    }
}
