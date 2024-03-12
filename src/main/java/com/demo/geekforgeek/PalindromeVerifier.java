package com.demo.geekforgeek;

public class PalindromeVerifier {
    public static boolean isPalindrome(String str){
        //lets simplify the string:
        var s = simplifyString(str);
        var result= new StringBuilder(s).reverse().toString();
        return result.equals(s);
    }

    public static String simplifyString(String str){
        return str.toLowerCase().replaceAll("[^a-z0-9]", "");
    }


}
