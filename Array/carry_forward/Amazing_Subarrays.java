/**
 *
 * You are given a string S, and you have to find all the amazing substrings of S.
 *
 * An amazing Substring is one that starts with a vowel (a, e, i, o, u, A, E, I, O, U).
 *
 * Input
 *
 * Only argument given is string S.
 * Output
 *
 * Return a single integer X mod 10003, here X is the number of Amazing Substrings in given the string.
 * Constraints
 *
 * 1 <= length(S) <= 1e6
 * S can have special characters
 * Example
 *
 * Input
 *     ABEC
 *
 * Output
 *     6
 *
 * Explanation
 *     Amazing substrings of given string are :
 *     1. A
 *     2. AB
 *     3. ABE
 *     4. ABEC
 *     5. E
 *     6. EC
 *     here number of substrings are 6 and 6 % 10003 = 6.
 *
 *
 */

package Array.carry_forward;

public class Amazing_Subarrays {

    public int solve(String A) {
        int n = A.length();
        int count = 0;
        for(int i=0; i<n; i++) {
            if(checkVowel(A, i)) {
                int temp = n - i;
                count += temp;
                count = count % 10003;
            }
        }
        return count;
    }

    boolean checkVowel(String str, int index) {
        switch(str.charAt(index)) {
            case 'a':
                return true;
            case 'A':
                return true;
            case 'e':
                return true;
            case 'E':
                return true;
            case 'i':
                return true;
            case 'I':
                return true;
            case 'o':
                return true;
            case 'O':
                return true;
            case 'u':
                return true;
            case 'U':
                return true;
        }
        return false;
    }

}
