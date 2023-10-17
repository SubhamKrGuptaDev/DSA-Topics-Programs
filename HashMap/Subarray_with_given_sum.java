/**
 *
 * Problem Description
 * Given an array of positive integers A and an integer B, find and return first
 * continuous subarray which adds to B.
 *
 * If the answer does not exist return an array with a single integer "-1".
 *
 * First sub-array means the sub-array for which starting index in minimum.
 *
 *
 * Problem Constraints
 * 1 <= length of the array <= 100000
 * 1 <= A[i] <= 10^9
 * 1 <= B <= 10^9
 *
 *
 * * Example Input *
 * Input 1:
 *
 *  A = [1, 2, 3, 4, 5]
 *  B = 5
 * Input 2:
 *
 *  A = [5, 10, 20, 100, 105]
 *  B = 110
 *
 *
 * * Example Output *
 * Output 1:
 *
 *  [2, 3]
 * Output 2:
 *
 *  [-1]
 *
 *
 * * Example Explanation *
 * Explanation 1:
 *
 *  [2, 3] sums up to 5.
 * Explanation 2:
 *
 *  No subarray sums up to required number.
 *
 */

package HashMap;

import java.util.ArrayList;
import java.util.HashMap;

public class Subarray_with_given_sum {

    // HashMap Approach
    public ArrayList<Integer> solve(ArrayList<Integer> A, int B) {
        int n = A.size();
        ArrayList<Integer> result = new ArrayList<>();
        HashMap<Long,Integer> map = new HashMap<>();
        long sum = 0;
        map.put(0L, -1);
        for(int i=0; i<n; i++) {
            sum += A.get(i);
            if(map.containsKey(sum - B)) {
                for(int index = map.get(sum - B) + 1; index<=i; index++) {
                    result.add(A.get(index));
                }

                return result;
            }
            map.put(sum, i);
        }

        result.add(-1);
        return result;
    }

    // Sliding window Approach
    public int[] solve(int[] A, int B) {
        long n = A.length;
        int l = 0, r = 0;
        long sum = A[l];
        while (r < n) {
            if (sum == B) {
                // current window sum = B
                int[] ans = new int[r - l + 1];
                for (int i = l; i <= r; i++) ans[i - l] = A[i];
                return ans;
            } else if (sum < B) {
                // current window sum < B
                r++;
                if (r < n) sum += A[r];
            } else {
                // current window sum > B
                sum -= A[l];
                l++;
                if (l > r && l < n - 1) {
                    r++;
                    sum += A[r];
                }
            }
        }
        int ans[] = new int[1];
        ans[0] = -1;
        return ans;
    }

    public static void main(String[] args) {

    }

}
