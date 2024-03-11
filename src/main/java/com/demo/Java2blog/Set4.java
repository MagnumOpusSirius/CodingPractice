package com.demo.Java2blog;

import java.util.*;
import java.util.stream.Collectors;

public class Set4 {
    static int[] rotateZeroAndOne(int[] arr){
        int j=0;
        for(int i=0; i< arr.length; i++){
            if(arr[i]==0){//[1,1,0,0]
                int temp= arr[j];
                arr[j]=arr[i];
                arr[i]=temp;
                j++;
                System.out.println(Arrays.toString(arr));
            }
        }
        return arr;
    }
    static boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>(); // create an empty stack
        for (int c = 0; c < s.length(); c++) { // loop through each character in the string
            if (s.charAt(c) == '(') // if the character is an opening parenthesis
                stack.push(')'); // push the corresponding closing parenthesis onto the stack
            else if (s.charAt(c) == '{') // if the character is an opening brace
                stack.push('}'); // push the corresponding closing brace onto the stack
            else if (s.charAt(c) == '[') // if the character is an opening bracket
                stack.push(']'); // push the corresponding closing bracket onto the stack
            else if (stack.isEmpty() || stack.pop() != s.charAt(c)) // if the character is a closing bracket
                // if the stack is empty (i.e., there is no matching opening bracket) or the top of the stack
                // does not match the closing bracket, the string is not valid, so return false
                return false;
        }
        // if the stack is empty, all opening brackets have been matched with their corresponding closing brackets,
        // so the string is valid, otherwise, there are unmatched opening brackets, so return false
        return stack.isEmpty();
    }



    public static void main(String[] args) {
        List<Integer> mylist= Arrays.asList(1,1,2,3,2,5,12,7);
        List<Integer> result =mylist.stream().filter(x->x%2==0).distinct().collect(Collectors.toList());

        System.out.println(result);


    }
}
