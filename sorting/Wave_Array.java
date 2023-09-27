/**
 *
 * Problem Description
 * Given an array of integers A, sort the array into a wave-like array and return it.
 * In other words, arrange the elements into a sequence such that
 *
 * a1 >= a2 <= a3 >= a4 <= a5.....
 * NOTE: If multiple answers are possible, return the lexicographically smallest one.
 *
 *
 * Problem Constraints
 * 1 <= len(A) <= 10^6
 * 1 <= A[i] <= 10^6
 *
 *
 * Example Input
 * Input 1:
 *
 * A = [1, 2, 3, 4]
 * Input 2:
 *
 * A = [1, 2]
 *
 *
 * * Example Output *
 * Output 1:
 *
 * [2, 1, 4, 3]
 * Output 2:
 *
 * [2, 1]
 *
 *
 * * Example Explanation *
 * Explanation 1:
 *
 * One possible answer : [2, 1, 4, 3]
 * Another possible answer : [4, 1, 3, 2]
 * First answer is lexicographically smallest. So, return [2, 1, 4, 3].
 * Explanation 1:
 *
 * Only possible answer is [2, 1].
 *
 *
 * * Hint *
 * Would it help if the array is sorted in ascending order?
 *
 * array = {5, 1, 3, 4, 2}
 *
 * Sort the above array.
 *
 * array = {1, 2, 3, 4, 5}
 *
 * Now swap adjacent elements in pairs.
 *
 * swap(1, 2)
 * swap(3, 4)
 *
 * Now, our array = {2, 1, 4, 3, 5}
 *
 * And value! the array is in the wave-form.
 *
 *
 *
 *
 *
 *
 */



package sorting;

import java.util.ArrayList;
import java.util.Collections;

public class Wave_Array {

    // Sort using Building Function then done that task
    public ArrayList<Integer> wave(ArrayList<Integer> A) {
        Collections.sort(A);
        int n = A.size();
        for(int i=0; i<n-1; i+=2) {
            swap(A, i, i+1);
        }
        return A;
    }

    // Count Sort Solution [Count Sort is possible because max array size = max contains value]
    private ArrayList<Integer> countSortAlgo(ArrayList<Integer> A) {
        if(A.size() == 1) {
            return A;
        }
        ArrayList<Integer> arr = countSort(A);
        int n = arr.size();
        for(int i=0; i<n-1; i+=2) {
            swap(arr, i, i+1);
        }
        return arr;
    }
    private ArrayList<Integer> countSort(ArrayList<Integer> A) {
        int size = 1000 * 1000 + 1;
        int n = A.size();
        int[] count = new int[size];
        for(int i=0; i<n; i++) {
            count[A.get(i)]++;
        }
        ArrayList<Integer> result = new ArrayList<>();
        for(int i=0; i<size; i++) {
            while(count[i] > 0) {
                result.add(i);
                count[i]--;
            }
        }
        return result;
    }
    private void swap(ArrayList<Integer> A, int e1, int e2) {
        int temp = A.get(e1);
        A.set(e1, A.get(e2));
        A.set(e2, temp);
    }

    public static void main(String[] args) {

    }

}
