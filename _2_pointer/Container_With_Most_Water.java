/**
 *
 *
 * Problem Description
 * Given N non-negative integers A[0], A[1], ..., A[N-1] , where each represents a point at
 * coordinate (i, A[i]).
 *
 * N vertical lines are drawn such that the two endpoints of line i is at (i, A[i]) and (i, 0).
 *
 * Find two lines, which together with x-axis forms a container, such that the container
 * contains the most water. You need to return this maximum area.
 *
 * Note: You may not slant the container. It is guaranteed that the answer will fit in integer
 * limits.
 *
 *
 *
 * Problem Constraints
 * 1 <= N <= 10^5
 *
 * 1 <= A[i] <= 10^5
 *
 *
 *
 * * Example Input *
 * Input 1:
 *
 * A = [1, 5, 4, 3]
 * Input 2:
 *
 * A = [1]
 *
 *
 * * Example Output *
 * Output 1:
 *
 *  6
 * Output 2:
 *
 *  0
 *
 *
 * * Example Explanation *
 * Explanation 1:
 *
 * 5 and 3 are distance 2 apart. So size of the base = 2. Height of container = min(5, 3) = 3.
 * So total area = 3 * 2 = 6
 * Explanation 2:
 *
 * No container is formed.
 *
 *
 *
 *
 *
 */



package _2_pointer;

import java.util.ArrayList;

public class Container_With_Most_Water {
    public int maxArea(ArrayList<Integer> A) {
        int n = A.size();
        int i=0;
        int j = n-1;
        int min = Integer.MAX_VALUE;
        int ans = Integer.MIN_VALUE;
        while(i<j) {
            min = Math.min(A.get(i), A.get(j)) * (j-i);
            ans = Math.max(min, ans);
            if(A.get(i) == A.get(j)) {
                i++;
                j--;
            }
            else if(A.get(i) < A.get(j)) i++;
            else j--;
        }

        if(ans == Integer.MIN_VALUE) ans = 0;

        return ans;
    }

    public int Solution(ArrayList < Integer > A) {
        if (A == null)
            return 0;
        int n = A.size();
        int first = 0;
        int last = n - 1;
        int area = 0;
        while (first < last) {
            int width = last - first;
            // finds the area for the current window
            area = Math.max(area, Math.min(A.get(first), A.get(last)) * width);
            if (A.get(first).intValue() >= A.get(last).intValue())
                last--;
            else
                first++;
        }
        return area;
    }

    public static void main(String[] args) {

    }
}
