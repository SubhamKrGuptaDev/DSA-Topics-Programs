/**
 *
 * Problem Description
 * Given an integer array A of size N denoting collection of numbers ,
 * return all possible permutations.
 *
 * NOTE:
 *
 * No two entries in the permutation sequence should be the same.
 * For the purpose of this problem, assume that all the numbers in the collection are unique.
 * Return the answer in any order
 * WARNING: DO NOT USE LIBRARY FUNCTION FOR GENERATING PERMUTATIONS.
 * Example : next_permutations in C++ / itertools.permutations in python.
 * If you do, we will disqualify your submission retroactively and give you penalty points.
 *
 *
 * Problem Constraints
 * 1 <= N <= 9
 *
 *
 *
 * Input Format
 * Only argument is an integer array A of size N.
 *
 *
 *
 * Output Format
 * Return a 2-D array denoting all possible permutation of the array.
 *
 *
 *
 * Example Input
 * A = [1, 2, 3]
 *
 *
 * Example Output
 * [ [1, 2, 3]
 *   [1, 3, 2]
 *   [2, 1, 3]
 *   [2, 3, 1]
 *   [3, 1, 2]
 *   [3, 2, 1] ]
 *
 *
 * Example Explanation
 * All the possible permutation of array [1, 2, 3].
 *
 *
 *
 */


package BackTracking;

import java.util.ArrayList;

public class Permutations {

    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
        int n = A.size();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        boolean[] visited = new boolean[A.size()];

        permutation(A, 0, ans, visited, new ArrayList<>(A));

        return ans;
    }

    // Recursive Solution | BackTracking
    private void permutation(ArrayList<Integer> arr, int index, ArrayList<ArrayList<Integer>> ans,
                     boolean[] visited, ArrayList<Integer> store) {

        if(index == arr.size()) {
            ans.add(new ArrayList<>(store));
            return;
        }

        for(int i=0; i<arr.size(); i++) {
            if(visited[i] == false) {
                visited[i] = true;
                store.set(index, arr.get(i));
                permutation(arr, index+1, ans, visited, store);
                visited[i] = false;
            }
        }

    }

    public static void main(String[] args) {

    }

}
