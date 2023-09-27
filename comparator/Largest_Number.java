/**
 *
 * Problem Description
 * Given an array A of non-negative integers, arrange them such that they form the
 * largest number.
 *
 * Note: The result may be very large, so you need to return a string instead of an
 * integer.
 *
 * Problem Constraints
 * 1 <= len(A) <= 100000
 * 0 <= A[i] <= 2*10^9
 *
 *
 * * Example Input *
 * Input 1:
 *
 *  A = [3, 30, 34, 5, 9]
 * Input 2:
 *
 *  A = [2, 3, 9, 0]
 *
 *
 * * Example Output *
 * Output 1:
 *
 *  "9534330"
 * Output 2:
 *
 *  "9320"
 *
 *
 * * Example Explanation *
 * Explanation 1:
 *
 * Reorder the numbers to [9, 5, 34, 3, 30] to form the largest number.
 * Explanation 2:
 *
 * Reorder the numbers to [9, 3, 2, 0] to form the largest number 9320.
 *
 *
 *
 *
 */


package comparator;

import java.util.Collections;
import java.util.List;

public class Largest_Number {

    public String largestNumber(final List<Integer> A) {
        Collections.sort(A, (n1, n2) -> {
            String v1 = String.valueOf(n1);
            String v2 = String.valueOf(n2);
            return (v2+v1).compareTo(v1+v2);
        });
        StringBuilder result = new StringBuilder();
        for(int i=0; i<A.size(); i++) {
            if(A.get(i).equals(0)) {
                continue;
            }
            result.append(A.get(i));
        }
        if(result.length() == 0) {
            return "0";
        }
        return result.toString();
    }

    public static void main(String[] args) {

    }

}
