package com.demo.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Leetcode290 {
    public boolean wordPattern(String pattern, String s) {
        //for that character key associate that string word value
        Map<Character, String> map= new HashMap<>();
        //split the s to word:
        String[] split= s.split(" ");
        if(pattern.length()!=split.length)return false;
        // System.out.println(Arrays.toString(split));
        for(int i=0; i< pattern.length(); i++){
            char ch= pattern.charAt(i);
            if(map.containsValue(split[i]) && !map.containsKey(ch)){
                //if the value is already present and key is not present
                //example: "abba", "dog dog dog dog"
                return false;
            }if(map.containsKey(ch) && !map.get(ch).equals(split[i])){
                //if the key is present and value is not equal to the value in map
                //example: "abba", "dog cat cat fish"
                return false;
            }
            else{
                map.put(ch, split[i]);
            }
        }

        return true;
    }

//    public static void main(String[] args) {
//        Leetcode290 obj= new Leetcode290();
//        System.out.println(obj.wordPattern("abba", "dog cat cat dog"));
//    }
}
