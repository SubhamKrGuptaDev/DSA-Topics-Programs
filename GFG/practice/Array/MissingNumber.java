/**
 * Given an array nums containing n distinct numbers in the range [0, n], return the only number in
 * the range that is missing from the array.
 *
 * Link: #{https://leetcode.com/problems/missing-number/}
 */


package GFG.practice.Array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MissingNumber {

    public int missingNumber(int[] nums) {
        return xorApproach(nums);
    }

    private int hashSetApproach(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int n = nums.length;

        for(int i=0; i<n; i++) {
            set.add(nums[i]);
        }

        for(int i=-0;i<n; i++) {
            if(!set.contains(i)) return i;
        }

        return n;
    }

    private int sortApproach(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;

        for(int i=0; i<n; i++) {
            if(nums[i] != i) return i;
        }

        return n;
    }

    private int fixEdArrApproach(int[] nums) {
        int fixSize = 100 * 100 + 1;
        int[] arrFixSize = new int[fixSize];
        int n = nums.length;

        for(int i=0; i<n; i++) {
            arrFixSize[nums[i]] = 1;
        }

        for(int i=0; i<fixSize; i++) {
            if(arrFixSize[i] == 0) return i;
        }

        return -1;
    }

    private int xorApproach(int[] nums) {
        int n = nums.length;
        int xor = 0;

        for(int i=0; i<=n; i++) {
            xor ^= i;
        }

        for(int i=0; i<n; i++) {
            xor ^= nums[i];
        }

        return xor;
    }

}
