/**
 *
 * Problem Description
 * Given an integer array A containing N distinct integers, you have to find all the leaders in array A. An element is a leader if it is strictly greater than all the elements to its right side.
 *
 * NOTE: The rightmost element is always a leader.
 *
 *
 * Problem Constraints
 * 1 <= N <= 105
 * 1 <= A[i] <= 108
 *
 *
 * Input Format
 * There is a single input argument which a integer array A
 *
 *
 * Output Format
 * Return an integer array denoting all the leader elements of the array.
 *
 *
 * Example Input
 * Input 1:
 *  A = [16, 17, 4, 3, 5, 2]
 * Input 2:
 *  A = [5, 4]
 *
 *
 * Example Output
 * Output 1:
 * [17, 2, 5]
 * Output 2:
 * [5, 4]
 *
 *
 * Example Explanation
 * Explanation 1:
 *  Element 17 is strictly greater than all the elements on the right side to it.
 *  Element 2 is strictly greater than all the elements on the right side to it.
 *  Element 5 is strictly greater than all the elements on the right side to it.
 *  So we will return these three elements i.e [17, 2, 5], we can also return [2, 5, 17] or [5, 2, 17] or any other ordering.
 * Explanation 2:
 *  Element 5 is strictly greater than all the elements on the right side to it.
 *  Element 4 is strictly greater than all the elements on the right side to it.
 *  So we will return these two elements i.e [5, 4], we can also any other ordering.
 *
 *
 */

package Array.carry_forward;

import java.util.ArrayList;

public class Leaders_in_an_array {

    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        return OptimizedApproach(A);
    }

    // Brute Force
    private ArrayList<Integer> bruteForce(ArrayList<Integer> A) {
        int n = A.size();
        ArrayList<Integer> result = new ArrayList<>();
        if(n == 1) {
            result.add(A.get(0));
            return result;
        }

        for(int i=0; i<n; i++) {
            int max = A.get(i);
            for(int j=i+1; j<n; j++) {
                if(max < A.get(j)) {
                    max = A.get(j);
                    break;
                }
            }
            if(max == A.get(i)) {
                result.add(max);
            }
        }

        return result;
    }

    // Optimized Approach
    private ArrayList<Integer> OptimizedApproach(ArrayList<Integer> A) {
        int n = A.size();
        int carry = A.get(n-1);
        ArrayList<Integer> result = new ArrayList<>();
        result.add(carry);
        for(int i=n-2; i>=0; i--) {
            if(carry < A.get(i)) {
                result.add(A.get(i));
                carry = A.get(i);
            }

        }
        return result;
    }

    public static void main(String[] args) {

    }

}
