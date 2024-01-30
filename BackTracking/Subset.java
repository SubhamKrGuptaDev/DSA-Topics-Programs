/**
 *
 * Problem Description
 * Given a set of distinct integers A, return all possible subsets.
 *
 * NOTE:
 *
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 * Also, the subsets should be sorted in ascending ( lexicographic ) order.
 * The initial list is not necessarily sorted.
 *
 *
 * Problem Constraints
 * 1 <= |A| <= 16
 * INTMIN <= A[i] <= INTMAX
 *
 *
 * Input Format
 * First and only argument of input contains a single integer array A.
 *
 *
 *
 * Output Format
 * Return a vector of vectors denoting the answer.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * A = [1]
 * Input 2:
 *
 * A = [1, 2, 3]
 *
 *
 * Example Output
 * Output 1:
 *
 * [
 *     []
 *     [1]
 * ]
 * Output 2:
 *
 * [
 *  []
 *  [1]
 *  [1, 2]
 *  [1, 2, 3]
 *  [1, 3]
 *  [2]
 *  [2, 3]
 *  [3]
 * ]
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  You can see that these are all possible subsets.
 * Explanation 2:
 *
 * You can see that these are all possible subsets.
 *
 *
 *
 */

package BackTracking;

import java.util.ArrayList;
import java.util.Collections;

public class Subset {

    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
        Collections.sort(A);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        createAllSubSet(result, A, 0, new ArrayList<>());
        return result;
    }

    private void createAllSubSet(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> A, int i, ArrayList<Integer> temp) {
        if(A.size() <= i) {
            return;
        }

        // take value
        temp.add(A.get(i));
        result.add(new ArrayList<>(temp));
        createAllSubSet(result, A, i+1, temp);

        // ignore value
        temp.remove(temp.size()-1);
        createAllSubSet(result, A, i+1, temp);
    }

}
