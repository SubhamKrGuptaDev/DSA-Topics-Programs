/**
 * <> Fermat’s Little Theorem. </>
 * Problem Description
 * Given two Integers A, B. You have to calculate (A ^ (B!)) % (1e9 + 7).
 *
 * "^" means power,
 * "%" means mod, and
 * "!" means factorial.
 *
 * Note: Ensure to handle integer overflow when performing the calculations.
 *
 *
 * Problem Constraints
 * 1 <= A, B <= 5e5
 *
 *
 * * Example Input *
 * Input 1:
 *
 * A = 1
 * B = 1
 * Input 2:
 *
 * A = 2
 * B = 2
 *
 *
 * * Example Output *
 * Output 1:
 *
 * 1
 * Output 2:
 *
 * 4
 *
 *
 * * Example Explanation *
 * Explanation 1:
 *
 *  1! = 1. Hence, 1^1 = 1.
 * Explanation 2:
 *
 *  2! = 2. Hence, 2^2 = 4.
 *
 *
 *
 *
 *
 */


package Math_problems.module_arithmetic;

public class Very_Large_Power {
    // Bit's Operation power calculation

    /**
     * Solution No.1 With Bit manipulation
     * @param A
     * @param B
     * @param mod
     * @return
     */
    int fast_power(long A, long B, long mod) {
        long ans = 1;
        while(B > 0) {
            if((B & 1) == 1) {
                ans = (ans * A) % mod;
            }
            A = (A % mod * A % mod) % mod;
            B = B >> 1;
        }
        return (int)(ans % mod);
    }

    public int solve(int A, int B) {
        long fact = 1;
        long mod = (long)(1e9 + 7);
        // calculating factorial of B
        for(long i = 2; i <= B; i += 1) {
            fact = (fact * i) % (mod - 1);      // (mod-1) is used accoring to Fermat Little theorem.
        }
        int ans = fast_power(A, fact, mod);     // calculating power by divide and conquer
        return ans;
    }

    /**
     * Solution No.2 with recursion
     * @param A
     * @param B
     * @return
     */
    public int solve1(int A, int B) {
        long fact = 1;
        int mod = 1000 * 1000 * 1000 + 7;
        for(int i=1; i<=B; i++) {
            fact = (fact * i) % (mod - 1);
        }
        return (int)(power(A, fact, mod) % mod);
    }

    // With recursion power calculation
    private long power(long n, long b, long p) {
        if(b == 0L) {
            return 1;
        }
        long half = power(n, b/2, p);
        if(b % 2 == 0) {
            return (half * half) % p;
        }

        return (n * ((half * half) % p)) % p;
    }

    public static void main(String[] args) {

    }

}
