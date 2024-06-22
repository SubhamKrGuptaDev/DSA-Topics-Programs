/**
 * leetcode - https://leetcode.com/problems/count-number-of-nice-subarrays/description/?envType=daily-question&envId=2024-06-22
 *
 * 1248. Count Number of Nice Subarrays
 *
 * Given an array of integers nums and an integer k. A continuous subarray is called nice if there are k odd numbers on it.
 *
 * Return the number of nice sub-arrays.
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
 * Explanation: There are no odd numbers in the array.
 * Example 3:
 *
 * Input: nums = [2,2,2,1,2,2,1,2,2,2], k = 2
 * Output: 16
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
 */



package leetcode;

public class Count_Number_of_Nice_Subarrays {

    public static int numberOfSubarrays(int[] nums, int k) {
        return process(nums, k) - process(nums, k - 1);
    }

    private static int process(int[] nums, int k) {
        int n = nums.length;

        int count = 0;
        int result = 0;
        int left = 0;

        for(int i=0; i<n; i++) {
            if(checkOdd(nums[i])) count++;

            while(count > k) {
                if(checkOdd(nums[left])) count--;
                left++;
            }
            result += i - left + 1;
        }

        return result;
    }

    private static boolean checkOdd(int n) {
        return n % 2 != 0;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2,1,1};
        int k = 2;

        System.out.println(numberOfSubarrays(nums, k));

    }

}
