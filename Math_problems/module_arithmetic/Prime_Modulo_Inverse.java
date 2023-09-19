/**
 *
 * Problem Description
 * Given two integers A and B. Find the value of A-1 mod B where B is a
 * prime number and gcd(A, B) = 1.
 *
 * A-1 mod B is also known as modular multiplicative inverse of A under modulo B.
 *
 *
 * Problem Constraints
 * 1 <= A <= 109
 * 1<= B <= 109
 * B is a prime number
 *
 *
 * * Example Input *
 * Input 1:
 *
 *  A = 3
 *  B = 5
 * Input 2:
 *
 *  A = 6
 *  B = 23
 *
 *
 * * Example Output *
 * Output 1:
 *
 *  2
 * Output 2:
 *
 *  4
 *
 *
 * * Example Explanation *
 * Explanation 1:
 *
 *  Let's say A-1 mod B = X, then (A * X) % B = 1.
 *  3 * 2 = 6, 6 % 5 = 1.
 * Explanation 2:
 *
 *  Similarly, (6 * 4) % 23 = 1.
 *
 *
 * * Explanation With Solution *
 *
 * ************ Iterative *************
 *
 *     long power(long x, long y, long p) {
 *         long res = 1;        // Initialize result
 *         x = x % p;        // Update x if it is more than or equal to p
 *         while (y > 0) {
 *             // If y is odd, multiply x with result
 *             if ((y & 1) == (long)1)
 *                 res = (res*x) % p;
 *             y = y >> 1;
 *             x = (x * x) % p;
 *         }
 *         return res;
 *     }
 *
 *     public int solve(int A, int B) {
 *         // Modular inverse of A Modulo B = pow(A, B - 2, B)
 *         return (int)power(A, B - 2, B);
 *     }
 *
 *
 * ************ Recursion *************
 *
 *  	public int solve(int A, int B) {
 * 		if (A == 0)
 * 			return 0;
 * 		// fermats theorem ==>  (A^-1)= A^(B-2) mod B
 * 		// question is to calculate (A^-1) mod B
 * 		// by substituting above equation we get ==> (A^(B-2) mod B ) mod B;
 * 		return pow(A, B - 2, B);
 *        }
 *
 * 	public int pow(int A, int B, int C) {
 * 		if (B == 0)
 * 			return 1;
 * 		long halfPower = pow(A, B / 2, C);
 * 		long interimResult = halfPower % C * halfPower % C;
 * 		// finding modulo of a%b is same as (a%b + b) % b
 * 		// Approach 1: 2%4 ==> 2; Approach 2 (2%4 + 4)%4 ==> 6%4 ==> 2
 * 		// above case handles both a%b and -a%b
 * 		// -2%4 ==> (a-b)%m ==> (a%m -b%m+m)%m;
 * 		return ((B % 2 == 0) ? (int)((interimResult) + C) % C : (int)((interimResult * A % C) + C) % C);
 *
 *    }
 *
 *
 */


package Math_problems.module_arithmetic;

public class Prime_Modulo_Inverse {

    public int solve(int A, int B) {
        return (int)power((long)A,B-2,B);
    }

    private long power(long A, int power, int B) {
        if(power == 0) return 1;
        if(power % 2 == 0) {
            long result = power(A, power / 2, B);
            return (((result % B) * (result % B)) % B);
        }
        else {
            long result = power(A, power / 2, B);
            return (((A % B) * (((result % B) * (result % B))%B) % B) % B);
        }
    }

    public static void main(String[] args) {

    }
}
