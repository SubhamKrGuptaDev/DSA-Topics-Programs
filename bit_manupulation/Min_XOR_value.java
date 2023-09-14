/**
 *
 * * Problem Description *
 * Given an integer array A of N integers, find the pair of integers in
 * the array which have minimum XOR value. Report the minimum XOR value.
 *
 *
 * * Problem Constraints *
 * 2 <= length of the array <= 100000
 * 0 <= A[i] <= 109
 *
 *
 * * Example Input *
 * Input 1:
 *
 *  A = [0, 2, 5, 7]
 * Input 2:
 *
 *  A = [0, 4, 7, 9]
 *
 *
 * * Example Output *
 * Output 1:
 *
 *  2
 * Output 2:
 *
 *  3
 *
 * * Example Explanation *
 * Explanation 1:
 *
 *  0 xor 2 = 2
 *
 *
 *
 *
 *
 * * Hint *
 * The brute-force would be to try every pair (x, y).
 *
 * If the array is sorted, do you need to check for every pair?
 * Try to reduce the number of checked pairs.
 *
 *
 */


package bit_manupulation;

import java.util.ArrayList;
import java.util.Collections;

public class Min_XOR_value {

    public int findMinXor(ArrayList<Integer> A) {
        int min = Integer.MAX_VALUE;
        int n = A.size();
        Collections.sort(A);
        for(int i=1; i<n; i++) {
            int temp = A.get(i-1) ^ A.get(i) ;
            min = Math.min(min, temp);
        }

        return min;
    }

    public static void main(String[] args) {

    }

}
