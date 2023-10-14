/**
 *
 * Problem Description
 * You are given an array of N integers, A1, A2 ,..., AN and an integer B.
 * Return the of count of distinct numbers in all windows of size B.
 *
 * Formally, return an array of size N-B+1 where i'th element in this array contains
 * number of distinct elements in sequence Ai, Ai+1 ,..., Ai+B-1.
 *
 * NOTE: if B > N, return an empty array.
 *
 *
 *
 * Problem Constraints
 * 1 <= N <= 10^6
 *
 * 1 <= A[i] <= 10^9
 *
 *
 *
 * * Example Input *
 * Input 1:
 *
 *  A = [1, 2, 1, 3, 4, 3]
 *  B = 3
 * Input 2:
 *
 *  A = [1, 1, 2, 2]
 *  B = 1
 *
 *
 * * Example Output *
 * Output 1:
 *
 *  [2, 3, 3, 2]
 * Output 2:
 *
 *  [1, 1, 1, 1]
 *
 *
 * * Example Explanation *
 * Explanation 1:
 *
 *  A=[1, 2, 1, 3, 4, 3] and B = 3
 *  All windows of size B are
 *  [1, 2, 1]
 *  [2, 1, 3]
 *  [1, 3, 4]
 *  [3, 4, 3]
 *  So, we return an array [2, 3, 3, 2].
 * Explanation 2:
 *
 *  Window size is 1, so the output array is [1, 1, 1, 1].
 *
 *
 *
 */


package HashMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Distinct_Numbers_in_Window {

    public static ArrayList<Integer> dNums(List<Integer> A, int B) {
        int n = A.size();
        ArrayList<Integer> result = new ArrayList<>();
        if(B > n) return result;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<B; i++) {
            map.put(A.get(i), map.getOrDefault(A.get(i), 0) + 1);
        }
        // print
        System.out.println(result);
        result.add(map.size());
        for(int i=B; i<n; i++) {
            // prev last window value check
            if(map.get(A.get(i - B)) != 0) {
                map.put(A.get(i-B), map.get(A.get(i-B)) - 1);
                if(map.get(A.get(i - B)) == 0)
                    map.remove(A.get(i-B));
            }
            map.put(A.get(i), map.getOrDefault(A.get(i), 0) + 1);
            result.add(map.size());
            // print
            System.out.println(result);
        }

        return result;
    }


    public static void main(String[] args) {
        ArrayList<Integer> result = dNums(Arrays.asList(1, 2, 1, 3, 4, 3), 3);
        System.out.println(result);
    }

}
