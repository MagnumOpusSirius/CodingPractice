package com.demo.leetcode;

import java.util.*;

public class Leetcode49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(String word: strs){
            char[] c= word.toCharArray();
            Arrays.sort(c);
            String newWord = new String(c);
            if(!map.containsKey(newWord)){
                System.out.println(map);
                map.put(newWord, new ArrayList<>());
            }
            map.get(newWord).add(word);
        }
        return new ArrayList<>(map.values());
    }
    public static void main(String[] args) {
        String[] strs= {"eat","tea","tan","ate","nat","bat"};
        Leetcode49 lc49= new Leetcode49();
        System.out.println(lc49.groupAnagrams(strs));

    }
}
