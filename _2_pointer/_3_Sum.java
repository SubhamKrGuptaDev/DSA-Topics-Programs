/**
 *
 * Problem Description
 * Given an array A of N integers, find three integers in A such that the sum is closest to a
 * given number B. Return the sum of those three integers.
 *
 * Assume that there will only be one solution.
 *
 *
 *
 * Problem Constraints
 * -10^8 <= B <= 10^8
 * 1 <= N <= 10^4
 * -10^8 <= A[i] <= 10^8
 *
 *
 * * Example Input *
 * Input 1:
 *
 * A = [-1, 2, 1, -4]
 * B = 1
 * Input 2:
 *
 *
 * A = [1, 2, 3]
 * B = 6
 *
 *
 * * Example Output *
 * Output 1:
 *
 * 2
 * Output 2:
 *
 * 6
 *
 *
 * * Example Explanation *
 * Explanation 1:
 *
 *  The sum that is closest to the target is 2. (-1 + 2 + 1 = 2)
 * Explanation 2:
 *
 *  Take all elements to get exactly 6.
 *
 *
 *
 *
 *
 */


package _2_pointer;

import java.util.ArrayList;
import java.util.Collections;

public class _3_Sum {

    public int threeSumClosest(ArrayList<Integer> A, int B) {
        int min = Integer.MAX_VALUE;
        int n = A.size();
        int ans = 0;

        int p1 = 0;
        int p2 = n-1;
        Collections.sort(A);
        for(int i=0; i<n; i++) {
            while(p1 < p2) {
                int sum = A.get(i) + A.get(p1) + A.get(p2);
                if(sum == B) return B;
                else if(sum < B) {
                    p1++;
                }
                else {
                    p2--;
                }

                int dif = Math.abs(sum - B);
                if(dif < min) {
                    min = dif;
                    ans = sum;
                }
            }
            p1 = i+1;
            p2 = n-1;
        }

        return ans;
    }

    private int bruteForceApproach(ArrayList<Integer> A, int B) {
        int n = A.size();
        int ans = 0;
        int min = Integer.MAX_VALUE;
        for(int i=0; i<n-2; i++) {
            for(int j=i+1; j<n; j++) {
                for(int k=j+1; k<n; k++) {
                    int sum = A.get(i) + A.get(j) + A.get(k);
                    if(sum == B) return B;
                    int dif = Math.abs(sum - B);
                    if(dif < min) {
                        min = dif;
                        ans = sum;
                    }
                }
            }
        }

        return ans;
    }

}
