/**
 *
 * Problem Description
 * Given an array A of N integers. Sort the array in increasing order of the
 * value at the tens place digit of every number.
 *
 * If a number has no tens digit, we can assume value to be 0.
 * If 2 numbers have same tens digit, in that case number with max value will come first
 * Solution should be based on comparator.
 *
 *
 * Problem Constraints
 * 1 <= N <= 105
 *
 * 1 <= A[i] <= 10^9
 *
 *
 * * Example Input *
 * Input 1:
 * A = [15, 11, 7, 19]
 * Input 2:
 * A = [2, 24, 22, 19]
 *
 *
 * * Example Output *
 * Output 1:
 * [7, 19, 15, 11]
 * Output 2:
 * [2, 19, 24, 22]
 *
 *
 * Example Explanation
 * For Input 1:
 * The sorted order is [7, 19, 15, 11]. The tens digit of 7 is 0,
 * and that of 19, 15 and 11 is 1.
 * For Input 2:
 * The sorted order is [2, 19, 24, 22]. The tens digit of 2 is 0,
 * that of 19 is 1 and that of 22 and 24 is 2.
 *
 *
 *
 *
 *
 *
 */


package comparator;

import java.util.ArrayList;
import java.util.Collections;

public class Tens_Digit_Sorting {

    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        Collections.sort(A, (num1, num2) -> {
            /**
             * How you get 10's digit?
             * 123 % 100 = 23
             * 23 / 10 = 2
             * Now You Get 10's digit number
             */
            Integer tensValue1 = (num1 % 100) / 10;
            Integer tensValue2 = (num2 % 100) / 10 ;
            if(tensValue1.equals(tensValue2)) {
                return num2 - num1;
            }
            return tensValue1 - tensValue2;
        });
        return A;
    }

    public static void main(String[] args) {

    }

}
