package com.demo.HackerRank;

import java.util.Arrays;

public class OnbeProblem2 {
    public static void main(String[] args) {

        String input = "cdeb nqxg";
        String target = "love"; //knud, jmtc
        String[] inputArray = input.split("\\s+");
        int shiftAmount = findShiftAmount(inputArray, target);
        System.out.println(Arrays.toString(inputArray));
        if (shiftAmount >= 0) {
            System.out.println("Shift amount needed: " + shiftAmount);
        } else {
            System.out.println("Target string cannot be reached from the input string.");
        }
    }
    public static int findShiftAmount(String[] input, String target) {
        // Check if any input string is already equal to the target string
        for (int i = 0; i < input.length; i++) {
            if (input[i].equals(target)) {
                return 0; // No shift needed, as the input string already matches the target string
            }
        }
        // Iterate through possible shift amounts
        for (int shiftAmount = 1; shiftAmount < 26; shiftAmount++) {
            for(String word: input){
                String shiftedRight = shiftAlphabetically(word, shiftAmount);
                String shiftedLeft = shiftAlphabetically(word, -shiftAmount);
                if (shiftedRight.equals(target)) {
                    shiftArray(input, shiftAmount);
                    return shiftAmount; // Found the matching shift amount
                } else if (shiftedLeft.equals(target)) {
                    shiftArray(input, -shiftAmount);
                    return shiftAmount; // Found the matching shift amount
                }
            }
        }
        return -1; // Target string not found
    }
    public static void shiftArray(String[] array, int shiftAmount) {
        for (int i = 0; i < array.length; i++) {
            array[i] = shiftAlphabetically(array[i], shiftAmount);
        }
    }
    public static String shiftAlphabetically(String input, int shiftAmount){

        int length = input.length();
        shiftAmount=shiftAmount%length;
        char[] shiftedChars = new char[input.length()];
        for(int i =0; i<length; i++){
            char currentChar = input.charAt(i);
            char shiftedChar = shiftCharacter(currentChar, shiftAmount);

            shiftedChars[i] = shiftedChar;
        }
        return new String(shiftedChars);
    }

    public static char shiftCharacter(char c, int shiftAmount) {
        int shiftedValue = (c - 'a' + shiftAmount) % 26;
        if (shiftedValue < 0) {
            shiftedValue += 26; // Wrap around to handle negative values
        }
        char shiftedChar = (char) (shiftedValue + 'a');
        return shiftedChar;
    }
}
