/**
 *
 * Problem Description
 * Given an array A of N integers. Find the sum of bitwise XOR all pairs of numbers
 * in the array.
 *
 * Since the answer can be large, return the remainder after the dividing the answer
 * by 10^9+7.
 *
 *
 *
 * Problem Constraints
 * 1 <= N <= 10^5
 *
 * 1 <= A[i] < 10^9
 *
 * * Example Input *
 * Input 1:
 * A = [1, 2, 3]
 * Input 2:
 * A = [3, 4, 2]
 *
 *
 * * Example Output *
 * Output 1:
 * 6
 * Output 2:
 * 14
 *
 *
 * * Example Explanation *
 * For Input 1:
 * Pair    Xor
 * {1, 2}  3
 * {1, 3}  2
 * {2, 3}  1
 *
 * Sum of xor of all pairs = 3 + 2 + 1 = 6.
 * For Input 2:
 * Pair    Xor
 * {3, 4}  7
 * {3, 2}  1
 * {4, 2}  6
 * Sum of xor of all pairs = 7 + 1 + 6 = 14.
 *
 *
 * * Hint *
 *
 * For every bit, we can find the number of elements in the array
 * with that bit set and the number of elements with that bit unset.
 *
 * Let the number of elements with i-th bit set and unset be
 * X and Y respectively.
 *
 * Now the number of xor pairs with the i-th bit set is X*Y.
 * So the total contribution by the i-th bit to the sum of xor
 * of all pairs will be (X * Y) * (1 << i).
 *
 *
 * Time Complexity : O(N*logX)
 * Space Complexity : O(1)
 *
 * where X is maximum value from A
 *
 *
 * * Other Solution *
 *
 *     public int solve(int[] A) {
 *         final int mod = (int)(1e9 + 7);
 *         int n = A.length;
 *         long ans = 0;
 *         for(int j = 0; j < 32; j++){
 *             long zero = 0, one = 0, temp;
 *
 *             //  Count of zeros and ones for each bit
 *             for(int i = 0; i < n; i++){
 *                 if (A[i] % 2 == 0)
 *                     zero++;
 *                 else
 *                     one++;
 *                 A[i] /= 2;
 *             }
 *
 *             // calculating individual bit sum
 *             temp = zero * one * (1 << j);
 *             ans = (ans + temp) % mod;
 *         }
 *         return (int)(ans);
 *     }
 *
 *
 *
 */

package bit_manupulation;

import java.util.ArrayList;

public class Sum_of_Xor_of_all_Pairs {

    // Optimize Approach TC : N
    public int solve(ArrayList<Integer> A) {
        long ans = 0L;
        int n = A.size();
        long mod = 1000 * 1000 * 1000 + 7;
        for(int i=0; i<32; i++) {
            long countOne = 0;
            long countZero = 0;
            for(int j=0; j<n; j++) {
                if((A.get(j) & (1 << i)) != 0) {
                    countOne++;
                }
                else {
                    countZero++;
                }
            }
            long pair = (countOne * countZero);
            ans += (pair * (1 << i)) % mod;
            ans %= mod;
        }
        return (int)(ans % mod);
    }

    // Brute Force Approach TC : N ^ 2
    private int bruteForce(ArrayList<Integer> A) {
        long ans = 0L;
        int n = A.size();
        long mod = 1000 * 1000 * 1000 + 7;
        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                ans += A.get(i) ^ A.get(j);
            }
        }
        return (int)(ans % mod);
    }

    public static void main(String[] args) {

    }

}
