/**
 *
 * Given an array arr[] containing only 0s, 1s, and 2s. Sort the array in ascending order.
 * Note: You need to solve this problem without utilizing the built-in sort function.
 *
 *
 * Link: #{https://www.geeksforgeeks.org/problems/sort-an-array-of-0s-1s-and-2s4231/1?sortBy=submissions&category%5B%5D=Arrays&page=1&difficulty%5B%5D=0}
 *
 *
 */


package GFG.practice.Array;

public class Sort01And2 {

    public void sort012(int[] arr) {
        // code here
        helper(arr);
    }

    private void helper(int[] arr) {
        int zero = 0;
        int one = 0;
        int n = arr.length;

        for(int i=0; i<n; i++) {
            if(arr[i] == 0) zero++;
            if(arr[i] == 1) one++;
        }

        int index=0;
        while(index < zero) {
            arr[index] = 0;
            index++;
        }

        while(index < zero+one) {
            arr[index] = 1;
            index++;
        }

        while(index < n) {
            arr[index] = 2;
            index++;
        }

    }

}
