package com.demo;

import java.util.Scanner;

public class Main {

    //-----------------Exercise 1-----------------
    static int calculateSum(int n){
        int sum=0;
        //int track=0;
        for(int i=1; i<=n; i++){
            if(i % 3 == 0 || i % 5 == 0) {
                sum += i;
            }
        }
        return sum;
    }
    //-----------------Exercise 2-----------------
    static int calculateDifference(int n){
        //diff = (sum of squares of first n natural numbers) - (square of their sum)
        int sumofsq= 0;
        int sqofsum=0;
        for(int i=1; i<=n; i++){
            sumofsq += (int) Math.pow(i, 2); //add the squares of the numbers
            sqofsum += i; //add the numbers
        }
        sqofsum = (int) Math.pow(sqofsum, 2); //square the sum
        return sumofsq-sqofsum;
    }
    //-----------------Exercise 3-----------------
    static String getImage(String str){
        return str+ "|" + new StringBuilder(str).reverse();
    }
    //-----------------Exercise 4-----------------
    static boolean checkNumber(int n){
        //we compare the last digit with the second last digit
        int last= n%10; //this gets the last digit
        n/=10; //this removes the last digit
        while(n>0){
            int currDig= n%10;
            if(last < currDig){
                return false;
            }
            last = currDig;
            n/=10;
        }
        return true;
    }
    //-----------------Exercise 5-----------------
    static boolean checkNumber2(int n){

        //check for the base case
        if(n==0){
            return false;
        }
        //check for the recursive case
        if(n==1){
            return true;
        }
        //check for the recursive case
        if(n%2 != 0){
            return false;
        }
        return checkNumber2(n/2);
    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //-----------------Exercise 1-----------------
//        System.out.print("Enter the value of n: ");
//        int n = sc.nextInt();
//        System.out.println(calculateSum(n));

        //-----------------Exercise 2-----------------
//        System.out.print("Enter the value of n: ");
//        int n1 = sc.nextInt();
//        System.out.println(calculateDifference(n1));

        //-----------------Exercise 3-----------------
//        System.out.print("Enter the string: ");
//        String str = sc.nextLine();
//        System.out.println(getImage(str));

        //-----------------Exercise 4-----------------
//        System.out.print("Enter the number: ");
//        int n2 = sc.nextInt();
//        System.out.println(checkNumber(n2));

        //-----------------Exercise 5-----------------
        System.out.print("Enter the number: ");
        int n3 = sc.nextInt();
        System.out.println(checkNumber2(n3));
        //how to use lambda expression in stream?
    }
}