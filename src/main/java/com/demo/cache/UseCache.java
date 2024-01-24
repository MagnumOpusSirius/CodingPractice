package com.demo.cache;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//
public class UseCache {
    public static void main(String[] args) throws IOException {
        //define cache:
        LRUCache<Integer> cache= new LRUCache<>(3);
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        int choice=1;
        while(choice!= 0){
            System.out.println("1: Put\n2: Get\n0: Exit");
            choice=Integer.parseInt(br.readLine());
            String key;
            //define value
            int value;
            switch (choice){
                case 1:
                    System.out.println("Enter key");
                    key=br.readLine();
                    System.out.println("Enter value");
                    //read value
                    value= Integer.parseInt(br.readLine());
                    //put in cache
                    cache.put(key,value);
                    System.out.println("Inserted\n");
                    break;
                case 2:
                    System.out.println("Enter key");
                    key=br.readLine();
                    //print value:
                    System.out.println("Value is: "+cache.get(key).toString()+"\n");
                    break;
                default:
                    System.out.println("Bye");
            }
        }
    }
}
