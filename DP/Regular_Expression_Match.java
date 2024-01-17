/**
 *
 * Problem Description
 * Implement wildcard pattern matching with support for ' ? ' and ' * ' for strings A and B.
 *
 * ' ? ' : Matches any single character.
 * ' * ' : Matches any sequence of characters (including the empty sequence).
 * The matching should cover the entire input string (not partial).
 *
 *
 *
 * Problem Constraints
 * 1 <= length(A), length(B) <= 104
 *
 *
 *
 * Input Format
 * The first argument of input contains a string A.
 * The second argument of input contains a string B.
 *
 *
 *
 * Output Format
 * Return 1 if the patterns match else return 0.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = "aaa"
 *  B = "a*"
 * Input 2:
 *
 *  A = "acz"
 *  B = "a?a"
 *
 *
 * Example Output
 * Output 1:
 *
 *  1
 * Output 2:
 *
 *  0
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  Since '*' matches any sequence of characters. Last two 'a' in string A will be match by '*'.
 *  So, the pattern matches we return 1.
 * Explanation 2:
 *
 *  '?' matches any single character. First two character in string A will be match.
 *  But the last character i.e 'z' != 'a'. Return 0.
 *
 *
 */

package DP;

public class Regular_Expression_Match {
    boolean[][] dp, dpTrack;
    public int isMatch(final String A, final String B) {
        int n = A.length();
        int m = B.length();
        dp = new boolean[n][m];
        dpTrack = new boolean[n][m];

        return checkPattern(A, B, n-1, m-1) ? 1 : 0;
    }

    public boolean checkPattern(String s1, String s2, int n, int m) {

        if(n < 0 && m < 0) return true;
        else if(n < 0 && s2.charAt(m) == '*' && checkAllStars(s2, m)) return true;
        else if(n < 0 || m < 0) return false;

        if(dpTrack[n][m] == true) return dp[n][m];

        if(s1.charAt(n) == s2.charAt(m) || s2.charAt(m) == '?') {
            dp[n][m] = checkPattern(s1, s2, n-1, m-1);
        }
        else if(s2.charAt(m) == '*'){
            dp[n][m] = checkPattern(s1, s2, n, m-1);
            if(!dp[n][m])
                dp[n][m] = checkPattern(s1, s2, n-1, m);
        }
        else {
            dp[n][m] = false;
        }
        dpTrack[n][m] = true;
        return dp[n][m];
    }

    private boolean checkAllStars(String s1, int end) {
        for(int i=0; i<=end; i++) {
            if(s1.charAt(i) != '*') return false;
        }
        return true;
    }
}
