/**
 *
 * Problem Description
 * Given an array A of non-negative integers of size N. Find the minimum sub-array
 * Al, Al+1 ,..., Ar such that if we sort(in ascending order) that sub-array,
 * then the whole array should get sorted. If A is already sorted, output -1.
 *
 * Note :
 * Follow 0-based indexing, while returning the sub-array's starting and ending indexes.
 *
 *
 * Problem Constraints
 * 1 <= N <= 10^6
 * 1 <= A[i] <= 10^6
 *
 *
 * Input Format
 * First and only argument is an array of non-negative integers of size N.
 *
 *
 *
 * Output Format
 * Return an array of length two where,
 * the first element denotes the starting index(0-based) and
 * the second element denotes the ending index(0-based) of the sub-array.
 * If the array is already sorted, return an array containing only one element i.e. -1.
 *
 *
 * * Example Input *
 * Input 1:
 *
 * A = [1, 3, 2, 4, 5]
 * Input 2:
 *
 * A = [1, 2, 3, 4, 5]
 *
 *
 * * Example Output *
 * Output 1:
 *
 * [1, 2]
 * Output 2:
 *
 * [-1]
 *
 *
 * * Example Explanation *
 * Explanation 1:
 *
 * If we sort the sub-array [A1, A2] then the whole array A gets sorted.
 * Explanation 2:
 *
 * A is already sorted.
 *
 *
 */

package sorting;

import java.util.ArrayList;

public class Maximum_Unsorted_Subarray {

    public ArrayList<Integer> subUnsort(ArrayList<Integer> A) {
        ArrayList<Integer> result = new ArrayList<>();
        int n = A.size();
        int left = 0;
        int right = n-1;

        // First left unsorted element
        while(left < n-1 && A.get(left) <= A.get(left + 1)) {
            left++;
        }

        // First right unsorted element
        while(right > 0 && A.get(right) >= A.get(right - 1)) {
            right--;
        }

        // if left reach n-1 that means array is sorted
        if(left == n-1) {
            result.add(-1);
            return result;
        }

        // get max and min element from left to right
        int min = A.get(left);
        int max = A.get(left);
        for(int i = left+1; i<=right; i++) {
            min = Math.min(min, A.get(i));
            max = Math.max(max, A.get(i));
        }

        int newLeft = 0;
        int newRight = n-1;

        // left index
        while(A.get(newLeft) <= min && newLeft <= left) newLeft++;

        // right index
        while(A.get(newRight) >= max && newRight >= right) newRight--;

        result.add(newLeft);
        result.add(newRight);

        return result;
    }

    public static void main(String[] args) {

    }

}
