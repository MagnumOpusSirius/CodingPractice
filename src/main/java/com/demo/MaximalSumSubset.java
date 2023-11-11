package com.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


//[7,6,5,3,2,1]
//0 < sum(7,6...)
//if yes then add 7 to the new list
public class MaximalSumSubset {
    static List<Integer> subSetA(List<Integer> arr){
        List<Integer> newArr= new ArrayList<>();
        int sumNewArr=0;
        //sort:
        Collections.sort(arr);
        //int totalSum = arr.stream().mapToInt(Integer::intValue).sum();
        //if(sumA+arr.get(i)<=totalSum)
        for(int i=arr.size()-1; i>=0; i--){
            if(sumNewArr<=getArrSum(arr, 0, i)){ //check if sumNewArr < rest of array sum
                newArr.add(arr.get(i)); //adds 7 to the new list
                sumNewArr+=arr.get(i);
            }
        }
        Collections.reverse(newArr);
        return newArr;
    }
    static int getArrSum(List<Integer> arr, int start, int end){
        int sum=0;
        for(int i =start; i<=end; i++){
            sum+=arr.get(i);
        }
        return sum;
    }

    //lets write another way to solve subSetA make it more efficient:
    private static int sum(List<Integer> list) {
        int sum = 0;
        for (Integer num : list) {
            sum += num;
        }
        return sum;
    }
    static List<Integer> subSetA1(List<Integer> arr){
        List<Integer> subsetA= new ArrayList<>();
        int sumA=0;
        Collections.sort(arr);

        //lets not use the getArrSum method:
        //but we also check for the array sum starting from 0 to the place excluding the current element and going over the rest of the array elements after it.
        //if the sum of the current element and the rest of the array is greater than the sum of the rest of the array elements then we add the current element to the new array.

        //int getSum=Arrays.stream(arr,0,i).sum();
        //i want to use somethign  smiliar to above but for the arraylist but from 0 to i:


        for (int i = arr.size() - 1; i >= 0; i--) {
            if (sumA <= sum(arr.subList(0, i + 1))) {
                subsetA.add(arr.get(i));
                sumA += arr.get(i);
            } else {
                break;
            }
        }
        Collections.sort(subsetA);
        return subsetA;
    }

       /*
       if this is the array => [7,6,5,3,2]
       we loop around it => if(7<the rest of the array sum(excluding 7))
       then we add 7 to the newArray and now check for the next element in the old array which is 6
       now we check if (7 + 6 is < old array sum(excluding 6 and 7))
       now this condition is false because 7+6 is greater than the rest of the old array sum(excluding 6 and 7)
       so here we should return 7 and 6.

       for(int num: arr)
       if(7>OldArrSum){
       added 7 to new array
        remove 7 from the old array. => [6,5,3,2]
        find the sum of the old array (oldArrSum)

        go back => check if new num which is 6 => add to the new array => remove 6 from here
        if(newArr sum > oldArrSum)
        remove

       }
        */

    public static List<Integer> findMaximalSumSubset(List<Integer> arr) {
        Collections.sort(arr);
        List<Integer> subsetA = new ArrayList<>();
        int sumA = 0;

        for (int i = arr.size() - 1; i >= 0; i--) {
            if (sumA <= calculateSum(arr, 0, i)) {
                subsetA.add(arr.get(i));
                sumA += arr.get(i);
            }
        }

        Collections.reverse(subsetA);
        return subsetA;
    }

    private static int calculateSum(List<Integer> arr, int start, int end) {
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += arr.get(i);
        }
        return sum;
    }

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>(List.of(7, 6, 5, 3, 2));
        List<Integer> result = subSetA1(arr);
        System.out.println(result);
    }
}

