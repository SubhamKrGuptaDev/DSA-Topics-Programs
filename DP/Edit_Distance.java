/**
 *
 *
 *
 *
 */


package DP;

import java.util.Arrays;

public class Edit_Distance {

    // Brute Force Approach With backtracking
    public int minDistanceBruteForce(String A, String B) {
        return solution(new StringBuilder(A), new StringBuilder(B), A.length()-1, B.length()-1);
    }

    private int solution(StringBuilder s1, StringBuilder s2, int n, int m) {
        if(n < 0 && m < 0) {
            return 0;
        }

        if(n < 0) return m + 1;

        if(m < 0) return n + 1;

        if(s1.charAt(n) == s2.charAt(m)) {
            return solution(s1, s2, n-1, m-1);
        }
        else {
            return Math.min(solution(s1,s2,n-1,m),
                    Math.min(solution(s1,s2,n,m-1), solution(s1,s2,n-1,m-1))) + 1;
        }

    }

    // Optimized Solution DP Approach
    public int minDistanceDP(String A, String B) {
        int n = A.length();
        int m = B.length();
        int[][] dp = new int[n][m];
        for(int[] temp : dp) {
            Arrays.fill(temp, -1);
        }
        return solution(new StringBuilder(A), new StringBuilder(B), n-1, m-1, dp);
    }

    private int solution(StringBuilder s1, StringBuilder s2, int n, int m, int[][] dp) {
        if(n < 0 && m < 0) {
            return 0;
        }

        if(n < 0) return m + 1;

        if(m < 0) return n + 1;

        if(dp[n][m] != -1) {
            return dp[n][m];
        }

        if(s1.charAt(n) == s2.charAt(m)) {
            dp[n][m] = solution(s1, s2, n-1, m-1, dp);
        }
        else {
            dp[n][m] = Math.min(solution(s1,s2,n-1,m, dp),
                    Math.min(solution(s1,s2,n,m-1, dp), solution(s1,s2,n-1,m-1, dp))) + 1;
        }

        return dp[n][m];
    }
    public static void main(String[] args) {

    }

}
