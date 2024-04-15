/*
given n by n matrix, find all ways to 
place the Lx1 table such that it does not collide with k pillars 
with their position given
*/


public class DinnerTable{
    public static int placeTable(int n, int L){
        //set up a grid to mark pillars:
        boolean[][] grid = new boolean[n][n];
        for(int i =0; i< n; i++){
            int row = (4*i*i + 7*i) % n;
            int col = (i*i*i + 8*i + 13) % n;
            grid[row][col] = true; //mark pillar positions as true
        }

        int count=0; //our answer
        for(int row = 0; row<n; row++){
            for(int col =0; col<n; col++){
                if(placeHoriz(row, col, n, grid, L)){
                    count++;
                }
                if(placeVert(row, col, n, grid, L)){
                    count++;
                }
            }
        }
        return count;
    }
    private static boolean placeHoriz(int row, int col, int n, boolean[][] grid, int L){
        if(col + L > n){
            return false;
        }
        //check if it collides with pillar:
        for(int i=0; i<L; i++){
            if(grid[row][col+i]){
                return false;
            }
        }
        return true;
    }
    private static boolean placeVert(int row, int col, int n, boolean[][] grid, int L){
        if(row + L > n){
            return false;
        }
        //check if it collides with pillar:
        for(int i=0; i<L; i++){
            if(grid[row+i][col]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int n=3; //matrix size
        int L =2;
        int count = placeTable(n, L);
        System.out.println("Number of possible placements: " + count);
    }

}