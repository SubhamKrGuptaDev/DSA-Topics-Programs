/**
 *
 * Leetcode link - https://leetcode.com/problems/count-number-of-nice-subarrays/description/
 *
 * Problem Statement
 * Given an array of integers nums and an integer k. A continuous subarray is
 * called nice if there are k odd numbers on it.
 *
 * Return the number of nice sub-arrays.
 *
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 50000
 * 1 <= nums[i] <= 10^5
 * 1 <= k <= nums.length
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,1,2,1,1], k = 3
 * Output: 2
 * Explanation: The only sub-arrays with 3 odd numbers are [1,1,2,1] and [1,2,1,1].
 * Example 2:
 *
 * Input: nums = [2,4,6], k = 1
 * Output: 0
 * Explanation: There is no odd numbers in the array.
 * Example 3:
 *
 * Input: nums = [2,2,2,1,2,2,1,2,2,2], k = 2
 * Output: 16
 *
 *
 *
 */


package Array;

import java.util.HashMap;
import java.util.LinkedList;

public class Count_Number_of_Nice_Subarrays {

    // Sliding Window Approach - Best Approach TC: O(N) SC: O(1)
    public int numberOfSubarrays(int[] nums, int k) {
        return countAtMostK(nums, k) - countAtMostK(nums, k - 1);
    }

    private int countAtMostK(int[] nums, int k) {
        int len = nums.length;
        int count = 0;
        int res = 0;
        int l = 0;
        for (int r = 0; r < len; r++) {
            if (nums[r] % 2 == 1) {
                count++;
            }
            while (count > k) {
                if (nums[l] % 2 == 1) {
                    count--;
                }
                l++;
            }
            res += r - l + 1;
        }

        return res;
    }

    // HashMap Approach TC: O(N) SC: O(N)
    public int hashMapApproach(int[] nums, int k) {
        int n = nums.length;
        int sum = 0, res=0;
        HashMap<Integer,Integer> map = new HashMap();
        map.put(0,1);
        for(int i=0;i<n;i++)
        {
            if(nums[i]%2!=0)
                sum=sum+1;
            map.put(sum,map.getOrDefault(sum,0)+1);
            res=res+map.getOrDefault(sum-k,0);
        }
        return res;
    }

    // Queue Approach TC: O(N) SC: O(N)
    public int stackApproach(int[] nums, int k) {
        LinkedList<Integer> deq = new LinkedList();
        deq.add(-1);
        int res = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] % 2 == 1)
                deq.add(i);
            if (deq.size() > k + 1)
                deq.pop();
            if (deq.size() == k + 1)
                res += deq.get(1) - deq.get(0);
        }
        return res;
    }

    // Prefix + HashMap Approach TC: O(N) SC: O(N)
    int prefixSum(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i] % 2 == 1) nums[i] = 1;
            else nums[i] = 0;
        }
        HashMap<Integer, Integer> mpp = new HashMap<>();
        mpp.put(0, 1);
        for(int i=0; i<nums.length; i++) {
            sum += nums[i];
            mpp.put(sum, mpp.getOrDefault(sum, 0) + 1);
            count += mpp.getOrDefault(sum-k, 0);
        }
        return count;
    }


    public static void main(String[] args) {

    }

}
