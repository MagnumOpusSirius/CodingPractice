package com.demo.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

//write unit test cases for LeetCode290 class
public class LeetCode290Test {
    //have to create an object of LeetCode290 class
    //call the method and check the result

    @Test
    void test1() {
        //given
        String pattern = "abba";
        String s = "dog cat cat dog";
        //when
        Leetcode290 obj = new Leetcode290();
        boolean result = obj.wordPattern(pattern, s);
        Assertions.assertTrue(result);
    }

    @Test
    void test2() {
        //given
        String pattern = "abba";
        String s = "dog cat cat fish";
        //when
        Leetcode290 obj = new Leetcode290();
        boolean result = obj.wordPattern(pattern, s);
        Assertions.assertFalse(result);
    }

    @Test
    void test3() {
        //given
        String pattern = "abba";
        String s = "dog dog dog dog";
        //when
        Leetcode290 obj = new Leetcode290();
        boolean result = obj.wordPattern(pattern, s);
        Assertions.assertFalse(result);
    }
}
