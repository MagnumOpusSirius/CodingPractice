package com.demo.HackerRank;

public class StringSet1 {

    static String modifyString(String[] input){
        StringBuilder builder= new StringBuilder();
        //append the string;
        for(String num: input){
            builder.append(num);
        }
//        System.out.println(builder.toString());
        //remove the numbers:
        String output=builder.toString().replaceAll("[0-9]","");
//        System.out.println(output);
        return firstCharCapital(output);
    }
    static String firstCharCapital(String output){
        StringBuilder builder= new StringBuilder();

        if(Character.isLetter(output.charAt(0))){
            builder.append(output.toUpperCase().charAt(0));
        }
        for(int i=1; i<output.length(); i++){
            //if previous char is not a letter and current is a letter:
            //then capitalize current character:
            if(!Character.isLetter(output.charAt(i-1)) && Character.isLetter(output.charAt(i))){
                builder.append(output.toUpperCase().charAt(i));
            }else{
                builder.append(output.charAt(i));
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        String[] input= {"break3ing news5:"," 1A 1circle is round!"};
        System.out.println(modifyString(input));
    }
}
