/**
 *
 * Given an array arr[] where no two adjacent elements are same, find the index of a peak element.
 * An element is considered to be a peak if it is greater than its adjacent elements (if they exist).
 *
 * If there are multiple peak elements, Return index of any one of them. The output will be "true" if the
 * index returned by your function is correct; otherwise, it will be "false".
 *
 * Note: Consider the element before the first element and the element after the last element to be
 * negative infinity.
 *
 *
 * Link: #{https://www.geeksforgeeks.org/problems/peak-element/1?sortBy=submissions&category%5B%5D=Arrays&page=1&difficulty%5B%5D=0}
 *
 *
 */



package GFG.practice.Array;

public class PeakElement {
    public int peakElement(int[] arr) {
        // code here
        return helper(arr);
    }

    private int helper(int[] arr) {
        int n = arr.length;

        if(n == 1) return 0;

        for(int i=1;i<n-1; i++) {
            if(arr[i-1] < arr[i] && arr[i] > arr[i+1])
                return i;
        }

        if(arr[0] > arr[1]) return 0;

        if(arr[n-1] > arr[n-2]) return n-1;

        return -1;
    }
}
