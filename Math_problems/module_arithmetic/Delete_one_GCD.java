/**
 * Problem Description
 * Given an integer array A of size N. You have to delete one element
 * such that the GCD(Greatest common divisor) of the remaining array is maximum.
 *
 * Find the maximum value of GCD.
 *
 *
 * Problem Constraints
 * 2 <= N <= 10^5
 * 1 <= A[i] <= 10^9
 *
 * * Example Input *
 * Input 1:
 *
 *  A = [12, 15, 18]
 * Input 2:
 *
 *  A = [5, 15, 30]
 *
 * * Example Output *
 * Output 1:
 *
 *  6
 * Output 2:
 *
 *  15
 *
 *
 */



package Math_problems.module_arithmetic;

import java.util.ArrayList;

public class Delete_one_GCD {

    private int gcdIterativeSoluton(int n1, int n2) {
        if(n1 == 0) return n2;
        while(n2 > 0) {
            int temp = n1 % n2;
            n1 = n2;
            n2 = temp;
        }
        return n1;
    }
//    Prefix and Suffix Solution
    public int solve(ArrayList<Integer> A) {
        int n = A.size();
        int[] prefixGcd = new int[n];
        int[] suffixGcd = new int[n];
        prefixGcd[0] = A.get(0);
        suffixGcd[n-1] = A.get(n-1);
        for(int i=1; i<n; i++) {
            prefixGcd[i] = gcdIterativeSoluton(prefixGcd[i-1], A.get(i));
        }
        for(int i=n-2; i>=0; i--) {
            suffixGcd[i] = gcdIterativeSoluton(suffixGcd[i+1], A.get(i));
        }
        int max = Integer.MIN_VALUE;
        for(int i=1; i<n-1; i++) {
            int temp = gcdIterativeSoluton(prefixGcd[i-1], suffixGcd[i+1]);
            max = Math.max(max, temp);
        }

        return max;
    }

//    Other Solution

    public int gcd(int a, int b) {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }
    public int[] suffixGCD(int[] A){
        int n = A.length;
        int[] suf = new int[n];
        int g = 0;
        for (int i = n - 1; i >= 0; i--) {
            g = gcd(g, A[i]);
            suf[i] = g;
        }
        return suf;
    }
    public int solve(int[] A) {
        int n = A.length, ans = 1;
        // suf stores the suffix gcd of the array
        int[] suf = suffixGCD(A);
        int curGcd = 0;
        for (int i = 0; i < n; i++) {
            if (i != n - 1)
                ans = Math.max(ans, gcd(suf[i + 1], curGcd));
            else
                ans = Math.max(ans, curGcd);
            curGcd = gcd(curGcd, A[i]);
        }
        return ans;
    }

    public static void main(String[] args) {

    }

}
