/**
 * Binary Array Sorting
 * You are given a binary array arr[], where each element is either 0 or 1. Your task is to
 * rearrange the array in increasing order in place (without using extra space). You do not
 * need to return anything; simply modify the input array.
 *
 * Link: #{https://www.geeksforgeeks.org/problems/binary-array-sorting-1587115620/1?sortBy=submissions&category[]=Arrays&page=1&difficulty[]=-1}
 */


package GFG.practice.Array;

public class BinaryArraySorting {

    public void binSort(int[] arr) {
        // code here
        int zeroCount = 0;
        int n = arr.length;

        for(int i=0; i<n; i++) {
            if(arr[i] == 0) {
                zeroCount++;
            }
        }

        int i=0;
        while(i < zeroCount) {
            arr[i] = 0;
            i++;
        }

        i=zeroCount;
        while(i < n) {
            arr[i] = 1;
            i++;
        }

    }

}
