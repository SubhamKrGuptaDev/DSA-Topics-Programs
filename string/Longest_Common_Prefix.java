/**
 * * Problem Description *
 * Given the array of strings A, you need to find the longest string S,
 * which is the prefix of ALL the strings in the array.
 *
 * The longest common prefix for a pair of strings S1 and S2 is the longest string
 * S which is the prefix of both S1 and S2.
 *
 * Example: the longest common prefix of "abcdefgh" and "abcefgh" is "abc".
 *
 * * Problem Constraints *
 * 0 <= sum of length of all strings <= 1000000
 *
 * * Example Input *
 * Input 1:
 *
 * A = ["abcdefgh", "aefghijk", "abcefgh"]
 * Input 2:
 *
 * A = ["abab", "ab", "abcd"];
 *
 *
 * * Example Output *
 * Output 1:
 *
 * "a"
 * Output 2:
 *
 * "ab"
 *
 *
 * * Example Explanation *
 * Explanation 1:
 *
 * Longest common prefix of all the strings is "a".
 * Explanation 2:
 *
 * Longest common prefix of all the strings is "ab".
 *
 *
 * * Solution *
 *
 *     public String longestCommonPrefixOther(ArrayList < String > A) {
 *         if (A.size() == 0)
 *             return "";
 *         String str;
 *         String res = "";
 *         int min = Integer.MAX_VALUE;
 *         for (int i = 0; i < A.size(); i++) {
 *             min = Math.min(min, A.get(i).length());
 *         }
 *         for (int i = 0; i < min; i++) {
 *             char c = A.get(0).charAt(i);
 *             // check if c character is same in every string or not
 *             for (int j = 1; j < A.size(); j++) {
 *
 *                 if (c != A.get(j).charAt(i))
 *                     return res;
 *             }
 *             res += c;
 *         }
 *         return res;
 *     }
 *
 *
 *
 */


package string;


import java.util.ArrayList;

public class Longest_Common_Prefix {


    public String longestCommonPrefixOther(ArrayList < String > A) {
        if (A.size() == 0)
            return "";
        String str;
        String res = "";
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < A.size(); i++) {
            min = Math.min(min, A.get(i).length());
        }
        for (int i = 0; i < min; i++) {
            char c = A.get(0).charAt(i);
            // check if c character is same in every string or not
            for (int j = 1; j < A.size(); j++) {

                if (c != A.get(j).charAt(i))
                    return res;
            }
            res += c;
        }
        return res;
    }


    // TC : N + min(str.length())       SC : N
    public String longestCommonPrefix(ArrayList<String> A) {

        if(A == null) {
            return "";
        }

        if(A.size() == 1) {
            return A.get(0);
        }
        String res = A.get(0);
        for(int i=1; i<A.size(); i++) {
            res = commonPrefixString(res, A.get(i));
        }

        return res;
    }

    private String commonPrefixString(String s1, String s2) {
        String result = "";
        int j =0;
        while(j < s1.length() && j < s2.length() && s1.charAt(j) == s2.charAt(j)) {
            result += s1.charAt(j);
            j++;
        }

        return result;
    }


}
