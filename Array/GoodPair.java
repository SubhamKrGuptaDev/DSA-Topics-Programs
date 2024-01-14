/**
 *
 * Problem Description
 * Given an array A and an integer B. A pair(i, j) in the array is a good pair if i != j and (A[i] + A[j] == B). Check if any good pair exist or not.
 *
 *
 *
 * Problem Constraints
 * 1 <= A.size() <= 104
 *
 * 1 <= A[i] <= 109
 *
 * 1 <= B <= 109
 *
 *
 *
 * Input Format
 * First argument is an integer array A.
 *
 * Second argument is an integer B.
 *
 *
 *
 * Output Format
 * Return 1 if good pair exist otherwise return 0.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * A = [1,2,3,4]
 * B = 7
 * Input 2:
 *
 * A = [1,2,4]
 * B = 4
 * Input 3:
 *
 * A = [1,2,2]
 * B = 4
 *
 *
 * Example Output
 * Output 1:
 *
 * 1
 * Output 2:
 *
 * 0
 * Output 3:
 *
 * 1
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  (i,j) = (3,4)
 * Explanation 2:
 *
 * No pair has sum equal to 4.
 * Explanation 3:
 *
 *  (i,j) = (2,3)
 *
 *
 */


package Array;

import java.util.ArrayList;
import java.util.HashMap;

public class GoodPair {
    public int solve(ArrayList<Integer> A, int B) {
        return optimizeSolution(A,B);
    }

    // Optimized Solution TC: N
    public int optimizeSolution(ArrayList<Integer> A, int B) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n=A.size();
        // store in map
        for(int i=0; i<n; i++) {
            map.put(A.get(i), map.getOrDefault(A.get(i), 0) + 1);
        }
        // edge case -> if B/2 contains 2 times that also be a one pair
        if(map.containsKey(B/2)) {
            if(map.get(B/2) == 2) return B/2;
        }
        // B - A[i] = ans -> search that value contains ans ? if yes return 1
        for(int i=0; i<n; i++) {
            if(map.containsKey(B - A.get(i))) {

            }
        }
        return 0;
    }

    // Brute force TC: N^2
    public int findGoodPair(ArrayList<Integer> A, int B) {
        int n = A.size();
        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                if(A.get(i) + A.get(j) == B) return 1;
            }
        }

        return 0;
    }

    public static void main(String[] args) {

    }
}
