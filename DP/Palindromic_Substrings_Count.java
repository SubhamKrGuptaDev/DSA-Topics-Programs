/**
 *
 * Given a string A consisting of lowercase English alphabets. Your task is to find how many substrings of A are palindrome.
 *
 * The substrings with different start indexes or end indexes are counted as different substrings even if they consist of same characters.
 *
 * Return the count of palindromic substrings.
 *
 * Note: A string is palindrome if it reads the same from backward and forward.
 *
 *
 * Input Format
 *
 * The only argument given is string A.
 * Output Format
 *
 * Return the count of palindromic substrings.
 * Constraints
 *
 * 1 <= length of the array <= 1000
 * For Example
 *
 * Input 1:
 *     A = "abab"
 * Output 1:
 *     6
 * Explanation 1:
 *     6 palindromic substrings are:
 *     "a", "aba", "b", "bab", "a" and "b".
 *
 * Input 2:
 *     A = "ababa"
 * Output 2:
 *     9
 * Explanation 9:
 *     9 palindromic substrings are:
 *     "a", "a", "a", "b", "b" , "aba" ,"bab", "aba" and "ababa".
 *
 *
 *
 */


package DP;

public class Palindromic_Substrings_Count {

    // Brute Force Approach
    public int countSubstrings(String s) {
        int totalCount = 0;
        for(int k = 0; k < s.length(); k++)
        {
            int count = 1;
            for(int j = k + 1; j < s.length(); j++)
            {
                if(isPalindrome(s, k, j)) count++;
            }
            totalCount += count;
        }
        return totalCount;
    }

    public boolean isPalindrome(String s, int left, int right)
    {
        while(left < right)
        {
            if(s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }

    // DP Approach
    public int solve(String A) {
        int n = A.length();
        boolean[][] dp = new boolean[n][n];
        int count = 0;

        for(int gap =0; gap < n; gap++) {
            for(int i=0, j=gap; j<n; i++,j++) {
                boolean temp = A.charAt(i) == A.charAt(j);
                if(gap == 0) {
                    dp[i][j] = true;
                    count++;
                }
                else if(gap == 1) {
                    if(temp) {
                        count++;
                    }
                    dp[i][j] = temp;
                }
                else {
                    if(temp) {
                        dp[i][j] = dp[i+1][j-1];
                        if(dp[i][j])
                            count++;
                    }
                    else {
                        dp[i][j] = false;
                    }
                }
            }
        }

        return count;
    }

    // Another DP Approach
    public int countSubstringsDP(String s) {
        int n = s.length();
        boolean [][] dp = new boolean[n][n];
        int count = 0;
        for(int k = n -1; k >= 0; k--)
        {
            for(int j = k; j < n; j++)
            {
                if(s.charAt(k) == s.charAt(j) && (j - k < 2 || dp[k+1][j-1]))
                {
                    dp[k][j] = true;
                    count++;
                }
            }
        }
        return count;
    }

    // Even Odd Palindrome Check (Manacher's Algorithm)
    public int countSubstringsEvenOdd(String s) {
        if(s.length() == 0) return 0;
        int odd = 0;
        int even = 0;
        for(int k = 0; k < s.length(); k++)
        {
            odd += checking(s, k, k);
            even += checking(s, k, k + 1);
        }
        return odd + even;
    }

    public int checking(String s, int left, int right)
    {
        int count = 0;
        while(left <= right && left >= 0 && right < s.length() &&  s.charAt(left) == s.charAt(right))
        {
            count++;
            left--;
            right++;
        }
        return count;
    }

    public static void main(String[] args) {

    }

}
