package com.demo.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
if array contains duplicates,
    it returns true
    else false
 */
public class Leetcode217 {
    public boolean containsDuplicates(int[] arr){
        Set<Integer> mySet= new HashSet<>();

        for(int i: arr){
            if(mySet.contains(i)){
                return true;
            }
            mySet.add(i);
        }
        return false;
    }
    public static void main(String[] args) {
        Leetcode217 ls= new Leetcode217();
        int[] arr= {1,2,3,4};
        System.out.println(ls.containsDuplicates(arr));
        
    }
}
