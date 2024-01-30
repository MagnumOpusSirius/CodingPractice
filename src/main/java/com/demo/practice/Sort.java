package com.demo.practice;

import java.util.Arrays;

/*
    All Sorting algo are discussed:
 */
public class Sort {
    public static void main(String[] args) {
        int[] arr= {2,5,3,7,4,6};
        System.out.println(Arrays.toString(mergeSort(arr)));
    }
    //use merge sort to sort an array:
    static int[] mergeSort(int[] arr){
        //base case:
        if(arr.length==1){
            return arr;
        }
        //get the mid:
        int mid=arr.length/2;
        //divide the array in half: left and right
        int[] left= mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int[] right= mergeSort(Arrays.copyOfRange(arr, mid, arr.length));
        return merge(left, right);
    }
    static int[] merge(int[] first, int[] second){
        int[] mixed= new int[first.length+second.length];

        int i=0; //for the first arr
        int j=0; //for the second arr
        int k=0; //for the mixed arr

        //check if any of the arrays length do not go out of bounds:
        while(i<first.length && j< second.length){
            if(first[i]<second[j]){
               mixed[k]= first[i];
               i++;
            }
            else{
                mixed[k]= second[j];
                j++;
            }
            k++;
        }
        while(i<first.length){
            mixed[k]= first[i];
            i++;
            k++;
        }
        while(j<second.length){
            mixed[k]= second[j];
            j++;
            k++;
        }
        return mixed;
    }
}
