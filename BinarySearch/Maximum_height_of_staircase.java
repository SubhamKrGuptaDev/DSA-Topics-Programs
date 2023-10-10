/**
 *
 * Problem Description
 * Given an integer A representing the number of square blocks. The height of each square
 * block is 1. The task is to create a staircase of max-height using these blocks.
 *
 * The first stair would require only one block, and the second stair would require two blocks,
 * and so on.
 *
 * Find and return the maximum height of the staircase.
 *
 *
 * Problem Constraints
 * 0 <= A <= 10^9
 *
 *
 *
 * * Example Input *
 * Input 1:
 *
 *  A = 10
 * Input 2:
 *
 *  A = 20
 *
 *
 * * Example Output *
 * Output 1:
 *
 *  4
 * Output 2:
 *
 *  5
 *
 *
 * * Example Explanation *
 * Explanation 1:
 *
 *  The stairs formed will have height 1, 2, 3, 4.
 * Explanation 2:
 *
 *  The stairs formed will have height 1, 2, 3, 4, 5.
 *
 *
 */


package BinarySearch;

public class Maximum_height_of_staircase {

    // Binary Search
    public int solve(int A) {
        long left = 1;
        long right = A;
        long ans = Long.MIN_VALUE;

        while(left <= right) {
            long mid = (left + right) / 2;
            long sumNatural1 = (mid * (mid + 1)) / 2;
            if(sumNatural1 > A) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
                ans = mid;
            }
        }

        if(ans == Long.MIN_VALUE) return 0;

        return (int)ans;
    }

    // Brute Force
    public int bruteForce(int A) {
        int ans = 0;
        for(int i=0; i<=A; i++) {
            int sumNatural = (i * (i + 1)) / 2;
            if(sumNatural <= A) {
                ans = i;
            }
            else {
                break;
            }
        }

        return ans;
    }


}
