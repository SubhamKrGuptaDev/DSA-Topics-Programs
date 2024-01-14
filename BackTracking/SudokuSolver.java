/**
 *
 * Problem Description
 * Write a program to solve a Sudoku puzzle by filling the empty cells. Empty cells are indicated by the character '.' You may assume that there will be only one unique solution.
 *
 *
 *
 * A sudoku puzzle,
 *
 *
 *
 * and its solution numbers marked in red.
 *
 *
 *
 * Problem Constraints
 * N = 9
 *
 *
 * Input Format
 * First argument is an array of array of characters representing the Sudoku puzzle.
 *
 *
 * Output Format
 * Modify the given input to the required answer.
 *
 *
 * Example Input
 * Input 1:
 *
 * A = [[53..7....], [6..195...], [.98....6.], [8...6...3], [4..8.3..1], [7...2...6], [.6....28.], [...419..5], [....8..79]]
 *
 *
 * Example Output
 * Output 1:
 *
 * [[534678912], [672195348], [198342567], [859761423], [426853791], [713924856], [961537284], [287419635], [345286179]]
 *
 *
 */

package BackTracking;

import java.util.ArrayList;

public class SudokuSolver {

    public void solveSudoku(ArrayList<ArrayList<Character>> a) {
        int n = a.size();

        // Find SquareRoot of N
        int squareRoot = 0;
        for(int i=1; i*i<=n; i++) {
            squareRoot = i;
        }

        // Solve Sudoko
        sudokuSolver(a, 0, 0, n, squareRoot);

    }

    private boolean sudokuSolver(ArrayList<ArrayList<Character>> matrix, int i, int j, int n, int squareRoot) {

        if(j == n) {
            i++;
            j = 0;
        }

        if(i == n) return true;

        if(!matrix.get(i).get(j).equals('.')) {
            if(sudokuSolver(matrix, i, j+1, n, squareRoot))
                return true;
        }
        else {

            for(int number = 1; number <= n; number++) {

                // Integer to Character
                char ch = (char)(number + '0');

                if(isValid(matrix, i, j, ch, n, squareRoot)) {

                    // Set Value
                    matrix.get(i).set(j, ch);

                    // Go to Next Column
                    if(sudokuSolver(matrix, i, j+1, n, squareRoot)) {
                        return true;
                    }

                    // If wrong step backtrack and reset with '.'
                    matrix.get(i).set(j, '.');
                }

            }

        }

        return false;
    }

    private boolean isValid(ArrayList<ArrayList<Character>> matrix, int i, int j, char number, int n, int squareRoot) {

        // Row Check
        for(int row=0; row<n; row++) {
            if(number == matrix.get(row).get(j)) {
                return false;
            }
        }

        // Column Check
        for(int col = 0; col < n; col++) {
            if(number == matrix.get(i).get(col)) {
                return false;
            }
        }

        // Grid Check
        int rowGrid = i - (i % squareRoot);
        int colGrid = j - (j % squareRoot);

        for(int row = rowGrid; row < (rowGrid + squareRoot); row++) {
            for(int col = colGrid; col < (colGrid + squareRoot); col++) {
                if(matrix.get(row).get(col) == number) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {

    }

}
