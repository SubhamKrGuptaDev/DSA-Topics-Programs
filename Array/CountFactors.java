/**
 *
 * Problem Description
 * Given an integer A, you need to find the count of its factors.
 *
 * Factor of a number is the number which divides it perfectly leaving no remainder.
 *
 * Example : 1, 2, 3, 6 are factors of 6
 *
 *
 * Problem Constraints
 * 1 <= A <= 10^9
 *
 *
 * * Example Input *
 * Input 1:
 * 5
 * Input 2:
 * 10
 *
 *
 * * Example Output *
 * Output 1:
 * 2
 * Output 2:
 * 4
 *
 *
 * * Example Explanation *
 * Explanation 1:
 * Factors of 5 are 1 and 5.
 * Explanation 2:
 * Factors of 10 are 1, 2, 5 and 10.
 *
 * * Other Solution *
 * <>
 *      public int solve(int A) {
 *         int count = 0;
 *         for(int i = 1 ; i * i <= A ; i++) {
 *             if(A % i == 0) {
 *     		    if(i * i == A)
 *     		        count += 1;
 *     		    else
 *     		        count += 2;
 *             }
 *         }
 *         return count;
 *     }
 * </>
 *
 *
 *
 *
 */


package Array;

public class CountFactors {

    // SquareRoot Approach TC: sqrt(N)
    public int optimizedApproach(int A) {
        int count = 0;
        int i;
        for(i=1; i*i<=A; i++) {
            if(A%i == 0) count += 2;
        }
        if((i-1) * (i-1) == A) count--;
        return count;
    }

    // N/2 Approach
    public int betterApproach(int A) {
        int count = 0;
        for(int i=1; i<=A/2; i++) {
            if(A % i == 0) count++;
        }
        return count+1;
    }

    // linear TC
    public int bruteForcefactor(int A) {
        int count = 0;
        for(int i=1; i<=A; i++) {
            if(A % i == 0) count++;
        }
        return count;
    }

}
