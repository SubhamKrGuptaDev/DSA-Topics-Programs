/**
 *
 * Problem Description
 * Given a positive integer A, return its corresponding column title as it
 * appears in an Excel sheet.
 *
 * For example:
 *
 *     1 -> A
 *     2 -> B
 *     3 -> C
 *     ...
 *     26 -> Z
 *     27 -> AA
 *     28 -> AB
 *
 *
 * Problem Constraints
 * 1 <= A <= 109
 *
 *
 *
 * Input Format
 * First and only argument of input contains single integer A
 *
 *
 *
 * Output Format
 * Return a string denoting the corresponding title.
 *
 *
 *
 * * Example Input *
 * Input 1:
 *
 * A = 3
 * Input 2:
 *
 *
 * A = 27
 *
 *
 * * Example Output *
 * Output 1:
 *
 * "C"
 * Output 2:
 *
 * "AA"
 *
 *
 * * Example Explanation *
 * Explanation 1:
 *
 *
 * 3 corrseponds to C.
 * Explanation 2:
 *
 *     1 -> A,
 *     2 -> B,
 *     3 -> C,
 *     ...
 *     26 -> Z,
 *     27 -> AA,
 *     28 -> AB
 *
 *
 *
 */


package string;

public class Excel_Column_Title {

    public String convertToTitle1(int A) {
        StringBuilder sb = new StringBuilder();
        char ch;
        while(A > 0) {
            int rem = (A-1) % 26;
            ch = (char)((rem) + 'A');
            sb.append(ch);
            A = (A-1) / 26;
        }

        return sb.reverse().toString();
    }

    public String convertToTitle2(int A) {
        char[] chararactor = new char[26];
        for(int i=0; i<26; i++) {
            chararactor[i] = (char)(i + 'A');
        }
        int number = 26;
        int index = 0;
        StringBuilder ans = new StringBuilder();

        while(A > 0) {
            index = (A - 1 + number) % number;
            A = (A - 1) / number;
            ans.append(chararactor[index]);
        }

        return ans.reverse().toString();
    }

    public static void main(String[] args) {

    }

}
