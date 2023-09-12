/**
 * * Problem Description *
 * Given an array of integers, every element appears thrice except for one, which occurs once.
 *
 * Find that element that does not appear thrice.
 *
 * NOTE: Your algorithm should have a linear runtime complexity.
 *
 * Could you implement it without using extra memory?
 *
 * * Problem Constraints *
 * 2 <= A <= 5*106
 *
 * 0 <= A <= INTMAX
 *
 *
 * * Example Input *
 * Input 1:
 *
 *  A = [1, 2, 4, 3, 3, 2, 2, 3, 1, 1]
 * Input 2:
 *
 *  A = [0, 0, 0, 1]
 *
 *
 * * Example Output*
 * Output 1:
 *
 *  4
 * Output 2:
 *
 *  1
 *
 *
 * * Example Explanation *
 *  Explanation 1:
 *
 *  4 occurs exactly once in Input 1.
 *  1 occurs exactly once in Input 2.
 *
 * * Hint *
 * Let us look at every bit position.
 *
 * Every number that occurs thrice will either contribute 3 ‘1’s or 3 ‘0’s to the position.
 *
 * The number that occurs once X will contribute exactly one 0 or 1 to the
 * position depending on whether it has 0 or 1 in that position.
 *
 * So:
 *
 * If X has 1 in that position, we will have (3x+1) number of 1s in that position.
 * If X has 0 in that position, we will have (3x+1) number of 0s in that position.
 *
 * * Approach1 *
 *     public int singleNumber(final List < Integer > A) {
 *         int[] bits = new int[32];
 *         // check frequency of each bit
 *         for (int num: A) {
 *             for (int i = 0; i < 32; i++) {
 *                 bits[i] += (1 & (num >> i));
 *                 bits[i] %= 3;
 *             }
 *         }
 *         int number = 0;
 *         for (int i = 31; i >= 0; i--) {
 *             number = number * 2 + bits[i];
 *         }
 *         return number;
 *     }
 *
 * * Approach2 *
 *     public int singleNumber(final List < Integer > A) {
 *         int ones = 0, twos = 0, threes = 0;
 *         for (int num : A) {
 *             // twos is a bitmask to represent the ith bit had appeared twice
 *             twos |= ones & num;
 *             // ones is a bitmask to represent the ith bit had appeared once
 *             ones ^= num;
 *             // threes is a bitmask to represent the ith bit had appeared three times
 *             threes = ones & twos;
 *             ones &= ~threes;
 *             twos &= ~threes;
 *         }
 *         return ones;
 *     }
 *
 *
 *
 *
 *
 *
 */



package bit_manupulation;

import java.util.List;

public class Single_Number_II_XOR {

    public int singleNumber(final List<Integer> A) {
        int ans = 0;
        for(int j=0; j<32; j++) {
            int count = 0;
            for(int i=0; i<A.size(); i++) {
                int temp = A.get(i);
                if((temp & (1 << j)) != 0) {
                    count++;
                }
            }
            if(count % 3 == 1) {
                ans |= (1 << j);
            }
        }

        return ans;
    }

}
