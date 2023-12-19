package com.demo.practice;

//make the constructor private:
public class Singleton {
    private Singleton(){

    }

    private static Singleton instance;

    //write a function that gives us that instance

    public static Singleton getInstance(){
        //check if an object has been created or not:
        if(instance == null){
            instance = new Singleton();
        }
        return instance;
    }
}
