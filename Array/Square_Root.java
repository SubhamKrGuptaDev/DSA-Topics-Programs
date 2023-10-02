/**
 *
 * Problem Description
 *
 * Given a number A. Return square root of the number if it is
 * perfect square otherwise return -1.
 *
 * Note: A number is a perfect square if its square root is an integer.
 *
 * Problem Constraints
 *
 * 1 <= A <= 10^8
 * Input Format
 *
 * First and the only argument is an integer A.
 * Output Format
 *
 * Return an integer which is the square root of A if A is perfect square
 * otherwise return -1.
 * Example Input
 *
 * Input 1:
 * A = 4
 * Input 2:
 *
 * A = 1001
 * Example Output
 *
 * Output 1:
 * 2
 * Output 2:
 *
 * -1
 * Example Explanation
 *
 * Explanation 1:
 * sqrt(4) = 2
 * Explanation 2:
 *
 * 1001 is not a perfect square.
 *
 * <>
 *     public int solve(int A) {
 *         // Loop from 1 to 10000
 *         for(int i = 1; i <= 10000; i++){
 *             if(i*i==A){
 *                 return i;
 *             }
 *         }
 *         return -1;
 *     }
 * </>
 *
 *
 */


package Array;

public class Square_Root {

    // TC: O(1) Limit - 100000000
    public int sqareRootOptimize(int A) {
        int i=1;
        while(i*i <= 100000000) {
            if(i*i == A) return i;
            i++;
        }
        return -1;
    }

    // TC: O(A)
    public int solve(int A) {
        int i;
        int ans = -1;
        for(i=0; i*i<=A; i++){
            ans = i;
        }
        if(ans*ans == A) return ans;
        return -1;
    }

    public static void main(String[] args) {

    }

}
