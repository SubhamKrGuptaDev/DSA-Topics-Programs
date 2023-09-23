/**
 *
 * Problem Description
 * Given two sorted integer arrays A and B, merge B and A as one sorted array
 * and return it as an output.
 *
 * Note: A linear time complexity is expected, and you should avoid use of any
 * library function.
 *
 *
 * Problem Constraints
 * -2×10^9 <= A[i], B[i] <= 2×10^9
 * 1 <= |A|, |B| <= 5×10^4
 *
 *
 * * Example Input *
 * Input 1:
 *
 * A = [4, 7, 9]
 * B = [2, 11, 19]
 * Input 2:
 *
 * A = [1]
 * B = [2]
 *
 *
 * * Example Output *
 * Output 1:
 *
 * [2, 4, 7, 9, 11, 19]
 * Output 2:
 *
 * [1, 2]
 *
 *
 *
 * * Example Explanation *
 * Explanation 1:
 *
 * Merging A and B produces the output as described above.
 * Explanation 2:
 *
 *  Merging A and B produces the output as described above.
 *
 *
 * * Solution *
 *
 *     public ArrayList < Integer > solve(final List < Integer > A, final List < Integer > B) {
 *         int m = A.size(), n = B.size();
 *         ArrayList < Integer > res = new ArrayList < Integer > ();
 *         if (A == null && B == null)
 *             return null;
 *         if (A == null) {
 *             for (int i = 0; i < n; i++)
 *                 res.add(B.get(i));
 *             return res;
 *         }
 *         if (B == null) {
 *             for (int i = 0; i < m; i++)
 *                 res.add(A.get(i));
 *             return res;
 *         }
 *         int i, j;
 *         int k = 0;
 *         // i and j points to the elements of A and B respectively
 *         for (i = 0, j = 0; k < m + n; k++) {
 *             if (i >= m)
 *                 res.add(B.get(j++));
 *             else if (j >= n)
 *                 res.add(A.get(i++));
 *             else if (A.get(i) <= B.get(j))
 *                 res.add(A.get(i++));
 *             else
 *                 res.add(B.get(j++));
 *         }
 *         return res;
 *     }
 *
 *
 *
 *
 */


package sorting;

import java.util.ArrayList;
import java.util.List;

public class Merge_Two_Sorted_Arrays {

    public static ArrayList<Integer> solve1(final List<Integer> A, final List<Integer> B) {
        int n = A.size();
        int m = B.size();
        ArrayList<Integer> result = new ArrayList<>();
        int i=0;
        int j=0;
        for(int k=0; k<n+m; k++) {
            if(i == n) {
                result.add(B.get(j));
                j++;
            }
            else if(j == m) {
                result.add(A.get(i));
                i++;
            }
            else if(A.get(i) <= B.get(j)) {
                result.add(A.get(i));
                i++;
            }
            else {
                result.add(B.get(j));
                j++;
            }
        }

        return result;
    }

    public static ArrayList<Integer> solve2(final List<Integer> A, final List<Integer> B) {
        int i=0;
        int j=0;
        int n = A.size();
        int m = B.size();

        ArrayList<Integer> result = new ArrayList<>();

        while(i < n && j < m) {
            if(A.get(i) <= B.get(j)) {
                result.add(A.get(i));
                i++;
            }
            else {
                result.add(B.get(j));
                j++;
            }
        }
        while(i < n) {
            result.add(A.get(i));
            i++;
        }
        while(j < m) {
            result.add(B.get(j));
            j++;
        }

        return result;
    }

    public static void main(String[] args) {

    }

}
