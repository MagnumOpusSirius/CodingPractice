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
    //rectangular dining room divided into grid of tiles, some of which are empty
    //some contain pillars.
    public long count(int R, int C, int L, int N){

        boolean[][] pillars= new boolean[R][C];

        //mark the pillar positions on the grid:
        for(int i=0; i< N; i++){
            int pillarRow = (4 * i * i + 7 * i) % R;
            int pillarCol = (i * i * i + 8 * i + 13) % C;
            System.out.println("pillar row = "+ pillarRow+ " and pillar col = "+ pillarCol);
            pillars[pillarRow][pillarCol]= true;
            System.out.println(pillars[pillarRow][pillarCol]);
        }


        long result= 0;

        //go through the all possible positions for the table:
        for(int i=0; i< R; i++){
            for(int j=0; j<C; j++){
                boolean isValid= true;

                //check if the table covers any pillars
                //if it does set the isValid to be false:
                for(int r = i; r<i+L; r++){
                    for(int c =j; c<j+L; c++){
                        //check if the current tile contains the pillar:
                        if(r<R && c<C && pillars[r][c]){
                            isValid= false;
                            break;
                        }
                    }
                    if(!isValid){
                        break;
                    }
                }
                //if placement is valid we increment the result;
                if(isValid){
                    result++;
                }
            }
        }
        return result;

    }

    public static void main(String[] args) {
        Delta delta= new Delta();

        int R = 3, C = 3, L = 2, N = 3;
        long result= delta.count(R,C, L, N);
        System.out.println(result);

    }


}
