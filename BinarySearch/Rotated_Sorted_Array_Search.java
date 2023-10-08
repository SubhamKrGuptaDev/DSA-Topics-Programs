/**
 *
 * Problem Description
 * Given a sorted array of integers A of size N and an integer B,
 * where array A is rotated at some pivot unknown beforehand.
 *
 * For example, the array [0, 1, 2, 4, 5, 6, 7] might become [4, 5, 6, 7, 0, 1, 2].
 *
 * Your task is to search for the target value B in the array. If found,
 * return its index; otherwise, return -1.
 *
 * You can assume that no duplicates exist in the array.
 *
 * NOTE: You are expected to solve this problem with a time complexity of O(log(N)).
 *
 *
 *
 * Problem Constraints
 * 1 <= N <= 1000000
 * 1 <= A[i] <= 10^9
 * All elements in A are Distinct.
 *
 *
 *
 * * Example Input *
 * Input 1:
 *
 * A = [4, 5, 6, 7, 0, 1, 2, 3]
 * B = 4
 * Input 2:
 *
 * A : [ 9, 10, 3, 5, 6, 8 ]
 * B : 5
 *
 *
 * * Example Output *
 * Output 1:
 *
 *  0
 * Output 2:
 *
 *  3
 *
 *
 * * Example Explanation *
 * Explanation 1:
 *
 * Target 4 is found at index 0 in A.
 * Explanation 2:
 *
 * Target 5 is found at index 3 in A.
 *
 *
 *
 *
 *
 */


package BinarySearch;

import java.util.List;

public class Rotated_Sorted_Array_Search {

    private int simpleBinarySearch(List<Integer> A, int target, int left, int right) {

        while(left <= right) {
            int mid = (left + right) / 2;
            if(A.get(mid) == target) {
                return mid;
            }
            if(target < A.get(0)) {
                if(A.get(mid) >= A.get(0)) left = mid + 1;
                else {
                    if(A.get(mid) < target) left = mid + 1;
                    else right = mid - 1;
                }
            }
            else {
                if(A.get(mid) < A.get(0)) right = mid - 1;
                else {
                    if(A.get(mid) < target) left = mid + 1;
                    else right = mid - 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {

    }

}
