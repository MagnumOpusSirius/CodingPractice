package com.demo.streamAPI;


import java.util.*;

/*
Question 17:
Convert a list of object into a map by considering duplicated keys
 */
public class Set2 {
    int num;
    String note;
    int count;

    public Set2(int num, String note, int count){
        this.num=num;
        this.note=note;
        this.count=count;
    }
    public static void main(String[] args) {
        List<Set2> list= new ArrayList<>();
        list.add(new Set2(1, "note1", 11));
        list.add(new Set2(2, "note2", 22));
        list.add(new Set2(3, "note3", 33));
        list.add(new Set2(4, "note4", 44));

    }
}
