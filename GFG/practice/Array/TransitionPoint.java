/**
 * Given a sorted array, arr[] containing only 0s and 1s, find the transition point, i.e.,
 * the first index where 1 was observed, and before that, only 0 was observed.
 * If arr does not have any 1, return -1. If array does not have any 0, return 0.
 *
 *
 * Lin: #{https://www.geeksforgeeks.org/problems/find-transition-point-1587115620/1?sortBy=submissions&category%5B%5D=Arrays&page=1&difficulty%5B%5D=0}
 *
 *
 */


package GFG.practice.Array;

public class TransitionPoint {

    int transitionPoint(int arr[]) {
        // code here
        return helper(arr);
    }

    private int helper(int[] arr) {
        int n = arr.length;

        for(int i=0; i<n; i++) {
            if(arr[i] == 1) return i;
        }

        return -1;
    }

}
