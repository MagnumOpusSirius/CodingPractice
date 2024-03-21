package com.demo.backtracking;

import java.util.*;

public class Set1 {
    public List<String> letterCombinations(String digits) {
        Map<Character, String> map= new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        List<String> list= new ArrayList<>();
        //base case:
        if(digits.isEmpty()){
            return new ArrayList<>();
        }
        generateCombinations(digits, 0, new StringBuilder(), map, list);
        return list;
    }
    void generateCombinations(String digits, int currIndex, StringBuilder currCombination, Map<Character, String> map, List<String> list){
        //condition:
        if(currIndex==digits.length()){
            list.add(currCombination.toString());
            // System.out.println(list.toString());
            return;
        }
        char currDigit= digits.charAt(currIndex);//'2'
        // System.out.println(currDigit);
        String letterOptions= map.get(currDigit);//"abc"
        // System.out.println(letterOptions);

        for(int i=0; i<letterOptions.length(); i++){
            char letter= letterOptions.charAt(i);
            currCombination.append(letter);
//            System.out.println(currCombination);
            generateCombinations(digits, currIndex+1, currCombination, map, list);
            // System.out.println(currCombination);
            currCombination.deleteCharAt(currCombination.length()-1);
        }
    }

    public static void main(String[] args) {
        Set1 obj= new Set1();
        System.out.println(obj.letterCombinations("23"));
    }
}
