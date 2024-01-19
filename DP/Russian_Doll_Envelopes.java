/**
 *
 * Problem Description
 * Given a matrix of integers A of size N x 2 describing dimensions of N envelopes, where A[i][0] denotes the height of the ith envelope and A[i][1] denotes the width of the ith envelope.
 *
 * One envelope can fit into another if and only if both the width and height of one envelope is greater than the width and height of the other envelope.
 *
 * Find the maximum number of envelopes you can put one inside other.
 *
 *
 *
 * Problem Constraints
 * 1 <= N <= 1000
 * 1 <= A[i][0], A[i][1] <= 109
 *
 *
 *
 * Input Format
 * The only argument given is the integer matrix A.
 *
 *
 *
 * Output Format
 * Return an integer denoting the maximum number of envelopes you can put one inside other.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [
 *          [5, 4]
 *          [6, 4]
 *          [6, 7]
 *          [2, 3]
 *      ]
 * Input 2:
 *
 *  A = [     '
 *          [8, 9]
 *          [8, 18]
 *      ]
 *
 *
 * Example Output
 * Output 1:
 *
 *  3
 * Output 2:
 *
 *  1
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  Step 1: put [2, 3] inside [5, 4]
 *  Step 2: put [5, 4] inside [6, 7]
 *  3 envelopes can be put one inside other.
 * Explanation 2:
 *
 *  No envelopes can be put inside any other so answer is 1.
 *
 *
 *
 */


package DP;

import java.util.ArrayList;
import java.util.Collections;

public class Russian_Doll_Envelopes {

    class Pair {
        int h, w;
        public Pair(int h, int w) {
            this.h = h;
            this.w = w;
        }
    }

    // DP Solution | TC: O(N^2)
    public int solve(ArrayList<ArrayList<Integer>> A) {
        ArrayList<Pair> list = generatePair(A);
        // Sorting testing
        // for(Pair p : list) {
        //     System.out.println(p.h + " " + p.w);
        // }
        int ans = 0;
        int n = list.size();
        int[] dp = new int[n];
        for(int i=0; i<n; i++) {
            int max = 0;
            int prevH = list.get(i).h;
            int prevW = list.get(i).w;
            for(int j=0; j<i; j++) {
                if(prevH > list.get(j).h && prevW > list.get(j).w) {
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = max + 1;
            ans = Math.max(ans, dp[i]);
        }

        return ans;
    }

    private ArrayList<Pair> generatePair(ArrayList<ArrayList<Integer>> list) {
        ArrayList<Pair> pairs = new ArrayList<>();

        for(ArrayList<Integer> temp : list) {
            pairs.add(new Pair(temp.get(0), temp.get(1)));
        }

        Collections.sort(pairs, (o1, o2) -> o1.h - o2.h);

        return pairs;
    }

    public static void main(String[] args) {

    }

}
