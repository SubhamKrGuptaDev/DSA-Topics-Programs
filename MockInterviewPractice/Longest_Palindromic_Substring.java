/**
 *
 * leetcode - https://leetcode.com/problems/longest-palindromic-substring/description/
 *
 * Longest Palindromic Substring
 * Problem Description
 * Given a string A of size N, find and return the longest palindromic substring in A.
 *
 * Substring of string A is A[i...j] where 0 <= i <= j < len(A)
 *
 * Palindrome string:
 * A string which reads the same backwards. More formally, A is palindrome if reverse(A) = A.
 *
 * Incase of conflict, return the substring which occurs first ( with the least starting index).
 *
 *
 *
 * Problem Constraints
 * 1 <= N <= 6000
 *
 *
 *
 * Input Format
 * First and only argument is a string A.
 *
 *
 *
 * Output Format
 * Return a string denoting the longest palindromic substring of string A.
 *
 *
 *
 * Example Input
 * A = "aaaabaaa"
 *
 *
 * Example Output
 * "aaabaaa"
 *
 *
 * Example Explanation
 * We can see that longest palindromic substring is of length 7 and the string is "aaabaaa".
 *
 *
 *
 */


package MockInterviewPractice;

public class Longest_Palindromic_Substring {

    public String longestPalindrome(String s) {
        int n = s.length();
        String result = s.substring(0,1);
        for(int i=0; i<n; i++) {
            String temp = "";
            // Even check
            temp = check(s, i, i);
            if(temp.length() > result.length()) {
                result = temp;
            }
            // Odd Check
            temp = check(s, i, i+1);
            if(temp.length() > result.length()) {
                result = temp;
            }
        }
        return result;
    }

    private String check(String str, int l, int r) {
        int n = str.length();
        while(l >= 0 && r < n && str.charAt(l) == str.charAt(r)) {
            l--;
            r++;
        }
        return str.substring(l+1, r);
    }

}
