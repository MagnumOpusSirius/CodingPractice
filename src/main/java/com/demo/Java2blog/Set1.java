package com.demo.Java2blog;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Set1 {
    //reverse a string without using inbuilt methods
    //Method 1: Loop
    public String reverseString(String str){
        String result="";
        for(int i=str.length()-1; i>=0; i--){
            result+=str.charAt(i);
        }
        return result;
    }
    //Method 2: StringBuilder
    public StringBuilder reverseStringUsingBuilder(String str){
        StringBuilder result= new StringBuilder();
        for(int i = str.length()-1; i>=0; i--){
            result.append(str.charAt(i));
        }
        return result;
    }
    //check if 2 strings are anagram:
    //cat or act should return true
    public boolean anagram(String s, String t){
        if(s.length()!= t.length()){
            return false;
        }
        //use map to store frequency count of each character
        //key:character, value:frequency count
        Map<Character, Integer> newMap= new HashMap<>();
        for(int i=0; i<s.length(); i++){
            newMap.put(s.charAt(i), newMap.getOrDefault(s.charAt(i), 0)+1);
        }

        for(int i=0; i<t.length(); i++){
            newMap.put(t.charAt(i), newMap.getOrDefault(t.charAt(i),0)-1);
        }

        for(int value: newMap.values()){
            if(value!=0){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Set1 s= new Set1();

        String str= "Hello World";
        System.out.println(s.reverseString(str));
        System.out.println(s.reverseStringUsingBuilder(str));

        String s1 = "cat";
        String t1= "act";
        System.out.println(s.anagram(s1,t1));
    }
}
