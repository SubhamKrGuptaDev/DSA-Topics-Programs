/**
 *
 * Problem Description
 * Given an array of integers A, calculate the sum of A [ i ] % A [ j ]
 * for all possible i, j pairs. Return sum % (109 + 7) as an output.
 *
 *
 * Problem Constraints
 * 1 <= length of the array A <= 105
 *
 * 1 <= A[i] <= 10^3
 *
 *
 * * Example Input *
 * Input 1:
 *
 *  A = [1, 2, 3]
 * Input 2:
 *
 *  A = [17, 100, 11]
 *
 *
 * * Example Output *
 * Output 1:
 *
 *  5
 * Output 2:
 *
 *  61
 *
 *
 * * Example Explanation *
 * Explanation 1:
 *
 *  (1 % 1) + (1 % 2) + (1 % 3) + (2 % 1) + (2 % 2) + (2 % 3) +
 *  (3 % 1) + (3 % 2) + (3 % 3) = 5
 *
 *
 *  * Hint *
 *  Calculate the frequency of all the elements from 1 to 1000.
 * For all values i from 1 to 1000 calculate sumi as sum of i % A[j] ,
 * where 1 <= j <= n
 * Sum of all such ((sumi) * (frequency of i)) would be the final answer.
 *
 *
 *  * Solution *
 *      public int solve(ArrayList<Integer> A) {
 *
 *         int n = A.size(), mod = 1000 * 1000 * 1000 + 7;
 *
 *         // To store the frequency of each element
 *         int[] cnt = new int[1009];
 *
 *         // Store the frequency of each element
 *         for(int a: A)
 *             cnt[a]++;
 *
 *         // To store the required answer
 *         int ans = 0;
 *
 *         // For all valid pairs
 *         for(int i = 1; i <= 1000; i++){
 *             if(cnt[i] == 0)
 *                 continue;
 *             for(int j = 1; j <= 1000; j++){
 *                 if(cnt[j] == 0)
 *                     continue;
 *                 // Update the count
 *                 int val = j % i;
 *                 int temp = cnt[i] * cnt[j] * val;
 *                 ans = ((ans % mod) + (temp % mod)) % mod;
 *             }
 *         }
 *         return ans;
 *     }
 *
 *
 */

package Math_problems.module_arithmetic;

import java.util.ArrayList;

public class Mod_Sum {

    public int solve(ArrayList<Integer> A) {
        return optimalSolution(A);
    }

    // Optimal Solution
    private int optimalSolution(ArrayList<Integer> A) {
        int[] freq = new int[1000+1];
        int n = A.size();
        for(int i=0; i<n; i++) {
            int temp = A.get(i);
            freq[temp]++;
        }
        long sum = 0L;
        int mod = 1000 * 1000 * 1000 + 7;
        for(int i=1; i<= 1000; i++) {
            for(int j=1; j<=1000; j++) {
                long temp = (i%j) * freq[i] * freq[j];
                sum += temp;
            }
        }
        return (int)(sum % mod);
    }

    // Brute force
    private int bruteForce(ArrayList<Integer> A) {
        int n = A.size();
        long sum = 0;
        int mod = 1000 * 1000 * 1000 + 7;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                sum += A.get(i) % A.get(j);
            }
        }
        return (int)(sum % mod);
    }

    public static void main(String[] args) {

    }

}
