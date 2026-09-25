/**
 * You are given an array arr[]. Replace every element with the next greatest element
 * (the greatest element on its right side) in the array. Note: There is no element next to the last element,
 * so replace it with -1.
 *
 * link: #{https://www.geeksforgeeks.org/problems/greater-on-right-side4305/1?sortBy=submissions&category%5B%5D=Arrays&page=3&difficulty%5B%5D=-1}
 *
 */




package GFG.practice.Array;

import java.util.ArrayList;

public class GreatestElementOnRight {

    static ArrayList<Integer> nextGreatest(int arr[]) {
        // code here
        return helper(arr);
    }

    private static ArrayList<Integer> helper(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> ans = getArrayList(n);

        for(int i=n-1; i>0; i--) {
            if(arr[i] > ans.get(i)) {
                ans.set(i-1, arr[i]);
            } else {
                ans.set(i-1, ans.get(i));
            }
        }

        return ans;
    }

    private static ArrayList<Integer> getArrayList(int n) {
        ArrayList<Integer> arr = new ArrayList<>();

        for(int i=0; i<n; i++) {
            arr.add(0);
        }

        arr.set(n-1, -1);
        return arr;
    }

}
