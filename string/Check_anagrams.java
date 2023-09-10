/**
 *
 * * Problem Description *
 * You are given two lowercase strings A and B each of length N. Return 1 if they
 * are anagrams to each other and 0 if not.
 *
 * Note : Two strings A and B are called anagrams to each other if A can be formed
 * after rearranging the letters of B.
 *
 * * Problem Constraints *
 * 1 <= N <= 105
 * A and B are lowercase strings
 *
 * * Example Input *
 * Input 1:
 * A = "cat"
 * B = "bat"
 * Input 2:
 * A = "secure"
 * B = "rescue"
 *
 *
 * * Example Output *
 * Output 1:
 * 0
 * Output 2:
 * 1
 *
 *
 * * Example Explanation *
 * For Input 1:
 * The words cannot be rearranged to form the same word. So, they are not anagrams.
 * For Input 2:
 * They are an anagram.
 *
 *
 * * Best Solution *
 *     public int solve(String A, String B) {
 *         int[] freq1 = new int[26];
 *         int[] freq2 = new int[26];
 *         for(int i = 0 ; i < A.length() ; i++){
 *             freq1[A.charAt(i) - 'a']++;
 *             freq2[B.charAt(i) - 'a']++;
 *         }
 *         for(int i = 0 ; i < 26 ; i++){
 *             if(freq1[i] != freq2[i]){
 *                 return 0;
 *             }
 *         }
 *         return 1;
 *     }
 *
 *
 */


package string;

import java.util.Arrays;

public class Check_anagrams {
    // TC : N       SC : 1
    public static int bestSolution(String A, String B) {
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];
        for(int i = 0 ; i < A.length() ; i++){
            freq1[A.charAt(i) - 'a']++;
            freq2[B.charAt(i) - 'a']++;
        }
        for(int i = 0 ; i < 26 ; i++){
            if(freq1[i] != freq2[i]){
                return 0;
            }
        }
        return 1;
    }
    // TC : N(logN)     SC : N
    public static int solve(String A, String B) {
        if(A.length() != B.length()) {
            return 0;
        }
        char[] ch1 = A.toCharArray();
        char[] ch2 = B.toCharArray();

        Arrays.sort(ch1);
        Arrays.sort(ch2);

        for(int i=0; i<ch1.length; i++) {
            if(ch1[i] != ch2[i]) {
                return 0;
            }
        }

        return 1;
    }

    public static void main(String[] args) {

    }

}
