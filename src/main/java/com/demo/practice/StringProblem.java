package com.demo.practice;

public class StringProblem {
    static void reverseString(String str){
        // ===============OR========FOR-LOOP
        String revStr="";
        for(int i = str.length()-1; i>=0; i--){
            System.out.print(str.charAt(i)+revStr);
        }
        // ===============OR========BUILT-IN
        System.out.println();
        StringBuilder revStr1=new StringBuilder();
        revStr1.append(str);
        revStr1.reverse();
        System.out.println(revStr1);
        // ===============OR========RECURSIVE
        //reverseString(str.substring(1)+reverseString())

    }
    static int factorial(int num){
        if(num==0){
            return 1;
        }

//        if(num==0){
//            return 1;
//        }

        return num * factorial(num-1);
    }
    public static void main(String[] args) {
//        String str= "Hello World";
//        reverseString(str);
        String str1="Hello";
        System.out.println(str1.substring(1)+str1.charAt(0));
        System.out.println(factorial(5));
    }
}
