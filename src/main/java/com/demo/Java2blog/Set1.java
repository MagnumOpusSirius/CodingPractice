package com.demo.Java2blog;

import java.util.*;

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

    // check if a string has all unique character:
    public boolean uniqueChar(String str){
        Set<Character> mySet= new HashSet<>();

        for(int i=0; i<str.length(); i++){
            mySet.add(str.charAt(i));
        }
        if(mySet.size()!=str.length()){
            return false;
        }
        return true;
    }

    //check if one string is rotation of another string:
    public boolean rotationCheck(String s, String t){
        if(s.length()!= t.length()){
            return false;
        }
        String result= s+s;
        if(result.contains(t)){
            return true;
        }
        return false;
    }

    //check if one string is present in another string:
//    public boolean ifStringPresentCheck(String s, String t){
//
//    }
    //find duplicate characters in string:
    public static void findDuplicateChar(String str){
        HashMap<Character, Integer> newMap= new HashMap<>();
        for(int i=0; i<str.length(); i++){
            newMap.put(str.charAt(i),newMap.getOrDefault(str.charAt(i),0)+1);
        }
//        int[] arr= new int[str.length()-1];
        for(Map.Entry<Character, Integer> entry: newMap.entrySet()){
            Character c= entry.getKey();
            int count = entry.getValue();
            if(count>1){
//                arr[c]+=newMap.get(c);
                System.out.println(c+": "+count);
            }
        }
    }
    //find first non-repeated character in string:
    //example: "hhello" -> e is the first
    public static void nonRepeatedCharacter(String str){
        str= str.replaceAll("\\s","");
        System.out.println(str);
        Map<Character, Integer> newMap= new LinkedHashMap<>();
        for(int i=0; i<str.length(); i++){
            newMap.put(str.charAt(i), newMap.getOrDefault(str.charAt(i),0)+1);
        }
//        System.out.println(newMap);
        for(Map.Entry<Character, Integer> e: newMap.entrySet()){
            if(e.getValue()==1){
                System.out.println(e.getKey());
                break;
            }
        }

    }

    //find all substrings of String:
    //example: "abb" -> a,b,b,ab,bb,abb
    public static void findSubstring(String str){
        for(int i =0; i< str.length(); i++){
            for(int j=i+1; j<=str.length();j++){
                System.out.println(str.substring(i,j));
            }
        }
    }

    //find the length of the string without using prebuilt function:
    public static void findLength(String str){
        int length=0;
        char[] arr= str.toCharArray();
        for(char c: arr){
            length++;
        }
        System.out.println(length);
    }

    //find all permutations of string:
    public static void findPermutation(String str){
        permute(str.toCharArray(), 0, str.length()-1);
    }
    static void permute(char[] arr, int left, int right){
        if(left==right){
            System.out.println(new String(arr));
        }
        else{
            for(int i=left; i<=right; i++){
                swap(arr, left, i);
                permute(arr, left+1, right);
                swap(arr, left, i);
            }
        }
    }
    static void swap(char[] arr, int left, int right){
        char temp= arr[left];
        arr[left]= arr[right];
        arr[right]=temp;
    }

    public static void main(String[] args) {
//        Set1 s= new Set1();
//        //=========
        String str= "abbcd";
//        System.out.println(s.reverseString(str));
//        System.out.println(s.reverseStringUsingBuilder(str));
//        //=========
//        String s1 = "cat";
//        String t1= "cat";
//        System.out.println(s.anagram(s1,t1));
//        //=========
//        System.out.println("Unique Char: "+ s.uniqueChar(s1));
//        System.out.println("Rotation of String Check: "+ s.rotationCheck(s1,t1));
//        //=========
        findDuplicateChar(str);
//        nonRepeatedCharacter(str);
//        findSubstring(str);
//        findPermutation(str);
    }
}
