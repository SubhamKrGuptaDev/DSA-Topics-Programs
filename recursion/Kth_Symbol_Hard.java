/**
 *
 * * Problem Description *
 * On the first row, we write a 0. Now in every subsequent row,
 * we look at the previous row and replace each occurrence of 0 with 01,
 * and each occurrence of 1 with 10.
 *
 * Given row number A and index B, return the Bth indexed symbol in row A.
 * (The values of B are 0-indexed.).
 *
 * * Problem Constraints *
 * 1 <= A <= 105
 *
 * 0 <= B <= min(2A - 1 - 1 , 1018)
 *
 *
 * * Example Input *
 * Input 1:
 *
 *  A = 3
 *  B = 0
 * Input 2:
 *
 *  A = 4
 *  B = 4
 *
 *
 * * Example Output *
 * Output 1:
 *
 *  0
 * Output 2:
 *
 *  1
 *
 *
 * * Example Explanation *
 * Explanation 1:
 *
 *  Row 1: 0
 *  Row 2: 01
 *  Row 3: 0110
 * * Explanation 2: *
 *
 *  Row 1: 0
 *  Row 2: 01
 *  Row 3: 0110
 *  Row 4: 01101001
 *
 *
 *  * Solution Approach *
 *  When
 * A = 1 -> 0
 * A = 2 ->01
 * A = 3 ->0110
 *
 * As we can see that there are two part in string (when A>=2)
 * first part is repeating of (A-1)th> step and second part is also compliment of (A-1)th step
 *
 * for A = 3 -> first part - 01 ( it is same as when A == 2) second part- 10
 * ( compliment of when A == 2)
 *
 * We know that on every expansion, the length of String is 2(A-1)
 *
 * so what we can do when B value is <= mid we can search the result in first part of
 * (A-1)th step solve(A-1, B)
 *
 * and when B > mid we can search the result in (A-1)th step but compliment of
 * that index to get the actual index in 1st part we have to do B - mid.
 *
 *
 * A = 3, B = 3
 *
 * * Example *
 * 
 *    0 1 2 3
 * 1| 0
 * 2| 0 1
 * 3| 0 1 1 |0|
 *
 * result -> 0
 *
 *
 *
 *
 */


package recursion;

public class Kth_Symbol_Hard {

    public int solve(int A, Long B) {
        if(A == 1) {    // 1 is a first row
            return 0;   // first value  always 0
        }
        /**
         * recursion B / 2 BCZ value increase always 2
         * if 0 -> 0 1
         * if 1 -> 1 0
         */
        int result = solve(A-1, B / 2L);
        if(B % 2L == 0L) {                          // B is the previous values
            return result;
        }
        /**
         * if result 1 then 1 - 1 = 0 or if result 0 then 1 - 0 = 1
         * we can use xor also
         */
        return 1 - result;
    }

    public static void main(String[] args) {

    }

}
