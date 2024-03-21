package com.demo.geekforgeek;

import java.util.Stack;

public class BrowserHistory {
    private Stack<String> history;
    public BrowserHistory(){
        history= new Stack<>();
    }

   public void visit(String url){
       history.push(url);
   }
   public void back(){
        if(!history.isEmpty()){
            history.pop();
            if(!history.isEmpty()){
                System.out.println("going back to: "+ history.peek());
            }else{
                System.out.println("No previous page");
            }
        }
        else{
            System.out.println("no history");
        }
   }

   public static void main(String[] args) {
        BrowserHistory browser= new BrowserHistory();

       browser.visit("https://www.google.com");
       browser.visit("https://www.wikipedia.org");
       browser.visit("https://www.youtube.com");

       browser.back();
       browser.back();
   }

}
