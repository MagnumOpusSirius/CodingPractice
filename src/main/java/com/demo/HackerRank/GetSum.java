package com.demo.HackerRank;

import java.util.Arrays;
import java.util.Scanner;

public class GetSum {
    public Integer sum(Integer[] ints){
        //sum the integers
        int sum=0;
        for(int i=0; i<ints.length; i++){
            sum+=ints[i];
        }
        return sum;
        //return the sum
    }
    public static void main(String[] args){
        Scanner scanner= new Scanner(System.in);
        System.out.println("Enter the number of integers you want to sum: ");
        int numInts= scanner.nextInt();
        Integer[] ints= new Integer[numInts];
        System.out.println("Enter the integers you want to sum: ");
        for(int i=0; i<numInts; i++){
            ints[i]= scanner.nextInt();
        }
        GetSum getSum= new GetSum();
        System.out.println(getSum.sum(ints));

        int[][] matrix= {{1,2},{2,3}};
        int[] result= Arrays.stream(matrix).flatMapToInt(Arrays::stream).sorted().toArray();

        System.out.println(Arrays.toString(result));

    }
}
