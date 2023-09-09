
/**
 *
 * * Problem Description *
 * Given an integer A, find and return the total number of digit 1
 * appearing in all non-negative integers less than or equal to A.
 *
 *
 * * Problem Constraints *
 * 0 <= A <= 109
 *
 *
 * * Example Input *
 * Input 1:
 *  A = 10
 *
 * Input 2:
 *  A = 11
 *
 *
 * * Example Output *
 * Output 1:
 *  2
 * Output 2:
 *  4
 *
 *
 * * Example Explanation *
 * * Explanation 1: *
 * Digit 1 appears in 1 and 10 only and appears one time in each. So the answer is 2.
 *
 * * Explanation 2: *
 * Digit 1 appears in 1(1 time) , 10(1 time) and 11(2 times) only. So the answer is 4.
 *
 * -----------------------------------------------------------------------------------------------
 * * Hint *
 * Try to find the formula for ten’s place, a hundred’s place, and so on.
 *
 * Solution can be summarised into 4 steps:
 * 1) Initialize ans = 0
 * 2) Iterate over i from 1 to n incrementing by 10 times in each iteration.
 * 3) Add (n / (i * 10 ) ) * i to ans after each (i * 10) interval.
 * 4) Add min( max((n mod (i * 10) – i + 1, 0), i) to ans.
 *-----------------------------------------------------------------------------------------------
 *
 * * Brute Force Solution *
 *
 *     public int solve(int A) {
 *         int count = 0;
 *         for(int i=0; i<=A; i++) {
 *             count += countOne(i);
 *         }
 *         return count;
 *     }
 *
 *     private int countOne(int n) {
 *         int count = 0;
 *         while(n > 0) {
 *             int temp = n % 10;
 *             if(temp == 1) {
 *                 count++;
 *             }
 *             n /= 10;
 *         }
 *
 *         return count;
 *     }
 *
 *
 */



package Array;


public class Number_of_Digit_One {

    public static int solve(int A) {
        int n = A, factors = 1, count = 0, remainder = 0;
        while (n > 0) {
            int temp = factors;
            // check for remainders three cases mentioned in
            // the approach
            if (n % 10 == 0) {
                remainder = 0;
            }
            else if (n % 10 > 1) {
                remainder = temp;
            }
            else if (n % 10 == 1) {
                remainder = (A % temp) + 1;
            }
            factors
                    *= 10; // increamneting factors for checking
            // different locations such as ones,
            // tens,hundreds places ones
            count += (A / factors) * temp + remainder;
            n = n / 10;
        }
        return count;
    }

    public static void main(String[] args) {

    }

}
