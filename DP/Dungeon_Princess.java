/**
 *
 * Problem Description
 * The demons had captured the princess and imprisoned her in the bottom-right corner of
 * a dungeon. The dungeon consists of M x N rooms laid out in a 2D grid. Our valiant knight
 * was initially positioned in the top-left room and must fight his way through the dungeon
 * to rescue the princess.
 *
 * The knight has an initial health point represented by a positive integer. If at any point
 * his health point drops to 0 or below, he dies immediately.
 *
 * Some of the rooms are guarded by demons, so the knight loses health (negative integers)
 * upon entering these rooms; other rooms are either empty (0's) or contain magic orbs that
 * increase the knight's health (positive integers).
 *
 * In order to reach the princess as quickly as possible, the knight decides to move only
 * rightward or downward in each step.
 *
 * Given a 2D array of integers A of size M x N. Find and return the knight's minimum initial
 * health so that he is able to rescue the princess.
 *
 *
 *
 * Problem Constraints
 * 1 <= M, N <= 500
 *
 * -100 <= A[i] <= 100
 *
 *
 *
 * Input Format
 * First and only argument is a 2D integer array A denoting the grid of size M x N.
 *
 *
 *
 * Output Format
 * Return an integer denoting the knight's minimum initial health so that he is able to
 * rescue the princess.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [
 *        [-2, -3, 3],
 *        [-5, -10, 1],
 *        [10, 30, -5]
 *      ]
 * Input 2:
 *
 *  A = [
 *        [1, -1, 0],
 *        [-1, 1, -1],
 *        [1, 0, -1]
 *      ]
 *
 *
 * Example Output
 * Output 1:
 *
 *  7
 * Output 2:
 *
 *  1
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  Initially knight is at A[0][0].
 *  If he takes the path RIGHT -> RIGHT -> DOWN -> DOWN, the minimum health required
 *  will be 7.
 *  At (0,0) he looses 2 health, so health becomes 5.
 *  At (0,1) he looses 3 health, so health becomes 2.
 *  At (0,2) he gains 3 health, so health becomes 5.
 *  At (1,2) he gains 1 health, so health becomes 6.
 *  At (2,2) he looses 5 health, so health becomes 1.
 *  At any point, the health point doesn't drop to 0 or below. So he can rescue the
 *  princess with minimum health 7.
 *
 * Explanation 2:
 *
 *  Take the path DOWN -> DOWN ->RIGHT -> RIGHT, the minimum health required will be 1.
 *
 *
 */


package DP;

import java.util.ArrayList;
import java.util.Arrays;

public class Dungeon_Princess {

    // Recursive Solution
    int grid[][];
    int dp[][];
    int inf = 1000000000;
    int solve(int x, int y){
        if (x >= grid.length || y >= grid[0].length) return inf;
        if (x == grid.length-1 && y == grid[0].length-1){
            return  (grid[x][y] <= 0 ? 1 - grid[x][y] : 1);
        }
        if (dp[x][y] != -1) return dp[x][y];
        int opt1 = solve(x+1,y);
        int opt2 = solve(x,y+1);
        return dp[x][y] = Math.max(1,Math.min(opt1,opt2)-grid[x][y]);
    }

    public int calculateMinimumHP(int[][] dungeon) {
        grid = dungeon;
        dp = new int[grid.length][grid[0].length];
        for (int i=0;i<grid.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(0,0);
    }

    // Iterative Code
    public int calculateMinimumHPIterativeSolution(ArrayList<ArrayList<Integer>> A) {
        int n = A.size();
        int m = A.get(0).size();

        int[][] dp = new int[n][m];

        return findPrincess(A, n, m, dp);
    }

    private int findPrincess(ArrayList<ArrayList<Integer>> mat, int n, int m, int[][] dp) {
        // last cell
        if(mat.get(n-1).get(m-1) > 0) {
            dp[n-1][m-1] = 1;
        }
        else {
            dp[n-1][m-1] = (1 - mat.get(n-1).get(m-1)) + 1;
        }

        // Column
        for(int j=m-2; j>=0; j--) {
            dp[n-1][j] = Math.max(1, dp[n-1][j+1] - mat.get(n-1).get(j));
        }

        // Row
        for(int i=n-2; i>=0; i--) {
            dp[i][m-1] = Math.max(1, dp[i+1][m-1] - mat.get(i).get(m-1));
        }

        for(int i=n-2; i>=0; i--) {
            for(int j=m-2; j>=0; j--) {
                dp[i][j] = Math.max(1, Math.min(dp[i+1][j], dp[i][j+1]) - mat.get(i).get(j));
            }
        }

        return dp[0][0];
    }


    public static void main(String[] args) {

    }

}
