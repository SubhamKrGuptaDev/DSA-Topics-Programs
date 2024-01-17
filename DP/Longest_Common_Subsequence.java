/**
 *
 * Problem Description
 * Given two strings A and B. Find the longest common subsequence ( A sequence which does not need to be contiguous), which is common in both the strings.
 *
 * You need to return the length of such longest common subsequence.
 *
 *
 *
 * Problem Constraints
 * 1 <= Length of A, B <= 1005
 *
 *
 *
 * Input Format
 * First argument is a string A.
 * Second argument is a string B.
 *
 *
 *
 * Output Format
 * Return an integer denoting the length of the longest common subsequence.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = "abbcdgf"
 *  B = "bbadcgf"
 * Input 2:
 *
 *  A = "aaaaaa"
 *  B = "ababab"
 *
 *
 * Example Output
 * Output 1:
 *
 *  5
 * Output 2:
 *
 *  3
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  The longest common subsequence is "bbcgf", which has a length of 5.
 * Explanation 2:
 *
 *  The longest common subsequence is "aaa", which has a length of 3.
 *
 *
 */


package DP;

public class Longest_Common_Subsequence {

    // Brute Force Approach
    public int solveBruteForce(String A, String B) {
        return lcs(A,B, A.length() - 1, B.length() - 1);
    }

    private int lcs(String s1, String s2, int n, int m) {

        if(n < 0 || m < 0) return 0;

        if(s1.charAt(n) == s2.charAt(m)) {
            return lcs(s1, s2, n-1, m-1) + 1;
        }
        else {
            return Math.max(lcs(s1, s2, n-1, m), lcs(s1, s2, n, m-1));
        }
    }

    // DP Approach TC: O(N * M)
    public int solve(String A, String B) {
        int[][] dp = new int[A.length()][B.length()];
        return lcs(A,B, A.length() - 1, B.length() - 1, dp);
    }

    private int lcs(String s1, String s2, int n, int m, int[][] dp) {

        if(n < 0 || m < 0) return 0;

        if(dp[n][m] != 0) {
            return dp[n][m];
        }

        if(s1.charAt(n) == s2.charAt(m)) {
            dp[n][m] = lcs(s1, s2, n-1, m-1, dp) + 1;
        }
        else {
            dp[n][m] = Math.max(lcs(s1, s2, n-1, m, dp), lcs(s1, s2, n, m-1, dp));
        }
        return dp[n][m];
    }

}
