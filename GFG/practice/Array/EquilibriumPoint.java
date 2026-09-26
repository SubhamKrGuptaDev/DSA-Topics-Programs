/**
 * Given an array of integers arr[], the task is to find the first equilibrium point in the array.
 *
 * The equilibrium point in an array is an index (0-based indexing) such that the sum of
 * all elements before that index is the same as the sum of elements after it. Return -1 if no such point exists.
 *
 *
 * Link: #{https://www.geeksforgeeks.org/problems/equilibrium-point-1587115620/1?sortBy=submissions&category%5B%5D=Arrays&page=1&difficulty%5B%5D=0}
 *
 *
 *
 */



package GFG.practice.Array;

public class EquilibriumPoint {
    public static int findEquilibrium(int arr[]) {
        // code here
        return helper(arr);
    }

    private static int helper(int[] arr) {
        int n = arr.length;
        int totalSum=0;

        for(int x : arr) totalSum += x;

        int prefixSum = 0;
        for(int i=0; i<n; i++) {
            int suffixSum = totalSum - prefixSum - arr[i];

            if(suffixSum == prefixSum) return i;

            prefixSum += arr[i];
        }


        return -1;
    }

    private static int helper2(int[] arr) {
        int n = arr.length;
        int[] prefixSum = new int[n];
        int[] suffixSum = new int[n];

        // Prefix Sum
        prefixSum[0] = arr[0];
        for(int i=1; i<n; i++) {
            prefixSum[i] = prefixSum[i-1] + arr[i];
        }

        // Suffix Sum
        suffixSum[n-1] = arr[n-1];
        for(int i=n-2; i>=0; i--) {
            suffixSum[i] = suffixSum[i+1] + arr[i];
        }

        for(int i=0; i<n; i++) {
            if(prefixSum[i] == suffixSum[i]) {
                return i;
            }
        }

        return -1;
    }

    // Brute Force
    private static int helper1(int[] arr) {
        int n = arr.length;
        for(int i=0; i<n; i++) {
            int leftSum = 0;
            int rightSum = 0;

            for(int j=0; j<i; j++) {
                leftSum += arr[j];
            }

            for(int j=i+1; j<n; j++) {
                rightSum += arr[j];
            }

            if(leftSum == rightSum) {
                return i;
            }

        }
        return -1;
    }

}
