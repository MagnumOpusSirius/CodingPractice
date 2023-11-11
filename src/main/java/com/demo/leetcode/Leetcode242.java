package com.demo.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Leetcode242 {
    public boolean isAnagram(String s, String t){
        Map<Character, Integer> count= new HashMap<>();

        for(char c: s.toCharArray()){
            count.put(c, count.getOrDefault(c, 0)+1);
        }
        System.out.println(count);
        for(char c: t.toCharArray()){
            count.put(c, count.getOrDefault(c, 0)-1);
        }

        for(int val: count.values()){
            if(val!=0){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Leetcode242 lc242= new Leetcode242();
        String s= "cat";
        String t= "act";

        System.out.println(lc242.isAnagram(s, t));
    }
}
