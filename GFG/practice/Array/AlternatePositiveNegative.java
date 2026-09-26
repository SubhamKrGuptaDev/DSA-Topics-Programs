/**
 *
 * Given an unsorted array arr containing both positive and negative numbers. Your task is to rearrange
 * the array and convert it into an array of alternate positive and negative numbers without changing the
 * relative order.
 *
 * Note:
 *
 * Resulting array should start with a positive integer (0 will also be considered as a positive integer).
 * If any of the positive or negative integers are exhausted, then add the remaining integers in the answer as it is by maintaining the relative order.
 *
 *
 * Link: #{https://www.geeksforgeeks.org/problems/array-of-alternate-ve-and-ve-nos1401/1?sortBy=submissions&category%5B%5D=Arrays&page=2&difficulty%5B%5D=0}
 *
 */


package GFG.practice.Array;

import java.util.ArrayList;

public class AlternatePositiveNegative {
    void rearrange(ArrayList<Integer> arr) {
        // code here
        helper(arr);
    }

    private void helper(ArrayList<Integer> arr) {
        int n = arr.size();
        ArrayList<Integer> positive = new ArrayList<>();
        ArrayList<Integer> negative = new ArrayList<>();

        for(int x : arr) {
            if(x >= 0) {
                positive.add(x);
            } else {
                negative.add(x);
            }
        }

        int i=0,j=0,index=0;
        int size=positive.size(),len=negative.size();
        while(i < size && j < len) {
            arr.set(index++, positive.get(i++));
            arr.set(index++, negative.get(j++));
        }

        while(i < size) {
            arr.set(index++, positive.get(i++));
        }

        while(j < len) {
            arr.set(index++, negative.get(j++));
        }

    }
}
