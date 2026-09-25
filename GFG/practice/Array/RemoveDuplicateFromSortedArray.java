/**
 * You are given a sorted array arr[] containing positive integers. Your task is to remove all duplicate
 * elements from this array such that each element appears only once.
 * Return an array containing these distinct elements in the same order as they appeared.
 *
 *
 * Link: #{https://www.geeksforgeeks.org/problems/remove-duplicate-elements-from-sorted-array/1?sortBy=submissions&category%5B%5D=Arrays&page=1&difficulty%5B%5D=0}
 *
 */



package GFG.practice.Array;

import java.util.ArrayList;

public class RemoveDuplicateFromSortedArray {

    ArrayList<Integer> removeDuplicates(int[] arr) {
        // code here
        return helper(arr);
    }

    private ArrayList<Integer> helper(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> ans = new ArrayList<>();

        ans.add(arr[0]);
        for(int i=1; i<n; i++) {
            if(arr[i] != ans.get(ans.size() - 1)) {
                ans.add(arr[i]);
            }
        }

        return ans;
    }

}
