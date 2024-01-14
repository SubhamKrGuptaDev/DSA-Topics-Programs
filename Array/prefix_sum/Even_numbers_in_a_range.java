/**
 *
 * Problem Description
 * You are given an array A of length N and Q queries given by the 2D array B of size Q×2.
 *
 * Each query consists of two integers B[i][0] and B[i][1].
 *
 * For every query, your task is to find the count of even numbers in the range from A[B[i][0]] to A[B[i][1]].
 *
 *
 *
 * Problem Constraints
 * 1 <= N <= 105
 * 1 <= Q <= 105
 * 1 <= A[i] <= 109
 * 0 <= B[i][0] <= B[i][1] < N
 *
 *
 * Input Format
 * First argument A is an array of integers.
 * Second argument B is a 2D array of integers.
 *
 *
 * Output Format
 * Return an array of integers.
 *
 *
 * Example Input
 * Input 1:
 * A = [1, 2, 3, 4, 5]
 * B = [   [0, 2]
 *         [2, 4]
 *         [1, 4]   ]
 * Input 2:
 * A = [2, 1, 8, 3, 9, 6]
 * B = [   [0, 3]
 *         [3, 5]
 *         [1, 3]
 *         [2, 4]   ]
 *
 *
 * Example Output
 * Output 1:
 * [1, 1, 2]
 * Output 2:
 * [2, 1, 1, 1]
 *
 *
 * Example Explanation
 * For Input 1:
 * The subarray for the first query is [1, 2, 3] (index 0 to 2) which contains 1 even number.
 * The subarray for the second query is [3, 4, 5] (index 2 to 4) which contains 1 even number.
 * The subarray for the third query is [2, 3, 4, 5] (index 1 to 4) which contains 2 even numbers.
 * For Input 2:
 * The subarray for the first query is [2, 1, 8, 3] (index 0 to 3) which contains 2 even numbers.
 * The subarray for the second query is [3, 9, 6] (index 3 to 5) which contains 1 even number.
 * The subarray for the third query is [1, 8, 3] (index 1 to 3) which contains 1 even number.
 * The subarray for the fourth query is [8, 3, 9] (index 2 to 4) which contains 1 even number.
 *
 *
 */

package Array.prefix_sum;

import java.util.ArrayList;

public class Even_numbers_in_a_range {

    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> B) {
        return optimizedApproach(A, B);
    }

    // Brute Force
    private ArrayList<Integer> bruteForce(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> B) {
        ArrayList<Integer> result = new ArrayList<>();
        int n = B.size();
        for(int i=0; i<n; i++) {
            int left = B.get(i).get(0);
            int right = B.get(i).get(1);
            int count = 0;
            for(int j=left; j<=right; j++) {
                if(A.get(j) % 2 == 0) {
                    count++;
                }
            }
            result.add(count);
        }

        return result;
    }

    // Optimized Approach
    private ArrayList<Integer> optimizedApproach(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> B) {
        ArrayList<Integer> countEven = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();

        int count = 0;
        int n = B.size();
        for(int i=0; i<A.size(); i++) {
            if(A.get(i) % 2 == 0) count++;
            countEven.add(count);
        }

        for(int i=0; i<n; i++) {
            int left = B.get(i).get(0);
            int right = B.get(i).get(1);

            if(left == 0) result.add(countEven.get(right));
            else {
                int value = countEven.get(right) - countEven.get(left - 1);
                result.add(value);
            }
        }

        return result;
    }

    public static void main(String[] args) {

    }

}
