/**
 *
 * Problem Description
 * The N-queens puzzle is the problem of placing N queens on an N×N chessboard such that no two queens attack each other.
 *
 *
 *
 * Given an integer A denoting the value of N, return all distinct solutions to the N-queens puzzle.
 *
 * Each solution contains a distinct board configuration of the N-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.
 * The final list should be generated in such a way that the indices of the queens in each list should be in reverse lexicographical order.
 *
 *
 *
 * Problem Constraints
 * 1 <= A <= 10
 *
 *
 *
 * Input Format
 * First argument is an integer A denoting the size of chessboard
 *
 *
 *
 * Output Format
 * Return an array consisting of all distinct solutions in which each element is a 2d char array representing a unique solution.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * A = 4
 * Input 2:
 *
 * A = 1
 *
 *
 * Example Output
 * Output 1:
 *
 * [
 *  [".Q..",  // Solution 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 *
 *  ["..Q.",  // Solution 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 * Output 1:
 *
 * [
 *  [Q]
 * ]
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 * There exist only two distinct solutions to the 4-queens puzzle:
 * Explanation 1:
 *
 * There exist only one distinct solutions to the 1-queens puzzle:
 *
 *
 */

package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;

public class NQueens {

    // Other Approach
    ArrayList<ArrayList<String>> res;
    ArrayList<Integer> mRow;
    ArrayList<Integer> mCol;
    char board[][];
    int N;

    public ArrayList<ArrayList<String>> solveNQueensHashing(int A) {
        res = new ArrayList<>();
        N = A;
        board = new char[N][N];
        mRow = new ArrayList<>();
        mCol = new ArrayList<>();
        for (int i = 0; i < N; i++)
            Arrays.fill(board[i], '.');
        backtrack(0);
        return res;
    }

    public void backtrack(int row) {
        if (row == N) {
            addState();
            return;
        }
        for (int i = 0; i < N; i++) {
            board[row][i] = 'Q';
            mRow.add(row);
            mCol.add(i);
            if (validState()) {
                backtrack(row + 1);
            }
            mRow.remove(mRow.size() - 1);
            mCol.remove(mCol.size() - 1);
            board[row][i] = '.';
        }
    }

    private boolean validState() {
        // check if the current arrangement is valid
        int row, col;
        int nextRow, nextCol;
        for (int i = 0; i < mRow.size(); i++) {
            row = mRow.get(i);
            col = mCol.get(i);
            for (int j = i + 1; j < mRow.size(); j++) {
                nextRow = mRow.get(j);
                nextCol = mCol.get(j);
                if (row == nextRow || col == nextCol)
                    return false;
                if (Math.abs(row - nextRow) == Math.abs(col - nextCol))
                    return false;
            }
        }
        return true;
    }

    private void addState() {
        ArrayList<String> state = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            state.add(new String(board[i]));
        }
        res.add(state);
    }

//    -------------------------------

    // Without using hashmap approach
    public ArrayList<ArrayList<String>> solveNQueens(int A) {
        ArrayList<ArrayList<String>> str = new ArrayList<>();
        ArrayList<StringBuilder> sb = new ArrayList<>();
        for(int i=0; i<A; i++) {
            StringBuilder temp = new StringBuilder();
            for(int j=0; j<A; j++) {
                temp.append('.');
            }
            sb.add(temp);
        }
        findNQueues(str, 0, A, sb);
        return str;
    }
    private void findNQueues(ArrayList<ArrayList<String>> str, int row, int n, ArrayList<StringBuilder> s) {
        if(row == n) {
            ArrayList<String> tempString = new ArrayList<>();
            for(StringBuilder sb : s) tempString.add(sb.toString());
            str.add(tempString);
            return;
        }
        for(int col=0; col<n; col++) {
            if(isSaveQueue(s, row, col, n)) {
                s.get(row).setCharAt(col,'Q');
                findNQueues(str, row+1, n, s);
                s.get(row).setCharAt(col,'.');
            }
        }
    }
    private boolean isSaveQueue(ArrayList<StringBuilder> str, int row, int col, int n) {
        // Top to bottom check
        for(int i=0; i<n; i++) {
            if(i != row) {
                if(str.get(i).charAt(col) == 'Q') {
                    return false;
                }
            }
        }
        // left to right check
        for(int j=0; j<n; j++) {
            if(j != col) {
                if(str.get(row).charAt(j) == 'Q') {
                    return false;
                }
            }
        }

        int i=row, j=col;
        while(i < n && j < n) {
            if(i != row && j != col && str.get(i).charAt(j) == 'Q') {
                return false;
            }
            i++; j++;
        }
        i=row; j=col;
        while(i >= 0 && j >= 0) {
            if(i != row && j != col && str.get(i).charAt(j) == 'Q') {
                return false;
            }
            i--; j--;
        }

        i=row; j=col;
        while(i < n && j >= 0) {
            if(i != row && j != col && str.get(i).charAt(j) == 'Q') {
                return false;
            }
            i++; j--;
        }
        i=row; j=col;
        while(i >= 0 && j < n) {
            if(i != row && j != col && str.get(i).charAt(j) == 'Q') {
                return false;
            }
            i--; j++;
        }

        return true;
    }

}
