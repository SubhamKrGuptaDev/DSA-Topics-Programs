/**
 *
 * Problem Description
 * Given 2 non-negative integers A and B, find gcd(A, B)
 *
 * GCD of 2 integers A and B is defined as the greatest integer 'g'
 * such that 'g' is a divisor of both A and B. Both A and B fit in a
 * 32-bit signed integer.
 *
 * Note: DO NOT USE LIBRARY FUNCTIONS.
 *
 * Problem Constraints
 * 0 <= A, B <= 10^9
 *
 * * Example Input *
 * Input 1:
 *
 * A = 4
 * B = 6
 * Input 2:
 *
 * A = 6
 * B = 7
 *
 *
 * * Example Output *
 * Output 1:
 *
 *  2
 * Output 2:
 *
 *  1
 *
 *
 *
 * * Example Explanation *
 * Explanation 1:
 *
 *  2 divides both 4 and 6
 * Explanation 2:
 *
 *  1 divides both 6 and 7
 *
 *
 * Solution -> Euclidean algorithms theorem
 *
 *
 */

package Math_problems.module_arithmetic;

public class Greatest_Common_Divisor {

    public int gcd(int A, int B) {
        return gcd2(A,B);
    }
//    Iterative Solution TC : O(log n2) SC : O(1)
    private int gcd2(int n1, int n2) {
        if(n1 == 0) return n2;
        while(n2 > 0) {
            int temp = n1 % n2;
            n1 = n2;
            n2 = temp;
        }

        return n1;
    }
//    Recursion Solution TC : O(log B) SC : O(log B)
    public int gcd3(int A, int B) {
        if(B == 0) return A;
        return gcd(B, A % B);
    }

    public static void main(String[] args) {

    }

}




