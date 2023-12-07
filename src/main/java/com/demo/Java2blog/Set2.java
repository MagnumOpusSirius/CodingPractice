package com.demo.Java2blog;

import java.util.*;

public class Set2 {
    static StringBuilder reverseString(String str){
        String result="";
        StringBuilder result1= new StringBuilder();

        for(int i=str.length()-1; i>=0; i--){
            result+=str.charAt(i);
            result1.append(str.charAt(i));
        }
        return result1;
    }
    //cat, act, tac
    static boolean checkAnagram(String s, String t){
        if(s.length()!=t.length()){
            return false;
        }
        //key=character, values= frequncy count
        Map<Character, Integer> newMap= new HashMap<>();

        //append: 5
        for(int i= 0; i< s.length(); i++){
            newMap.put(s.charAt(i),newMap.getOrDefault(s.charAt(i),0)+1);
        }
        //character in t we remove the counter: 4
        for(int i= 0; i< t.length(); i++){
            newMap.put(t.charAt(i),newMap.getOrDefault(t.charAt(i),0)-1);
        }
        //
        for(int val: newMap.values()){
            if(val!=0){
                return false;
            }
        }
        return true;
    }

    //hello: false
    static boolean checkUnique(String str){
        Set<Character> mySet= new HashSet<>();

        for(int i=0; i<str.length(); i++){
            mySet.add(str.charAt(i));
        }//return unqiue

        if(str.length()!= mySet.size()){
            return false;
        }
        return true;

    }

    // cat -> atc, tca - true -> catcat
    static boolean isRotation(String s, String t){
        //s=c, cc => true
//        if(s.length()!= t.length()){
//            return false;
//        }
        String result= s+s; //catcat

        if(result.contains(t)){
            return true;
        }
        return false;

    }

    static void duplicateChar(String str){
        Map<Character, Integer> newMap= new HashMap<>();

        for(int i=0; i<str.length(); i++){
            newMap.put(str.charAt(i), newMap.getOrDefault(str.charAt(i), 0)+1);
        }
        //Entry interface provided by Map allows us a lot of methods to handle keys and values

        for(Map.Entry<Character, Integer> entry: newMap.entrySet()){
            Character keyChar= entry.getKey();
            Integer valueCount= entry.getValue();

            if(valueCount>1){
                System.out.println(keyChar);
            }
        }
    }

    //hhello -> insertion order
    //hashMap -> hehllo
    static void nonRepeatedChar(String str){

        str=str.replaceAll("\\s","");
        System.out.println(str);
        Map<Character, Integer> newMap= new LinkedHashMap<>();

        for(int i=0; i<str.length(); i++){
            newMap.put(str.charAt(i), newMap.getOrDefault(str.charAt(i), 0)+1);
        }

        for(Map.Entry<Character, Integer> entry: newMap.entrySet()){
            Character keyChar= entry.getKey();
            Integer valueCount= entry.getValue();

            if(valueCount==1){
                System.out.println(keyChar);
                break;
            }
        }
    }
    //str= abcd -> a,ab,abc,b,bc,c => 3!, 4!
    static void findSubstring(String str){


        for(int i=0; i<str.length(); i++){
            for(int j=i+1; j<=str.length();j++){
                System.out.println(str.substring(i,j));
            }
        }
    }

    static void findLength(String str){
        int length=0;
        char[] arr= str.toCharArray();

        for(char c: arr){
            length++;
        }
        System.out.println(length);
    }

    public static void main(String[] args) {

    }
}
