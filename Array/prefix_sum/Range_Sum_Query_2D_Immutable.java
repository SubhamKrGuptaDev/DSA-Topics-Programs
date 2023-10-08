/**
 *
 * Range Sum Query 2D - Immutable
 *
 * Given a 2D matrix, handle multiple queries of the following type:
 *
 * Calculate the sum of the elements of matrix inside the rectangle defined by its
 * upper left corner (row1, col1) and lower right corner (row2, col2).
 * Implement the NumMatrix class:
 *
 * NumMatrix(int[][] matrix) Initializes the object with the integer matrix.
 * int sumRegion(int row1, int col1, int row2, int col2) Returns the sum of the elements
 * of matrix inside the rectangle defined by its upper left corner (row1, col1) and lower
 * right corner (row2, col2).
 * You must design an algorithm where sumRegion works on O(1) time complexity.
 *
 *
 *
 * Constraints:
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 200
 * -104 <= matrix[i][j] <= 104
 * 0 <= row1 <= row2 < m
 * 0 <= col1 <= col2 < n
 * At most 104 calls will be made to sumRegion.
 *
 *
 *
 * Input
 * ["NumMatrix", "sumRegion", "sumRegion", "sumRegion"]
 * [[[[3, 0, 1, 4, 2], [5, 6, 3, 2, 1], [1, 2, 0, 1, 5],
 * [4, 1, 0, 1, 7], [1, 0, 3, 0, 5]]], [2, 1, 4, 3], [1, 1, 2, 2],
 * [1, 2, 2, 4]]
 * Output
 * [null, 8, 11, 12]
 *
 * Explanation
 * NumMatrix numMatrix = new NumMatrix([[3, 0, 1, 4, 2], [5, 6, 3, 2, 1],
 * [1, 2, 0, 1, 5], [4, 1, 0, 1, 7], [1, 0, 3, 0, 5]]);
 * numMatrix.sumRegion(2, 1, 4, 3); // return 8 (i.e sum of the red rectangle)
 * numMatrix.sumRegion(1, 1, 2, 2); // return 11 (i.e sum of the green rectangle)
 * numMatrix.sumRegion(1, 2, 2, 4); // return 12 (i.e sum of the blue rectangle)
 *
 *
 *
 *
 *
 */




package Array.prefix_sum;

import java.util.ArrayList;
import java.util.List;

public class Range_Sum_Query_2D_Immutable {

    int[][] matrix;
    int[][] prefixSum;

    // Solve with prefix Sum
    public void NumMatrix(int[][] matrix) {
        this.matrix = matrix;
        prefixSum = new int[matrix.length][matrix[0].length];
    }

    private void setPrefixSum() {
        int n = matrix.length;
        for(int i=0; i<n; i++) {
            prefixSum[i][0] = matrix[i][0];
            for(int j=1; j<matrix[i].length; j++) {
                System.out.print(prefixSum[i][j-1] + " ");
                prefixSum[i][j] = prefixSum[i][j-1] + matrix[i][j];
            }
            System.out.println();
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {


        int sum = 0;
        for(int row = row1; row <= row2; row++) {
            if(col1 == 0) {
                sum += prefixSum[row][col2];
            }
            else {
                sum += prefixSum[row][col2] - prefixSum[row][col1-1];
            }
        }

        return sum;
    }

    // Brute Force Approach

    public void NumMatrixBruteForce(int[][] matrix) {
        this.matrix = matrix;
    }

    public int sumRegionBruteForce(int row1, int col1, int row2, int col2) {
        int sum =0;
        for(int k =row1; k<=row2; k++) {
            for(int j =col1; j<=col2; j++) {
                sum += matrix[k][j];
            }
        }
        return sum;
    }

    // Brute Force Approach

    public List<Integer> bruteForceApproach(int[][] matrix, int[][] listOrQuery) {

        List<Integer> result = new ArrayList<>();

        int n = matrix.length;
        int m = matrix[0].length;

        for(int i=0; i<listOrQuery.length; i++) {
            int row1 = listOrQuery[i][0];
            int col1 = listOrQuery[i][1];
            int row2 = listOrQuery[i][2];
            int col2 = listOrQuery[i][3];
            int sum = 0;
            for(int k =row1; k<=row2; k++) {
                for(int j =col1; j<=col2; j++) {
                    sum += matrix[k][j];
                }
            }
            result.add(sum);
        }

        return result;
    }

    public static void main(String[] args) {

    }

}
