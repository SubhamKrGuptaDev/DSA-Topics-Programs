
/**
 * * Problem Description *
 *
 * Given an array of integers A and an integer B,
 * find and return the minimum number of swaps required to bring
 * all the numbers less than or equal to B together.
 *
 * Note: It is possible to swap any two elements, not necessarily consecutive.
 *
 * * Problem Constraints *
 *
 * 1 <= length of the array <= 100000
 * -109 <= A[i], B <= 109
 *
 * * Example Input *
 *
 * Input 1:
 *
 *  A = [1, 12, 10, 3, 14, 10, 5]
 *  B = 8
 *
 * Input 2:
 *
 *  A = [5, 17, 100, 11]
 *  B = 20
 *
 *
 * Example Output
 *
 * Output 1:
 *
 *  2
 * Output 2:
 *
 *  1
 *
 *
 *  * Example Explanation *
 *
 *  * Explanation 1: *
 *
 *  A = [1, 12, 10, 3, 14, 10, 5]
 *  After swapping  12 and 3, A => [1, 3, 10, 12, 14, 10, 5].
 *  After swapping  the first occurence of 10 and 5, A => [1, 3, 5, 12, 14, 10, 10].
 *  Now, all elements less than or equal to 8 are together.
 *  * Explanation 2: *
 *
 *  A = [5, 17, 100, 11]
 *  After swapping 100 and 11, A => [5, 17, 11, 100].
 *  Now, all elements less than or equal to 20 are together.
 *
 * -----------------------------------------------------------------------------------------------
 * * Hint *
 * First, find the number of elements that are less than or equal to B. Let the count comes out to be X.
 * Maintain a window of X and check how many elements we need to swap so that all X elements come in that window.
 *
 * We store the minimum of all that and return that.
 * -----------------------------------------------------------------------------------------------
 *
 *
 *
 *
 *
 */


package Array.sliding_windows;

import java.util.Arrays;
import java.util.List;

public class Minimum_Swaps {

    public static int solve(List<Integer> A, int B) {
        int countNumber = 0;
        // Count Numbers for window
        for(int X : A) {
            if(X <= B) {
                countNumber++;
            }
        }

        int minValue = 0;
        int min = Integer.MAX_VALUE;
        int notMatch = 0;
        // range window
        for(int i=0; i<countNumber; i++) {
            if(A.get(i) > B) {
                notMatch++;
            }
        }
        min = Math.min(min, notMatch);
        int n = A.size();
        /**
         * already calculate range how many value want to swap
         * we need to check every time which value input inside the range and
         * check which not out of range.
         *
         *
         */
        for(int i=countNumber; i<n; i++) {
            if(A.get(i) > B) {  // Insert in range
                notMatch++;
            }
            if(A.get(i-countNumber) > B) { // out of range
                notMatch--;
            }
            min = Math.min(min, notMatch);  // continue store min not matched condition values.
        }
        return min;
    }

    public static void main(String[] args) {
        int result = solve(Arrays.asList(1, 12, 24, 3, 45, 12, 7), 8);
        if(result != 2) {
            throw new RuntimeException("Test Case Not Passed");
        }
        System.out.println("Solution " + result);
    }

}
