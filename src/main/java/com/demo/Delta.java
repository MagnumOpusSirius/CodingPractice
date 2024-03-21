package com.demo;

import java.util.Arrays;

/*
The floor of our dining room is a rectangle divided into a grid of R by C unit square tiles.
The tiles have integer coordinates ranging from (0, 0) to (R-1, C-1).

Some of the tiles are empty, others contain pillars that support the roof.
There are at most N pillars (explained below).

We want to place a L x 1 dining table somewhere into the dining room.
The table must be placed parallel to one of the sides and it must cover exactly L empty tiles.

In other words, the table must be placed either "horizontally" or "vertically", and it must avoid all pillars.

You are given the dimensions of the dining room and the table, and the coordinates of all pillars (as described below).

Return the number of ways in which the table can be placed.



In order to keep the input small, we will simply pick one specific pattern for the pillars:

Let r(i) = (4*i*i + 7*i) modulo R.
Let c(i) = (i*i*i + 8*i + 13) modulo C.
For each i from 0 to N-1, inclusive, the tile with coordinates (r(i), c(i)) contains a pillar.
No other tile contains a pillar.

Definition

Class: DinnerTable
Method: count
Parameters: int, int, int, int
Returns: long
Method signature: long count(int R, int C, int L, int N)
(be sure your method is public)
 */
public class Delta {

    public long count(int R, int C, int L, int N){
        long totalWays=0;
        for(int i=0; i< R-L; i++){
            for(int j=0; j< C-L; j++){
                if(isValidPlacement(i, j, L, N, R, C)){
                    totalWays++;
                }
            }
        }
        return totalWays;
    }

    boolean isValidPlacement(int startRow, int startCol, int L, int N, int R, int C){
        for(int i=0; i<N; i++){
            int pillarRow = (4 * i * i + 7 * i) % R;
            int pillarCol = (i * i * i + 8 * i + 13) % C;
            System.out.println("pillarRow : "+ pillarRow + " and pillarCol : "+ pillarCol);
            //check if the pillar is under the dining table:
            //if it is then we return false
            //else return true

            //pillarRow>=startRow -> pillar at or below the table:
            //pillarRow>=startRow -> pillar above the table
            //pillarCol >= startCol -> pillar is to right or same position as table
            //pillarCol < startCol + L -> pillar is left of table
            if(pillarRow>=startRow && pillarRow < startRow +L && pillarCol >= startCol && pillarCol < startCol + L){
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        Delta delta= new Delta();

        int R = 5, C = 5, L = 3, N = 2;
        long result= delta.count(R,C, L, N);
        System.out.println(result);

    }


}
