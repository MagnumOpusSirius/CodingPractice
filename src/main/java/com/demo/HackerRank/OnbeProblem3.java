package com.demo.HackerRank;

import java.util.Arrays;

public class OnbeProblem3 {
    public static void main(String[] args) {
        int[] array1 = {1, 2, 3, 4, 5};
        int[] array2 = {6, 7, 8,1,1};

        int[] sumArray = sumArrays(array1, array2);

        System.out.print("Sum Array: ");
        for (int num : sumArray) {
            System.out.print(num + " ");
        }
    }

    public static int[] sumArrays(int[] array1, int[] array2) {
        int maxLength = Math.max(array1.length, array2.length);
        int[] sumArray = new int[maxLength + 1]; // Extra digit for possible carryover
        int carryover = 0;

        for (int i = 1; i <= maxLength; i++) {
            int num1 = (i <= array1.length) ? array1[array1.length - i] : 0;
            int num2 = (i <= array2.length) ? array2[array2.length - i] : 0;
            int sum = num1 + num2 + carryover;
            sumArray[maxLength + 1 - i] = sum % 10; // Store the least significant digit
            carryover = sum / 10; // Update carryover for the next addition
        }

        // Store any remaining carryover
        sumArray[0] = carryover;

        // Trim leading zeros if any
        if (sumArray[0] == 0) {
            sumArray = Arrays.copyOfRange(sumArray, 1, sumArray.length);
        }

        return sumArray;
    }
}
