/**
 *
 * Problem Description
 * You are given an integer array A of length N.
 * You are also given a 2D integer array B with dimensions M x 2, where each row denotes a [L, R] query.
 * For each query, you have to find the sum of all elements from L to R indices in A (0 - indexed).
 * More formally, find A[L] + A[L + 1] + A[L + 2] +... + A[R - 1] + A[R] for each query.
 *
 *
 *
 * Problem Constraints
 * 1 <= N, M <= 105
 * 1 <= A[i] <= 109
 * 0 <= L <= R < N
 *
 *
 * Input Format
 * The first argument is the integer array A.
 * The second argument is the 2D integer array B.
 *
 *
 * Output Format
 * Return an integer array of length M where ith element is the answer for ith query in B.
 *
 *
 * Example Input
 * Input 1:
 * A = [1, 2, 3, 4, 5]
 * B = [[0, 3], [1, 2]]
 * Input 2:
 *
 * A = [2, 2, 2]
 * B = [[0, 0], [1, 2]]
 *
 *
 * Example Output
 * Output 1:
 * [10, 5]
 * Output 2:
 *
 * [2, 4]
 *
 *
 * Example Explanation
 * Explanation 1:
 * The sum of all elements of A[0 ... 3] = 1 + 2 + 3 + 4 = 10.
 * The sum of all elements of A[1 ... 2] = 2 + 3 = 5.
 * Explanation 2:
 *
 * The sum of all elements of A[0 ... 0] = 2 = 2.
 * The sum of all elements of A[1 ... 2] = 2 + 2 = 4.
 *
 *
 *
 */


package Array.prefix_sum;


import java.util.ArrayList;

public class Range_Sum_Query {

    public ArrayList<Long> rangeSum(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> B) {
        return optimizedApproach(A, B);
    }

    // Brute Force Approach
    public ArrayList<Long> bruteForceApproach(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> B) {
        ArrayList<Long> result = new ArrayList<>();
        int query = B.size();
        int n = A.size();

        for(int i=0; i<query; i++) {
            int left = B.get(i).get(0);
            int right = B.get(i).get(1);
            Long sum = 0L;
            for(int j=left; j<=right; j++) {
                sum += A.get(j);
            }
            result.add(sum);
        }

        return result;
    }

    // Optimized Solution
    public ArrayList<Long> optimizedApproach(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> B) {
        ArrayList<Long> prefixSum = new ArrayList<>();
        ArrayList<Long> result = new ArrayList<>();
        int querySize = B.size();
        int n = A.size();
        prefixSum.add((long)A.get(0));

        for(int i=1; i<n; i++) {
            long temp = (long)prefixSum.get(i-1) + A.get(i);
            prefixSum.add(temp);
        }

        for(int i=0; i<querySize; i++) {
            int left = B.get(i).get(0);
            int right = B.get(i).get(1);

            if(left == 0) {
                result.add((long)prefixSum.get(right));
            }
            else {
                long value = (long)prefixSum.get(right) - prefixSum.get(left - 1);
                result.add(value);
            }
        }

        return result;
    }

    public static void main(String[] args) {

    }

}
