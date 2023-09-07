/**
 *
 *
 * * Problem Description *
 *
 * Given an integer A, find and return the Ath magic number.
 * A magic number is defined as a number that can be expressed as a power of 5 or
 * a sum of unique powers of 5.
 * First few magic numbers are 5, 25, 30(5 + 25), 125, 130(125 + 5), ….
 *
 *
 * * Problem Constraints *
 * 1 <= A <= 5000
 *
 *
 * * Example Input *
 *
 * Example Input 1:
 *  A = 3
 * Example Input 2:
 *  A = 10
 *
 *
 * * Example Output *
 *
 * Example Output 1: 30
 * Example Output 2: 650
 *
 *
 * * Example Explanation *
 *
 * * Explanation 1: *
 *  Magic Numbers in increasing order are [5, 25, 30, 125, 130, ...]
 *  3rd element in this is 30
 *
 * * Explanation 2: *
 *  In the sequence shown in explanation 1, 10th element will be 650.
 *
 *
 *
 *
 * -----------------------------------------------------------------------------------------------
 * * Hint *
 * Can you create this full array somehow?
 * What will be the time required to create it?
 * Can the idea of representing numbers in binary be helpful here?
 * -----------------------------------------------------------------------------------------------
 *
 *
 *
 *
 *
 */







package bit_manupulation;

public class Find_nth_Magic_Number {

    public static int solve(int A) {
        int result = 0;
        int calculate = 1;
        while(A > 0) {
            calculate *= 5;             // All Iteration Multiply by 5
            if((A & 1) == 1) {
                result += calculate;    // if Ath first bit is 1 then sum
            }
            A >>= 1;                    // Shirt left bit
        }

        return result;
    }

    public static void main(String[] args) {
        int result = solve(3);
        if(result != 30) {
            throw new RuntimeException("Test Case Doesn't Match");
        }

        System.out.println(result);
    }

}
