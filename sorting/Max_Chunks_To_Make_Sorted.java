/**
 *
 * Problem Description
 * Given an array of integers A of size N that is a permutation of [0, 1, 2, ..., (N-1)],
 * if we split the array into some number of "chunks" (partitions), and individually
 * sort each chunk. After concatenating them in order of splitting, the result equals the
 * sorted array.
 *
 * What is the most number of chunks we could have made?
 *
 *
 * Problem Constraints
 * 1 <= N <= 100000
 * 0 <= A[i] < N
 *
 *
 * * Example Input *
 * Input 1:
 *
 *  A = [1, 2, 3, 4, 0]
 * Input 2:
 *
 *  A = [2, 0, 1, 3]
 *
 *
 * * Example Output *
 * Output 1:
 *
 *  1
 * Output 2:
 *
 *  2
 *
 *
 * * Example Explanation *
 * Explanation 1:
 *
 *  A = [1, 2, 3, 4, 0]
 *  To get the 0 in the first index, we have to take all elements in a single chunk.
 * Explanation 2:
 *
 *  A = [2, 0, 1, 3]
 *  We can divide the array into 2 chunks.
 *  First chunk is [2, 0, 1] and second chunk is [3].
 *
 *
 * * Hints *
 * <>
 *      The smallest leftmost possible chunk is the smallest index at which A[0….i]
 *      contains all elements up to i.
 *
 *      We can check that if a maximum of A[0…..i] is i, then we can take it as a separate chunk.
 *
 *      Find the smallest possible leftmost chunk using the above idea, and after that,
 *      we can proceed similarly for the remaining part.
 * </>
 *
 *
 *
 *
 *
 */


package sorting;

import java.util.ArrayList;

public class Max_Chunks_To_Make_Sorted {

    /**
     *
     * If the array
     * arr = [ 1, 2, 3, 4, 5, 0 ]
     * we have to check max value and when max value and i both are same
     * then we increase the chunk value.
     *
     * upper example chunk are 1 only
     *
     * @param A
     * @return
     */
    public int solve(ArrayList<Integer> A) {
        int chunkCount = 0;
        int max = Integer.MIN_VALUE;
        int n = A.size();
        for(int i=0; i<n; i++) {
            max = Math.max(max, A.get(i));      // storing max value
            if(max == i) chunkCount++;          // max == i -> value and index are same
        }                                       // increase chunk value.

        return chunkCount;
    }

    public static void main(String[] args) {

    }

}
