/**
 *
 * Problem Description
 * Given an array A, find the size of the smallest subarray such that it contains at least one occurrence of the maximum value of the array
 *
 * and at least one occurrence of the minimum value of the array.
 *
 *
 *
 * Problem Constraints
 * 1 <= |A| <= 2000
 *
 *
 *
 * Input Format
 * First and only argument is vector A
 *
 *
 *
 * Output Format
 * Return the length of the smallest subarray which has at least one occurrence of minimum and maximum element of the array
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * A = [1, 3, 2]
 * Input 2:
 *
 * A = [2, 6, 1, 6, 9]
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
 *  Take the 1st and 2nd elements as they are the minimum and maximum elements respectievly.
 * Explanation 2:
 *
 *  Take the last 3 elements of the array.
 *
 *
 */

package Array.carry_forward;

import java.util.ArrayList;

public class Closest_MinMax {

    public int solve(ArrayList<Integer> A) {
        return optimizedApproach(A);
    }

    // Brute Force
    private int bruteforce(ArrayList<Integer> A) {
        return 0;
    }

    // Optimized Approach
    private int optimizedApproach(ArrayList<Integer> A) {

        int n = A.size();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i=0; i<n; i++) {
            min = Math.min(min, A.get(i));
            max = Math.max(max, A.get(i));
        }

        int maxIndex = -1;
        int minIndex = -1;
        int ans = Integer.MAX_VALUE;

        for(int i=0; i<n; i++) {
            if(max == A.get(i)) {
                maxIndex = i;
                if(minIndex != -1) {
                    ans = Math.min(ans, i - minIndex + 1);
                }
            }
            else if(min == A.get(i)) {
                minIndex = i;
                if(maxIndex != -1) {
                    ans = Math.min(ans, i - maxIndex + 1);
                }
            }
        }
        if(ans == Integer.MAX_VALUE) return 1;
        return ans;
    }

    public static void main(String[] args) {

    }

}
