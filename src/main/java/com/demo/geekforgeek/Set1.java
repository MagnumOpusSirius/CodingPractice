package com.demo.geekforgeek;

import java.util.HashMap;
import java.util.Map;

public class Set1 {
    static void first_Repeating_And_First_NonRepeating_Element(int[] nums){
        Map<Integer, Integer> map= new HashMap<>();

        for(int num: nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        //find the first repeating element:
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            int key= entry.getKey();
            int value= entry.getValue();
            if(value>1){
                System.out.println("first repeating: "+key);
                break;
            }

        }

        //find the first non-repeating element:
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            int key= entry.getKey();
            int value= entry.getValue();
            if(value==1){
                System.out.println("first non repeating: "+key);
                break;
            }

        }
    }
    public static void main(String[] args) {
        int[] arr= {1,3,5,7,8,5,3,6,7,5};
        first_Repeating_And_First_NonRepeating_Element(arr);
    }
}
