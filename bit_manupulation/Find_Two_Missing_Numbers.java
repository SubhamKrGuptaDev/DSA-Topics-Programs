/**
 *
 * * Problem Description *
 * Given an array A of length N where all the elements are distinct and are in the range [1, N+2].
 *
 * Two numbers from the range [1, N+2] are missing from the array A. Find the two missing numbers.
 *
 * * Problem Constraints *
 * 1 <= N <= 105
 *
 * 1 <= A[i] <= N+2
 *
 * The elements of array A are distinct
 *
 *
 * * Example Input *
 * Input 1:
 * A = [3, 2, 4]
 * Input 2:
 * A = [5, 1, 3, 6]
 *
 *
 * * Example Output *
 * Output 1:
 * [1, 5]
 * Output 2:
 * [2, 4]
 *
 *
 * * Example Explanation *
 * For Input 1:
 * The missing numbers are 1 and 5.
 * For Input 2:
 * The missing numbers are 2 and 4.
 *
 *
 * * Hint *
 * How about taking xor of all numbers present in array as well as all numbers from 1 to N+2?
 * This will give you a resultant number which is equal to XOR of two missing numbers.
 * Now, think on how to extract those two missing numbers from this resultant number.
 *
 *
 *
 *
 *
 */



package bit_manupulation;

import java.util.ArrayList;

public class Find_Two_Missing_Numbers {
    // XOR Solution TC : O(N) | SC : O(1)
    public int[] solve(int[] A) {
        int n = A.length;
        int[] ans = new int[2];
        int XOR = 0;
        for(int i = 0; i < n; i++){
            XOR ^= A[i];
        }
        for(int i = 1; i <= n + 2; i++){
            XOR ^= i;
        }
        // XOR has the bitwise XOR of two missing elements. Any set bit
        // in it must be set in one and unset in the other missing number

        // We get the rightmost set bit
        int rightmost_set_bit = XOR & ~(XOR - 1);

        // Divide elements in two sets by comparing rightmost
        // set bit of XOR with bit at same position in each element.
        int x = 0, y = 0;
        for (int i = 0; i < n; i++){
            if((A[i] & rightmost_set_bit) > 0)
                x = x ^ A[i];
            else
                y = y ^ A[i];
        }
        for(int i = 1; i <= n + 2; i++){
            if ((i & rightmost_set_bit) > 0)
                x = x ^ i;
            else
                y = y ^ i;
        }

        ans[0] = Math.min(x, y);
        ans[1] = Math.max(x, y);
        return ans;
    }

    // Simple Solution with array TC : O(N) | SC : O(N)
    public ArrayList<Integer> solveWithOutXor(ArrayList<Integer> A) {
        int n = A.size();
        int[] storage = new int[n+2];
        for(int i=0; i<n; i++) {
            storage[A.get(i) - 1] = A.get(i);
        }
        ArrayList<Integer> result = new ArrayList<>();
        for(int i=0; i<storage.length; i++) {
            if(storage[i] == 0) {
                result.add(i+1);
            }
        }

        return result;
    }

    public static void main(String[] args) {

    }

}
