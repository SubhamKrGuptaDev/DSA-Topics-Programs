/**
 *
 * The task is to count all the possible paths from top left to bottom right of a m X n matrix with the constraints that from each cell you can either move only to right or down.
 *
 * Example 1:
 *
 * Input: m = 2, n = 2
 * Output: 2
 * Explanation: Two possible ways are
 * RD and DR.
 *
 * Example 2:
 *
 * Input: m = 3, n = 3
 * Output: 6
 * Explanation: Six possible ways are
 * RRDD, DDRR, RDDR, DRRD, RDRD, DRDR.
 *
 * Your Task:
 * You dont need to read input or print anything. Complete the function numberOfPaths() which takes m and n as input parameter and returns count all the possible paths.The answer may be very large, compute the answer modulo 109 + 7.
 *
 *
 * Expected Time Complexity: O(m*n)
 * Expected Auxiliary Space: O(m*n)
 *
 * Constraints:
 * 1 <= m <=100
 * 1 <= n <=100
 *
 *
 *
 */


package DP;

import java.util.Arrays;

public class Count_all_possible_paths_from_top_left_to_bottom_right {

    // Top-Down
    long numberOfPathsTopDown(int n, int m)
    {
        int[][] dp = new int[n][m];
        for(int[] temp : dp) {
            Arrays.fill(temp, -1);
        }
        int mod = 1000 * 1000 * 1000 + 7;
        return memorizationApproach(dp, n-1, m-1, mod);
    }

    private long memorizationApproach(int[][] dp, int n, int m, int mod) {
        if(n == 0 || m == 0) {
            return 1L;
        }

        if(dp[n][m] != -1) return (long)(dp[n][m] % mod);

        dp[n][m] = (((int)memorizationApproach(dp, n, m-1, mod)) + ((int)memorizationApproach(dp, n-1, m, mod)) % mod);
        return (long)(dp[n][m] % mod);
    }

    // Bottom-Up
    private long numberOfPathsBottomUpApproach(int n, int m)
    {
        // code here
        int[][] dp = new int[n][m];
        int mod = 1000 * 1000 * 1000 + 7;
        for(int i=0; i<n; i++) {
            dp[i][0] =  1;
        }

        for(int j=0; j<m; j++) {
            dp[0][j] = 1;
        }

        for(int i=1; i<n; i++) {
            for(int j=1; j<m; j++) {
                dp[i][j] = (dp[i][j-1] + dp[i-1][j]) % mod;
            }
        }

        return (long)dp[n-1][m-1];
    }

}
