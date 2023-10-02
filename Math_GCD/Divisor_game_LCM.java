/**
 *
 * Problem Description
 * Scooby has 3 three integers A, B, and C.
 *
 * Scooby calls a positive integer special if it is divisible by B and it is divisible by C.
 * You need to tell the number of special integers less than or equal to A.
 *
 *
 *
 * Problem Constraints
 * 1 <= A, B, C <= 10^9
 *
 *
 * * Example Input *
 * Input 1:
 *
 *  A = 12
 *  B = 3
 *  C = 2
 * Input 2:
 *
 *  A = 6
 *  B = 1
 *  C = 4
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
 * * Example Explanation *
 * Explanation 1:
 *
 *  The two integers divisible by 2 and 3 and less than or equal to 12 are 6,12.
 * Explanation 2:
 *
 *  Only 4 is a positive integer less than equal to 6 which is divisible by 1 and 4.
 *
 *  <>
 *      * Hint *
 *      We can’t use loop, so we can try for another approach, i.e., find the
 *      lcm(the least common multiple) of B and C and find the number of
 *      elements less than equal to A, which is divisible by lcm.
 *      lcm(A,B)=(A*B)/(gcd(A,B))
 *  </>
 *
 *
 *
 */


package Math_GCD;

public class Divisor_game_LCM {

    // GCD Approach
    public int solve(int A, int B, int C) {
        int lcm = (B * C) / (gcd(B,C));
        return A / lcm;
    }

    private int gcd(int A, int B) {
        if(B == 0) return A;
        return gcd(B, A % B);
    }

    // Brute Force
    private int bruteForce(int A, int B, int C) {
        int start = Math.max(B,C);
        int count = 0;
        for(int i=start; i<=A; i++) {
            if(i % B == 0 && i % C == 0) count++;
        }

        return count;
    }

}
