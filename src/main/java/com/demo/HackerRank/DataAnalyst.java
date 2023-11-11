package com.demo.HackerRank;

import java.util.List;
import java.util.List;
import java.util.ArrayList;
public class DataAnalyst {

    //as an intial task data for n days is prvoided to the intern, THen K updates are performed on the data
    // where each update is of the form [l,r].


    public static List<Integer> getFinalData(List<Integer> data, List<List<Integer>> updates) {
//        for (List<Integer> update : updates) {
//            int startIndex = update.get(0)-1;
//            int endIndex = update.get(1);
//
//            if (startIndex >= 0 && startIndex < data.size() && endIndex >= 0 && endIndex <= data.size()) {
//                for (int i = startIndex; i < endIndex; i++) {
//                    data.set(i, -data.get(i)); // Change the sign of values in the specified range
//                }
//            }
//        }
//
//        return data;
        return updates.stream()
                .filter(update -> {
                    int startIndex = update.get(0) - 1; // Adjust the start index
                    int endIndex = update.get(1);
                    return startIndex >= 0 && startIndex < data.size() &&
                            endIndex >= 0 && endIndex <= data.size();
                })
                .peek(update -> {
                    int startIndex = update.get(0) - 1; // Adjust the start index
                    int endIndex = update.get(1);
                    for (int i = startIndex; i < endIndex; i++) {
                        data.set(i, -data.get(i)); // Change the sign of values in the specified range
                    }
                })
                .count() > 0 ? data : new ArrayList<>(data); // Return a new list to avoid modifying the original
    }

    public static void main(String[] args){
        List<Integer> data= new ArrayList<>();
        data.add(3);
        data.add(1);
        data.add(3);
        data.add(0);
        data.add(7);

        List<List<Integer>> updates= new ArrayList<>();
        List<Integer> update1= new ArrayList<>();
        update1.add(1);
        update1.add(4);

        updates.add(update1);

        List<Integer> finalData= getFinalData(data, updates);
        System.out.println(finalData);
    }
}
