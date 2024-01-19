/**
 *
 * Problem Description
 * Given a string A, partition A such that every substring of the partition is a palindrome.
 *
 * Return the minimum cuts needed for a palindrome partitioning of A.
 *
 *
 *
 * Problem Constraints
 * 1 <= length(A) <= 501
 *
 *
 *
 * Input Format
 * The first and the only argument contains the string A.
 *
 *
 *
 * Output Format
 * Return an integer, representing the minimum cuts needed.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = "aba"
 * Input 2:
 *
 *  A = "aab"
 *
 *
 * Example Output
 * Output 1:
 *
 *  0
 * Output 2:
 *
 *  1
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  "aba" is already a palindrome, so no cuts are needed.
 * Explanation 2:
 *
 *  Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
 *
 *
 */

package DP;

import java.util.Arrays;

public class Palindrome_Partitioning_II {
    boolean[][] palindromeMatrix;

    public int minCut(String A) {
        int n = A.length();
        palindromeMatrix = new boolean[n][n];
        generatePalindromeMatrix(A, n);
        if(palindromeMatrix[0][n-1]) return 0;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return cutPalindrome(A, 0, n-1, dp);
    }

    // Cut Palindrome
    private int cutPalindrome(String str, int i, int n, int[] dp) {
        if(palindromeMatrix[i][n]) return 0;
        if(dp[i] != -1) return dp[i];
        int min = n-1;
        for(int k=i; k<n; k++) {
            if(palindromeMatrix[i][k])
                min = Math.min(min, cutPalindrome(str, k+1, n, dp));
        }

        dp[i] = min + 1;
        return dp[i];
    }

    private boolean checkPalindrome(int i, int j) {
        return palindromeMatrix[i][j];
    }

    // Generate Palindrome matrix
    private void generatePalindromeMatrix(String str, int n) {
        for(int gap=0; gap<n; gap++) {
            for(int i=0, j=gap; j<n; i++,j++) {
                if(gap == 0) {
                    palindromeMatrix[i][j] = true;
                }
                else if(gap == 1) {
                    palindromeMatrix[i][j] = str.charAt(i) == str.charAt(j);
                }
                else {
                    if(str.charAt(i) == str.charAt(j)) {
                        palindromeMatrix[i][j] = palindromeMatrix[i+1][j-1];
                    }
                    else {
                        palindromeMatrix[i][j] = false;
                    }
                }
            }
        }
    }

}
