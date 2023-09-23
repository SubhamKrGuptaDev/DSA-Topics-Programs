/**
 *
 * Problem Description
 * Given an array of integers A. If i < j and A[i] > A[j], then the pair (i, j)
 * is called an inversion of A.
 * Find the total number of inversions of A modulo (109 + 7).
 *
 *
 *
 * Problem Constraints
 * 1 <= length of the array <= 105
 *
 * 1 <= A[i] <= 10^9
 *
 *
 * * Example Input *
 * Input 1:
 *
 * A = [1, 3, 2]
 * Input 2:
 *
 * A = [3, 4, 1, 2]
 *
 *
 * * Example Output *
 * Output 1:
 *
 * 1
 * Output 2:
 *
 * 4
 *
 *
 * * Example Explanation *
 * Explanation 1:
 *
 * The pair (1, 2) is an inversion as 1 < 2 and A[1] > A[2]
 * Explanation 2:
 *
 * The pair (0, 2) is an inversion as 0 < 2 and A[0] > A[2]
 * The pair (0, 3) is an inversion as 0 < 3 and A[0] > A[3]
 * The pair (1, 2) is an inversion as 1 < 2 and A[1] > A[2]
 * The pair (1, 3) is an inversion as 1 < 3 and A[1] > A[3]
 *
 *
 * * Other Solution *
 *
 *     private int Mod = 1000 * 1000 * 1000 + 7;
 *     public int solve(int[] A) {
 *         return (int) mergeSort(A);
 *     }
 *     public long mergeSort(int[] A) {
 *         int[] temp = new int[A.length];
 *         return _mergeSort(A, temp, 0, A.length - 1) % Mod;
 *     }
 *     public long _mergeSort(int arr[], int temp[], int left, int right) {
 *         int mid;
 *         long inv_count = 0;
 *         if (right > left) {
 *             Divide the array into two parts and
 *             call _mergeSortAndCountInv()
 *             for each of the parts
 *             mid = (right + left) / 2;
 *              Inversion count will be sum of
 *             inversions in left-part, right-part
 *             and number of inversions in merging
 *             inv_count += _mergeSort(arr, temp, left, mid);
 *             inv_count += _mergeSort(arr, temp, mid + 1, right);
 *             Merge the two part
 *             inv_count += merge(arr, temp, left, mid + 1, right);
 *         }
 *         return inv_count % Mod;
 *     }
 *     public long merge(int arr[], int temp[], int left, int mid, int right) {
 *         int i, j, k;
 *         long inv_count = 0;
 *         i = left; // i is index for left subarray
 *         j = mid; // j is index for right subarray
 *         k = left; // k is index for resultant merged subarray
 *         while ((i <= mid - 1) && (j <= right)) {
 *             if (arr[i] <= arr[j])
 *                 temp[k++] = arr[i++];
 *             else {
 *                 temp[k++] = arr[j++];
 *                 inv_count = inv_count + (mid - i);
 *             }
 *         }
 *         // Copy the remaining elements of left subarray
 *                 //(if there are any) to temp
 *         while (i <= mid - 1)
 *             temp[k++] = arr[i++];
 *         // Copy the remaining elements of right subarray
 *               //  (if there are any) to temp
 *         while (j <= right)
 *             temp[k++] = arr[j++];
 *         //Copy back the merged elements to original array
 *         for (i = left; i <= right; i++)
 *             arr[i] = temp[i];
 *         return inv_count % Mod;
 *     }
 *
 *
 *
 */

package sorting;

import java.util.ArrayList;

public class Inversion_count_in_an_array {

    public int solve(ArrayList<Integer> A) {
        // return bruteForce(A);
        int mod = 1000 * 1000 * 1000 + 7;
        long count = mergeSortAlgo(A, 0, A.size()-1);
        return (int)(count % mod);
    }
    // Merge Sort implementation
    private long mergeSortAlgo(ArrayList<Integer> A, int start, int end) {
        if(start >= end) {
            return 0L;
        }

        int mid = (start + end) / 2;
        long tempCount1 = mergeSortAlgo(A, start, mid);
        long tempCount2 = mergeSortAlgo(A, mid+1, end);

        long count = mergeArray(A, start, mid, end);

        return tempCount1 + tempCount2 + count;
    }

    private long mergeArray(ArrayList<Integer> A, int start, int mid, int end) {
        int i = start;
        int n = mid;
        int j = mid+1;
        int m = end;
        long count = 0;
        ArrayList<Integer> temp = new ArrayList<>();
        while(i <= n && j <= m) {
            int a = A.get(i);
            int b = A.get(j);
            if(a > b) {
                count += n - i + 1;
                j++;
                temp.add(b);
            }
            else {
                temp.add(a);
                i++;
            }
        }

        while(i <= n) {
            temp.add(A.get(i));
            i++;
        }

        while(j <= m) {
            temp.add(A.get(j));
            j++;
        }

        for(i=start; i<=end; i++) {
            A.set(i, temp.get(i-start));
        }

        return count;
    }

    // BruteForce Approach
    private int bruteForce(ArrayList<Integer> A) {
        int count = 0;
        int n = A.size();
        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                if(A.get(i) > A.get(j)) {
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {

    }

}
