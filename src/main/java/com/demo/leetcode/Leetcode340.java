package com.demo.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Leetcode340 {
    //given a string s and an integer k,
    // return the length of the longest substring of s
    // that contains at most k distinct characters
    public static int lengthOfLongestSubstringKDistinct(String s, int k){
        //sliding window:
        int left=0;
        int maxLen=0;
        Map<Character, Integer> map= new HashMap<>();

        for(int right=0;right<s.length(); right++){
            char c= s.charAt(right);
            map.put(c, map.getOrDefault(c, 0)+1);
            //shrink logic: if size > k
            while(map.size()>k){
                char cLeft= s.charAt(left);
                map.put(cLeft, map.getOrDefault(cLeft, 0)-1);
                if(map.get(cLeft)==0){
                    map.remove(cLeft);
                }
                left++;
            }
            maxLen=Math.max(maxLen, right-left+1);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String s ="ccaabbb";
        int k=2; //output: 3
        String s1 ="aa";
        int k1=1; //output: 2
        System.out.println(lengthOfLongestSubstringKDistinct(s,k));

    }
}
