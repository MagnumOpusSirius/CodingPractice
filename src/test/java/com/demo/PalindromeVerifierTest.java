package com.demo;

import com.demo.Java2blog.A;
import com.demo.geekforgeek.PalindromeVerifier;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
public class PalindromeVerifierTest {

    @Test
    void isPalindrome_True(){
        //given:
        var str= "1 s pap s 1";
        //when:
        boolean palindrome = PalindromeVerifier.isPalindrome(str);
        //then:
        Assertions.assertTrue(palindrome);


    }

    @Test
    void isPalindrome_False(){
        //given:
        var str= "1 ss pap s 1";
        //when:
        boolean palindrome = PalindromeVerifier.isPalindrome(str);
        //then:
        Assertions.assertFalse(palindrome);
    }

    @Test
    void isPalindrome_Simplify(){
        //given:
        var str= "1 s pap s 1";
        //when:
        String s = PalindromeVerifier.simplifyString(str);
        //then:
        Assertions.assertEquals("1spaps1", s);
    }

}
