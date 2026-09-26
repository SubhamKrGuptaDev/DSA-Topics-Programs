/**
 * Given an array arr[] containing only non-negative integers, your task is to find a continuous
 * subarray (a contiguous sequence of elements) whose sum equals a specified value target .
 *
 * You need to return the 1-based indices of the leftmost and rightmost elements of this subarray.
 *
 * You need to find the first subarray whose sum is equal to the target.
 * If no such array is possible then, return [-1].
 *
 *
 * Link: #{https://www.geeksforgeeks.org/problems/subarray-with-given-sum-1587115621/1?sortBy=submissions&category%5B%5D=Arrays&page=1&difficulty%5B%5D=0}
 *
 */



package GFG.practice.Array;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class IndexesOfSubArraySum {

    static ArrayList<Integer> subarraySum(int[] arr, int target) {
        // code here
        return helper1(arr, target);
    }

    private static ArrayList<Integer> helper1(int[] arr, int target) {
        int n = arr.length;
        ArrayList<Integer> ans = new ArrayList<>();
        int sum=0;
        int left = 0;

        for(int right=0; right<n; right++) {
            sum += arr[right];
            while(sum > target) {
                sum -= arr[left++];
            }
            if(sum == target) {
                ans.add(left+1);
                ans.add(right+1);
                return ans;
            }
        }

        ans.add(-1);
        return ans;
    }

    // Prefix Sum not working
    private static ArrayList<Integer> helper(int[] arr, int target) {
        int n = arr.length;
        ArrayList<Integer> ans = new ArrayList<>();
        int[] subArr = new int[n];
        int sum = 0;

        for(int i=0; i<n; i++) {
            sum += arr[i];
            subArr[i] = sum;
        }

        for(int R=0; R<n; R++) {
            sum = subArr[R];
            int L=0;
            while(sum > target) {
                sum -= subArr[L++];
            }
            if(sum == target) {
                ans.add(L+1);
                ans.add(R+1);
                return ans;
            }
        }

        ans.add(-1);
        return ans;
    }

    public static void main(String[] args) {
//        int[] arr = {1,2,3,7,5};
//        int target = 12;
        int[] arr = {12, 18, 5, 11, 30, 5};
        int target = 69;

        for(int x : subarraySum(arr, target)) {
            System.out.println(x);
        }

    }

}
