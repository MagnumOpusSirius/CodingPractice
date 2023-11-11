package com.demo.HackerRank;

import java.util.ArrayList;
import java.util.List;

public class SortBinaryMinMoves {
    static int findMinSwaps(int arr[], int n)
    {
        int count = 0;
        int numberOfOnes = 0;
        int minSwaps=Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (arr[i] == 1) {
                numberOfOnes++;
                count += i - numberOfOnes + 1;
            }
        }
        minSwaps= Math.min(count, n-count);

        return minSwaps;
    }

    // Driver Code
    public static void main(String args[])
    {
        int ar[] = { 0, 0, 0, 0, 0, 0, 1, 1 };
        System.out.println(findMinSwaps(ar, ar.length));
    }
}
