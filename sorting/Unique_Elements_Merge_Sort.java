/**
 *
 * Problem Description
 * You are given an array A of N elements. You have to make all elements unique.
 * To do so, in one step you can increase any number by one.
 *
 * Find the minimum number of steps.
 *
 *
 * Problem Constraints
 * 1 <= N <= 10^5
 * 1 <= A[i] <= 10^9
 *
 *
 * * Example Input *
 * Input 1:
 *
 *  A = [1, 1, 3]
 * Input 2:
 *
 *  A = [2, 4, 5]
 *
 * * Example Output *
 * Output 1:
 *
 *  1
 * Output 2:
 *
 *  0
 *
 * * Example Explanation *
 * Explanation 1:
 *
 *  We can increase the value of 1st element by 1 in 1 step and will get all unique elements. i.e [2, 1, 3].
 * Explanation 2:
 *
 *  All elements are distinct.
 *
 *
 *
 *  * Solution *
 *      public int solve(int[] A) {
 *         int n = A.length;
 *         // sort the array
 *         Arrays.sort(A);
 *         // initialize variables
 *         int steps = 0, i = 1, j = 0;
 *         // loop unitil you reach the end
 *         while (j < n) {
 *             // make current element unique
 *             if (i >= A[j]) {
 *                 steps += (i - A[j++]);
 *                 i += 1;
 *             } else {
 *                 i = A[j] + 1;
 *                 j += 1;
 *             }
 *         }
 *         // return the answer
 *         return steps;
 *     }
 *
 *
 */


package sorting;

import java.util.ArrayList;

public class Unique_Elements_Merge_Sort {

    public int solve(ArrayList<Integer> A) {
        int n = A.size();
        mergeSort(A, 0, n-1);
        // Collections.sort(A);
        int count = 0;
        for(int i=1; i<n; i++) {
            if(A.get(i-1).equals(A.get(i))) {
                count++;
                A.set(i, A.get(i) + 1);
            }
            else if(A.get(i-1) > A.get(i)) {
                int tempValue = A.get(i-1) + 1;
                count += tempValue - A.get(i);
                A.set(i, tempValue);
            }
        }
        return count;
    }
    // Merge Sort Implementation
    private void mergeSort(ArrayList<Integer> A, int start, int end) {
        if(start >= end) {
            return;
        }

        int mid = (start + end) / 2;

        // Recursion Call
        mergeSort(A,start, mid);
        mergeSort(A, mid+1, end);

        mergeArray(A, start, mid, end);
    }

    private void mergeArray(ArrayList<Integer> A, int start, int mid, int end) {
        int i=start, j=mid+1;
        ArrayList<Integer> newArray = new ArrayList<>();
        while(i <= mid && j <= end) {
            if(A.get(i) > A.get(j)) {
                newArray.add(A.get(j));
                j++;
            }
            else {
                newArray.add(A.get(i));
                i++;
            }
        }
        while(i <= mid) {
            newArray.add(A.get(i));
            i++;
        }
        while(j <= end) {
            newArray.add(A.get(j));
            j++;
        }
        for(i = start; i <= end; i++) {
            A.set(i, newArray.get(i-start));
        }
    }

    public static void main(String[] args) {

    }

}
