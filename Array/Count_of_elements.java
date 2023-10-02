/**
 *
 * Problem Description
 * Given an array A of N integers.
 * Count the number of elements that have at least 1 elements greater than itself.
 *
 *
 * Problem Constraints
 * 1 <= N <= 10^5
 * 1 <= A[i] <= 10^9
 *
 *
 * * Example Input *
 * Input 1:
 * A = [3, 1, 2]
 * Input 2:
 * A = [5, 5, 3]
 *
 *
 * * Example Output *
 * Output 1:
 * 2
 * Output 2:
 * 1
 *
 *
 * * Example Explanation *
 * Explanation 1:
 * The elements that have at least 1 element greater than itself are 1 and 2
 * Explanation 2:
 * The elements that have at least 1 element greater than itself is 3
 *
 *
 *
 *
 *
 *
 */

package Array;

import java.util.ArrayList;

public class Count_of_elements {

    // Linear TC: N
    public int solve(int[] A) {
        int max_value = 0, max_count = 0;
        for(int i = 0 ; i < A.length ; i++){
            if(A[i] > max_value){
                max_value = A[i];
                max_count = 1;
            }
            else if(A[i] == max_value){
                max_count += 1;
            }
        }
        return A.length - max_count;
    }

    // Linear TC: N+N
    public int solve(ArrayList<Integer> A) {
        int max = Integer.MIN_VALUE;
        int n = A.size();
        for(int i=0; i<n; i++) {
            max = Math.max(max, A.get(i));
        }
        int count = 0;
        for(int i=0; i<n; i++) {
            if(max != A.get(i)) count++;
        }
        return count;
    }

    public static void main(String[] args) {

    }

}
