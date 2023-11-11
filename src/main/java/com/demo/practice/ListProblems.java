package com.demo.practice;

import java.util.ArrayList;
import java.util.List;

public class ListProblems {


    //lets create a function that takes a single list and iterates over it:
    //how does this single list look like:
    // [1,2,3,4,5]
    //so is it similar to array? yes
    //how is it different from array? it is dynamic
    //what is List<List<int>> arr called? 2D list
    static int printList(List<Integer> arr){
        int sum=0;
        for(int i=0; i<arr.size(); i++){
            sum+=arr.get(i);
        }
        return sum;
    }


    //a function that takes 2D list::
    static int print2DList(List<List<Integer>> arr){
        int sum=0;
        //arr.size() gives the number of rows but does it start at index =0? yes. So would i need to do arr.size()-1? no
        //why not? because we are not using the index to access the elements of the list
        //what are we using then? we are using the for each loop
        //how does a 2D List look like:
        // [[1,2,3]
        //  [4,5,6]
        //  [7,8,9]]
        for(int row= 0; row<arr.size(); row++){
            for(int col= 0; col<arr.get(row).size(); col++){
                sum+=arr.get(row).get(col);
                System.out.println(sum);
            }
        }
        return sum;
    }

    //Given a  2D ArrayList: that is 6 by 6, find the hourglass with the maximum sum and return the sum.

    // 1 1 1 0 0 0
    // 0 1 0 0 0 0
    // 1 1 1 0 0 0
    // 0 0 2 4 4 0
    // 0 0 0 2 0 0
    // 0 0 1 2 4 0
    // max= 19

    public static int hourglassSum(List<List<Integer>> arr){
        int max= Integer.MIN_VALUE;
        //psudo code:
        //loop through the rows
        //loop through the columns
        //calculate the sum of the hourglass:
        /*
        [1][1][1]
           [1]
        [1][1][1]
         */
        //why is it arr.size()-2? because we are looking at 3 rows at a time
        //why is it r-2*c-2? it has to do
        for(int row=0; row<arr.size()-2; row++){
            for(int col=0; col<arr.get(row).size()-2; col++){
                int currSum=0;
                currSum += arr.get(row).get(col)+ arr.get(row).get(col+1) + arr.get(row).get(col+2);
                currSum += arr.get(row+1).get(col+1);
                currSum += arr.get(row+2).get(col)+ arr.get(row+2).get(col+1) + arr.get(row+2).get(col+2);
                if(currSum > max){
                    max= currSum;
                }

            }
        }
        return max;
    }

    public static void main(String[] args) {
        List<Integer> arr= new ArrayList<>();
        //how to add multiple elements at once?
        arr.addAll(List.of(1,2,3,4,5));
        System.out.println(printList(arr));
        System.out.println("=====================================");
        List<List<Integer>> arr2= new ArrayList<>();
        arr2.addAll(List.of(List.of(1,2,3), List.of(4,5,6), List.of(7,8,9))); //how is this 2D list structured? [][][] -> 3 rows and 3 columns
        /*
        [1,2,3]
        [4,5,6]
        [7,8,9]
         */
        System.out.println(print2DList(arr2));

        System.out.println("=====================================");
        List<List<Integer>> arr3= new ArrayList<>();
        arr3.addAll(List.of(
                List.of(1,1,1,0,0,0),
                List.of(0,1,0,0,0,0),
                List.of(1,1,1,0,0,0),
                List.of(0,0,2,4,4,0),
                List.of(0,0,0,2,0,0),
                List.of(0,0,1,2,4,0)));
        System.out.println(hourglassSum(arr3));

    }
}
