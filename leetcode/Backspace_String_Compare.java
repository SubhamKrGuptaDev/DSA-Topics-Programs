/**
 *
 * leetcode - https://leetcode.com/problems/backspace-string-compare/description/
 *
 * 844. Backspace String Compare
 *
 *
 * Given two strings s and t, return true if they are equal when both are typed into empty text editors. '#' means a backspace character.
 *
 * Note that after backspacing an empty text, the text will continue empty.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "ab#c", t = "ad#c"
 * Output: true
 * Explanation: Both s and t become "ac".
 * Example 2:
 *
 * Input: s = "ab##", t = "c#d#"
 * Output: true
 * Explanation: Both s and t become "".
 * Example 3:
 *
 * Input: s = "a#c", t = "b"
 * Output: false
 * Explanation: s becomes "c" while t becomes "b".
 *
 *
 * Constraints:
 *
 * 1 <= s.length, t.length <= 200
 * s and t only contain lowercase letters and '#' characters.
 *
 *
 * Follow up: Can you solve it in O(n) time and O(1) space?
 *
 */



package leetcode;

public class Backspace_String_Compare {

    public boolean backspaceCompare(String s, String t) {
        int n = s.length();
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for(int i=0; i<n; i++) {
            if(!(sb1.isEmpty()) && (s.charAt(i) == '#')) {
                sb1.deleteCharAt(sb1.length() - 1);
            }
            else if(!(s.charAt(i) == '#')) {
                sb1.append(s.charAt(i));
            }
        }
        n = t.length();
        for(int i=0; i<n; i++) {
            if(!(sb2.isEmpty()) && (t.charAt(i) == '#')) {
                sb2.deleteCharAt(sb2.length() - 1);
            }
            else if(!(t.charAt(i) == '#')){
                sb2.append(t.charAt(i));
            }
        }

        return sb1.toString().contentEquals(sb2);
    }

}
