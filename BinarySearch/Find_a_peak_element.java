/**
 *
 * Problem Description
 * Given an array of integers A, find and return the peak element in it.
 * An array element is considered a peak if it is not smaller than its neighbors.
 * For corner elements, we need to consider only one neighbor.
 *
 *
 * NOTE:
 *
 * It is guaranteed that the array contains only a single peak element.
 * Users are expected to solve this in O(log(N)) time. The array may contain duplicate elements.
 *
 *
 * Problem Constraints
 * 1 <= |A| <= 100000
 *
 * 1 <= A[i] <= 10^9
 *
 *
 * * Example Input *
 * Input 1:
 *
 * A = [1, 2, 3, 4, 5]
 * Input 2:
 *
 * A = [5, 17, 100, 11]
 *
 *
 * * Example Output *
 * Output 1:
 *
 *  5
 * Output 2:
 *
 *  100
 *
 *
 * * Example Explanation *
 * Explanation 1:
 *
 *  5 is the peak.
 * Explanation 2:
 *
 *  100 is the peak.
 *
 *
 *
 *
 *
 */


package BinarySearch;

import java.util.ArrayList;

public class Find_a_peak_element {

    // Logger arithmetic  Approach
    public int optimizedApproach(ArrayList<Integer> A) {
        int n = A.size();
        if(n == 1) return A.get(0);
        int left = 0;
        int right = n-1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(((mid == 0 && A.get(mid) >= A.get(mid+1)) ||
                    (mid == n-1 && A.get(mid) >= A.get(mid-1))) ||
                    (mid != 0 && mid != n-1 && A.get(mid - 1) < A.get(mid) && A.get(mid) > A.get(mid+1))
            ) {
                return A.get(mid);
            }
            if(A.get(mid) <= A.get(mid + 1)) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }

        return -1;
    }

    // Linear Approach
    public int linearApproach(ArrayList<Integer> A) {
        int n = A.size();
        if(n == 1) return A.get(0);
        for(int i=1; i<n-1; i++) {
            if(A.get(i-1) < A.get(i) && A.get(i) > A.get(i+1)) {
                return A.get(i);
            }
        }

        if(A.get(0) >= A.get(1)) return A.get(0);
        if(A.get(n-1) >= A.get(n-2)) return A.get(n-1);

        return -1;
    }

    // Brute Force Approach
    public int bruteForce(ArrayList<Integer> A) {
        int n = A.size();
        if(n == 1) return A.get(0);
        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n-1; j++) {
                if(j == n-2 && A.get(j) <= A.get(j+1)) return A.get(j+1);
                if(i == 0 && A.get(i) >= A.get(j)) return A.get(i);
                if(A.get(i) < A.get(j) && A.get(j) > A.get(j+1)) {
                    return A.get(j);
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {

    }

}
