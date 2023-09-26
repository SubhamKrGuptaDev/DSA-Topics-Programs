/**
 *
 * Problem Description
 * Given an array A. Sort this array using Count Sort
 * Algorithm and return the sorted array.
 *
 *
 * Problem Constraints
 * 1 <= |A| <= 10^5
 * 1 <= A[i] <= 10^5
 *
 * * Example Input *
 * Input 1:
 * A = [1, 3, 1]
 * Input 2:
 * A = [4, 2, 1, 3]
 *
 *
 * * Example Output *
 * Output 1:
 * [1, 1, 3]
 * Output 2:
 * [1, 2, 3, 4]
 *
 *
 * Example Explanation
 * For Input 1:
 * The array in sorted order is [1, 1, 3].
 * For Input 2:
 * The array in sorted order is [1, 2, 3, 4].
 *
 *
 *
 */


package sorting;

import java.util.ArrayList;

public class Count_Sort {

    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        int n =A.size();
        int size = 1000 * 100; // Max Value is fix So Arrays size = max value
        int[] countArr = new int[size+1];
        for(int i=0; i<n; i++) {
            // value start from 1 to 10^5 [that's why i have used - 1]
            countArr[A.get(i) - 1]++;
        }
        ArrayList<Integer> result = new ArrayList<>();
        for(int i=0; i<size; i++) {
            while(countArr[i] > 0) {
                result.add(i+1);
                countArr[i]--;
            }
        }

        return result;
    }

    public static void main(String[] args) {

    }

}
