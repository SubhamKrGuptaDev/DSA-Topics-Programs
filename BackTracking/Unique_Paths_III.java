/**
 *
 * Problem Description
 * Given a matrix of integers A of size N x M . There are 4 types of squares in it:
 *
 * 1. 1 represents the starting square.  There is exactly one starting square.
 * 2. 2 represents the ending square.  There is exactly one ending square.
 * 3. 0 represents empty squares we can walk over.
 * 4. -1 represents obstacles that we cannot walk over.
 * Find and return the number of 4-directional walks from the starting square to the ending square, that walk over every non-obstacle square exactly once.
 *
 * Note: Rows are numbered from top to bottom and columns are numbered from left to right.
 *
 *
 *
 * Problem Constraints
 * 2 <= N * M <= 20
 * -1 <= A[i] <= 2
 *
 *
 *
 * Input Format
 * The first argument given is the integer matrix A.
 *
 *
 *
 * Output Format
 * Return the number of 4-directional walks from the starting square to the ending square, that walk over every non-obstacle square exactly once.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * A = [   [1, 0, 0, 0]
 *         [0, 0, 0, 0]
 *         [0, 0, 2, -1]   ]
 * Input 2:
 *
 * A = [   [0, 1]
 *         [2, 0]    ]
 *
 *
 * Example Output
 * Output 1:
 *
 * 2
 * Output 2:
 *
 * 0
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 * We have the following two paths:
 * 1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2)
 * 2. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2)
 * Explanation 1:
 *
 * There are no such paths.
 *
 *
 *
 */

package BackTracking;

import java.util.ArrayList;

public class Unique_Paths_III {

    public int solve(ArrayList<ArrayList<Integer>> A) {
        int zero = 0;
        int sr = 0;
        int sc = 0;

        for(int i=0; i<A.size(); i++) {
            for(int j=0; j<A.get(i).size(); j++) {
                if(A.get(i).get(j) == 0) zero++;
                else if(A.get(i).get(j) == 1) {
                    sr = i;
                    sc = j;
                }
            }
        }

        return find(A, sr, sc, zero);
    }

    private int find(ArrayList<ArrayList<Integer>> matrix, int i, int j, int zero) {

        if(i < 0 || i >= matrix.size() || j < 0 || j >= matrix.get(i).size() || matrix.get(i).get(j) == -1) {
            return 0;
        }

        if(matrix.get(i).get(j) == 2) {
            return zero == -1 ? 1 : 0;
        }

        matrix.get(i).set(j, -1);
        zero--;

        int total = find(matrix, i+1, j, zero) +
                find(matrix, i, j+1, zero) +
                find(matrix, i-1, j, zero) +
                find(matrix, i, j-1, zero);
        matrix.get(i).set(j, 0);
        return total;
    }

}
