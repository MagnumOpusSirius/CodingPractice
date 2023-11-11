package com.demo.practice;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyThread extends Thread {
    public static void main(String[] args) {
        ExecutorService ex=Executors.newFixedThreadPool(6);//for reusing the pools
        //we can submit task to the thread pool:
        for(int i =0; i< 10; i++){
            ex.submit(() -> System.out.println("hello "+currentThread().getName()));
        }
        ex.shutdown();
//        MyThread t1= new MyThread();//in the new stage or thread object created
//        t1.start(); //in the runnable state
        // scheduler comes and drops it to the running stage or run()
        //after run() is over it goes to dead state.
    }
//    @Override
//    public void run(){
//        System.out.println("hello");
//    }

}
