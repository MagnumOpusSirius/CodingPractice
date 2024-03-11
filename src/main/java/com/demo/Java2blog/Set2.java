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
    //------------------------------------------------------
    //remove duplicate elements from array:
    public static void removeDuplicate(int[] arr){
        Set<Integer> set= new LinkedHashSet<>();

        for(int i=0; i<arr.length; i++){
            set.add(arr[i]);
        }
        Integer[] newArr= new Integer[set.size()];
        set.toArray(newArr);
        System.out.println(Arrays.toString(newArr));

    }

    public static void getFibonacci(int n){
        int i=0;
        int a=0, b=1;
        while(i<n){
            System.out.print(a+" ");

            int temp=a+b;
            a=b;
            b=temp;
            i++;
        }
    }

    static int findClosestToZero(int[] arr){
        int result= Integer.MAX_VALUE;

        for(int num: arr){
            if(Math.abs(num)<Math.abs(result) || num==Math.abs(result)){
                result=num;
            }
        }
        return result;
    }
    //find K closest elements to X in the array:
    //arr={1,2,3,4,5}, k=3, x=2
    static List<Integer> findKClosestElements(int[] arr, int k, int x){
        int start= 0;
        int end=arr.length-1;

        while(end-start>=k){
            if(Math.abs(arr[start]-x)>Math.abs(arr[end]-x)){
                start++;
            }
            else{
                end--;
            }
        }

        List<Integer> list= new ArrayList<>();
        for(int i=start; i<=end;i++){
            list.add(arr[i]);
        }
        return list;
    }

    //check for prime number:
    static boolean primeCheck(int num){
        if(num==0 || num==1){
            return false;
        }
        if(num==2){
            return true;
        }
        for(int i=2; i<=num/2; i++){
            if(num%i==0){
                return false;
            }
        }
        return true;
    }

    static boolean checkPalindrome(String str){
        for(int i=0; i< str.length()/2; i++){
            if(str.charAt(i) != str.charAt(str.length()-i-1)){
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        int[] arr ={10,5,8,20,15};

        int max=  Integer.MIN_VALUE;
        int secMax=  Integer.MIN_VALUE;

        for(int num: arr){
            if(num>max){
                secMax=max;
                max=num;
            }
            else if(num>secMax){
                secMax=num;
            }
        }
        System.out.println(secMax);

    }
}
