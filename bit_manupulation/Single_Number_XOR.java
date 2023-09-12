/**
 * * Problem Description *
 * Given an array of integers A, every element appears twice except for one.
 * Find that integer that occurs once.
 *
 * NOTE: Your algorithm should have a linear runtime complexity.
 * Could you implement it without using extra memory?
 *
 *
 * * Problem Constraints *
 * 1 <= |A| <= 2000000
 *
 * 0 <= A[i] <= INTMAX
 *
 *
 * * Example Input *
 * Input 1:
 *
 *  A = [1, 2, 2, 3, 1]
 * Input 2:
 *
 *  A = [1, 2, 2]
 *
 *
 * * Example Output *
 * Output 1:
 *
 *  3
 * Output 2:
 *
 *  1
 *
 *
 * * Example Explanation *
 * Explanation 1:
 *
 * 3 occurs once.
 * Explanation 2:
 *
 * 1 occurs once.
 *
 * * Approachs *
 * 1. XOR
 * 2. HashMap
 * 3. Nested Loop
 *
 */


package bit_manupulation;

import java.util.Arrays;
import java.util.List;

public class Single_Number_XOR {

    public static int singleNumber(final List<Integer> A) {
        int xor = A.get(0);
        for(int i=1; i<A.size(); i++) {
            xor ^= A.get(i);
        }

        return xor;
    }

    public static void main(String[] args) {
        int result = singleNumber(Arrays.asList(2, 2, 4, 1, 7, 4, 7));
        if(result != 1) {
            throw new RuntimeException("Test Case Not Match");
        }
        System.out.printf("Result : " + result);
    }

}
