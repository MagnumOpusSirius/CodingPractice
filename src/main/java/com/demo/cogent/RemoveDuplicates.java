package com.demo.cogent;


import java.util.*;

public class RemoveDuplicates {
    //Question 1:Remove duplicates from string?
    public String removeDuplicateString(String str){

        Set<Character> uniqueSet= new LinkedHashSet<>();
        for(int i=0; i<str.length();i++){
            uniqueSet.add(str.charAt(i));
        }
//        System.out.println(uniqueSet);
        StringBuilder newStr= new StringBuilder(uniqueSet.size());
        for(Character ch: uniqueSet){
            newStr.append(ch);
        }
        String result = newStr.toString();
        return result;
    }

    public static void main(String[] args) {
//        List<Integer> myList= new ArrayList<>();
//        myList.add(5);
//        myList.add(5);
//        myList.add(6);
//        myList.add(7);
//        myList.add(2);
//        myList.add(7);
//        myList.add(2);
//
//        //convert this list to hashset:
//        Set<Integer> uniqueSet= new HashSet<>(myList);
//
//        //convert this hashset back to the list:
//        List<Integer> uniqueList= new ArrayList<>(uniqueSet);
//
//        Collections.sort(uniqueList);
//        System.out.println(uniqueList);
        //============================Question 1==============
        RemoveDuplicates rm= new RemoveDuplicates();
        String str= "Happyhappy123123";

        System.out.println(rm.removeDuplicateString(str));

    }
}
