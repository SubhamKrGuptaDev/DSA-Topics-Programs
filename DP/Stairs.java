/**
 *
 * Problem Description
 * You are climbing a staircase and it takes A steps to reach the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 * Return the number of distinct ways modulo 1000000007
 *
 *
 *
 * Problem Constraints
 * 1 <= A <= 105
 *
 *
 *
 * Input Format
 * The first and the only argument contains an integer A, the number of steps.
 *
 *
 *
 * Output Format
 * Return an integer, representing the number of ways to reach the top.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = 2
 * Input 2:
 *
 *  A = 3
 *
 *
 * Example Output
 * Output 1:
 *
 *  2
 * Output 2:
 *
 *  3
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  Distinct ways to reach top: [1, 1], [2].
 * Explanation 2:
 *
 *  Distinct ways to reach top: [1 1 1], [1 2], [2 1].
 *
 *
 */


package DP;

public class Stairs {

    // iterative Solution
    public int climbStairs(int A) {
        if(A <= 2) return A;
        int prev = 1;
        int cur = 2;
        int mod = 1000 * 1000 * 1000 + 7;
        for(int i=3; i<=A; i++) {
            int next = (prev + cur) % mod;
            prev = cur;
            cur = next;
        }

        return cur;
    }

    // Recursive Solution
    private int recursiveSolution(int A) {
        long[] storage = new long[A+1];
        long mod = 1000 * 1000 * 1000 + 7;
        return (int)(totalSteps(A, storage, mod) % mod);
    }

    private long totalSteps(int n, long[] storage, long mod) {
        if(n <= 2) return n;
        if(storage[n] != 0) return storage[n];
        storage[n] = totalSteps(n-1, storage, mod) + totalSteps(n-2, storage, mod);
        return storage[n] % mod;
    }

    public static void main(String[] args) {

    }

}
