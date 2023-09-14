/**
 *
 * * Problem Description *
 * Write a recursive function that checks whether string A is a palindrome or Not.
 * Return 1 if the string A is a palindrome, else return 0.
 *
 * Note: A palindrome is a string that's the same when read forward and backward.
 *
 *
 * * Problem Constraints *
 * 1 <= |A| <= 50000
 *
 * String A consists only of lowercase letters.
 *
 *
 * * Example Input *
 * Input 1:
 *
 *  A = "naman"
 * Input 2:
 *
 *  A = "strings"
 *
 *
 * * Example Output *
 * Output 1:
 *
 *  1
 * Output 2:
 *
 *  0
 *
 *
 * * Example Explanation *
 * Explanation 1:
 *
 *  "naman" is a palindomic string, so return 1.
 * Explanation 2:
 *
 *  "strings" is not a palindrome, so return 0.
 *
 *
 * * Hint *
 * Think about the base case and how you can break down the problem into smaller subproblems.
 *
 * In this case, you can check whether the first and last characters of the string are equal.
 *
 * If they are, you can recursively check whether the substring formed
 *
 * by excluding these characters is also a palindrome.
 *
 * Continue this process until the base case is reached.
 *
 * Caution: Be careful to set appropriate recursion limits in languages like Python.
 *
 *
 *
 */


package recursion;

public class Check_Palindrome {
    public int solve(String A) {
        return palindrome(A, 0, A.length()-1);
    }
    private int palindrome(String str, int i, int j) {
        if(i > j) {
            return 1;
        }
        if(str.charAt(i) == str.charAt(j)) {
            return palindrome(str, i+1, j-1);
        }
        else {
            return 0;
        }
    }

    public static void main(String[] args) {

    }

}
