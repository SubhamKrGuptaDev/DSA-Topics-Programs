/**
 *
 * Problem Description
 * Given an array of integers A, find and return the minimum value of | A [ i ] - A [ j ]
 * | where i != j and |x| denotes the absolute value of x.
 *
 *
 * Problem Constraints
 * 2 <= length of the array <= 100000
 *
 * -109 <= A[i] <= 10^9
 *
 *
 * * Example Input *
 * Input 1:
 *
 *  A = [1, 2, 3, 4, 5]
 * Input 2:
 *
 *  A = [5, 17, 100, 11]
 *
 *
 * * Example Output *
 * Output 1:
 *
 *  1
 * Output 2:
 *
 *  6
 *
 *
 * * Example Explanation *
 * Explanation 1:
 *
 *  The absolute difference between any two adjacent elements is 1,
 *  which is the minimum value.
 * Explanation 2:
 *
 *  The minimum value is 6 (|11 - 5| or |17 - 11|).
 *
 *
 *  * Hint *
 *
 *  Sort the array.
 *
 * We can observe that the answer will be the minimum value of absolute
 * difference between the adjacent elements.
 *
 * We can iterate over the sorted array and maintain the minimum value of
 * absolute difference.
 *
 * Return the answer.
 *
 *
 * * Solution *
 *
 *     public int solve(ArrayList < Integer > A) {
 *         int n = A.size();
 *         // sort the array
 *         Collections.sort(A);
 *         // initialize the ans variable
 *         int ans = Integer.MAX_VALUE;
 *         for (int i = 1; i < n; i++) {
 *             // store the minimum value
 *             ans = Math.min(ans, A.get(i) - A.get(i - 1));
 *         }
 *         return ans;
 *     }
 *
 *
 *
 */


package sorting;

import java.util.ArrayList;
import java.util.Collections;

public class Minimum_Absolute_Difference {

    // Optimize Solution TC: N
    public int solve(ArrayList<Integer> A) {
        Collections.sort(A);
        int n = A.size();
        int min = Integer.MAX_VALUE;
        for(int i=1; i<n; i++) {
            int temp = Math.abs(A.get(i-1) - A.get(i));
            min = Math.min(temp, min);
        }
        return min;
    }
    // Brute Force Solution TC: N^2
    private int bruteForce(ArrayList<Integer> A) {
        int min = Integer.MAX_VALUE;
        int n = A.size();
        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                int temp = Math.abs(A.get(i) - A.get(j));
                min = Math.min(temp, min);
            }
        }

        return min;
    }

    public static void main(String[] args) {

    }

}
