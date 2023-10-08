/**
 *
 * Problem Description
 * You are given three positive integers, A, B, and C.
 *
 * Any positive integer is magical if divisible by either B or C.
 *
 * Return the Ath smallest magical number. Since the answer may be very large,
 * return modulo 10^9 + 7.
 *
 * Note: Ensure to prevent integer overflow while calculating.
 *
 *
 *
 * Problem Constraints
 * 1 <= A <= 10^9
 *
 * 2 <= B, C <= 40000
 *
 *
 * * Example Input *
 * Input 1:
 *
 *  A = 1
 *  B = 2
 *  C = 3
 * Input 2:
 *
 *  A = 4
 *  B = 2
 *  C = 3
 *
 *
 * * Example Output *
 * Output 1:
 *
 *  2
 * Output 2:
 *
 *  6
 *
 *
 * * Example Explanation *
 * Explanation 1:
 *
 *  1st magical number is 2.
 * Explanation 2:
 *
 *  First four magical numbers are 2, 3, 4, 6 so the 4th magical number is 6.
 *
 *
 *
 */


package BinarySearch;

public class Ath_Magical_Number {

    // Binary Search Approach
    public int binarySearch(int A, int B, int C) {
        long mod = 1000L * 1000L * 1000L + 7L;
        long lcm = (B*C) / gcd(B,C);

        long left = 1L;
        /**
         * 10 ^ 9 * 40000
         * int * int can be overflow
         * so, for safe side we have to convert first variable to
         * long then calculation also be a long
         *
         */
        long right = (long)Math.min(B,C) * A;
        long ans = 0L;

        while(left <= right) {
            long mid = (left + right) / 2L;
            long count = floorOfAllTheDivisor(mid, B, C, lcm);
            if(count >= A) {
                ans = mid;
                right = mid - 1L;
            }
            else {
                left = mid + 1L;
            }
        }
        return (int)(ans % mod);
    }

    // using this formula to understand of middle element up to how many div happen
    private long floorOfAllTheDivisor(long x, long B, long C, long lcm) {
        return (x/B) + (x/C) - (x/lcm);
    }

    // GCD
    public int gcd(int n1, int n2) {
        if(n2 == 0) return n1;
        return gcd(n2, n1 % n2);
    }

    // Brute Force Approach TC: O(min(B,C) * A)
    public int bruteForce(int A, int B, int C) {
        long i = Math.min(B,C);
        long ans = 0;
        long mod = 1000 * 1000 * 1000 + 7;
        while(A > 0) {
            if(i % B == 0 || i % C == 0) {
                ans = i;
                ans = ans % mod;
                A--;
            }
            i++;
        }
        return (int)ans;
    }

    public static void main(String[] args) {

    }

}
