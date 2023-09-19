/**
 *
 * Problem Description
 * Given two integers A and B, find the greatest possible positive
 * integer M, such that A % M = B % M.
 *
 *
 * Problem Constraints
 * 1 <= A, B <= 109
 * A != B
 *
 * * Example Input *
 * Input 1:
 *
 * A = 1
 * B = 2
 * Input 2:
 *
 * A = 5
 * B = 10
 *
 *
 * * Example Output *
 * Output 1:
 *
 * 1
 * Output 2:
 *
 * 5
 *
 *
 * * Example Explanation *
 * Explanation 1:
 *
 * 1 is the largest value of M such that A % M == B % M.
 * Explanation 2:
 *
 * For M = 5, A % M = 0 and B % M = 0.
 *
 * No value greater than M = 5, satisfies the condition.
 *
 * * Solutions *
 *     public int solve(int A, int B) {
 *         return Math.abs(A - B);
 *     }
 *
 *
 */


package Math_problems.module_arithmetic;

public class A_B_and_Modulo {

    public int solve(int A, int B) {
        int result=0;
        if(A > B) result = A - B;
        else result = B - A;
        if(A % result == B % result) return result;
        return 0;
    }

    public static void main(String[] args) {

    }
}
