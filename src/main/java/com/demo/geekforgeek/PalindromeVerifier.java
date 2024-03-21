package com.demo.geekforgeek;

public class PalindromeVerifier {
    public static boolean isPalindrome(String str){
        //lets simplify the string:
        var s = simplifyString(str);
        String reverse="";
//        var result= new StringBuilder(s).reverse().toString();
//        return result.equals(s);
        for(int i = s.length()-1; i>=0; i--){
            reverse+=(s.charAt(i));
        }
        if(reverse.equals(s)){
            return true;
        }
        else{
            return false;
        }
    }

    public static String simplifyString(String str){
        return str.toLowerCase().replaceAll("[^a-z0-9]", "");
    }


}
