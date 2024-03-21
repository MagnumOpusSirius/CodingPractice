package com.demo.sorting;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MergeSort {
    public static void mergeSort(int[] inputArr){
        int length = inputArr.length;
        //base condition:
        if(length<2){
            return;
        }

        //find the mid:
        int mid= length/2;

        //form the left and right array:
        int[] leftArr= new int[mid];
        int[] rightArr= new int[length-mid];

        //populate the array:
        for(int i=0; i< mid; i++){
            leftArr[i]= inputArr[i];
        }
        for(int i=mid; i< length; i++){
            rightArr[i-mid]= inputArr[i];
        }
        mergeSort(leftArr);
        mergeSort(rightArr);
        merge(inputArr, leftArr, rightArr);
    }
    private static void merge(int[] inputArr, int[] leftArr, int[] rightArr){
        int leftLen= leftArr.length;
        int rightLen= rightArr.length;

        int i=0;//left arr pointer
        int j =0;//right arr pointer
        int k=0;//merged array pointer

        while(i<leftLen && j<rightLen){
            if(leftArr[i] <= rightArr[j]){
                inputArr[k]=leftArr[i];
                i++;
                k++;
            }else{
                inputArr[k]=rightArr[j];
                j++;
                k++;
            }
        }

        while(i<leftLen){
            inputArr[k]= leftArr[i];
            i++;
            k++;
        }
        while(j<rightLen){
            inputArr[k]= rightArr[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        int[] arr= {3,6,2,4,3,9,10,4};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
