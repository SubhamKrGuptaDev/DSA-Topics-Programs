/**
 *
 * Problem Description
 *
 * Given a sorted array of integers A (0-indexed) of size N, find the left most and the right
 * most index of a given integer B in the array A.
 *
 * Return an array of size 2, such that
 *           First element = Left most index of B in A
 *           Second element = Right most index of B in A.
 * If B is not found in A, return [-1, -1].
 *
 * Note : Your algorithm's runtime complexity must be in the order of O(log n).
 *
 *
 *
 * Problem Constraints
 * 1 <= N <= 10^6
 * 1 <= A[i] <= 10^5
 * 1 <= B <= 10^5
 *
 *
 *
 * * Example Input *
 * Input 1:
 *
 * A = [1, 3, 5, 6]
 * B = 5
 * Input 2:
 *
 * A = [1, 4, 9]
 * B = 3
 *
 *
 * * Example Output *
 * Output 1:
 *
 * 2
 * Output 2:
 *
 * 1
 *
 *
 * * Example Explanation *
 * Explanation 1:
 *
 * The target value is present at index 2.
 * Explanation 2:
 *
 * The target value should be inserted at index 1.
 *
 * <>
 *     public int searchInsert(int[] A, int B) {
 *         int l = 0, h = A.length - 1;
 *         int ans = A.length;
 *         while (l <= h) {
 *             int mid = l + (h - l) / 2;
 *             if (A[mid] > B) {
 *                 ans = Math.min(ans, mid);
 *                 h = mid - 1;
 *             } else if (A[mid] < B) {
 *                 l = mid + 1;
 *             } else
 *                 return mid;
 *         }
 *         return ans;
 *     }
 * </>
 *
 *
 *
 *
 */


package BinarySearch;

import java.util.ArrayList;

public class Sorted_Insert_Position {

    // Binary Search
    public int binarySearch(ArrayList<Integer> A, int B) {
        int left = 0;
        int right = A.size() - 1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(A.get(mid) == B) {
                return mid;
            }
            if(A.get(mid) < B) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }

        return left;
    }

    // Linear Search
    public int linearSearch(ArrayList<Integer> A, int B) {
        int n = A.size();
        for(int i=0; i<n; i++) {
            if(A.get(i) >= B) {
                return i;
            }
        }

        return n;
    }

}
