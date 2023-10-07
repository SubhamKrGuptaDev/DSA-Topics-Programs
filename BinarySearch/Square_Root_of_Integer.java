/**
 *
 * Problem Description
 * Given an integer A. Compute and return the square root of A.
 * If A is not a perfect square, return floor(sqrt(A)).
 *
 * The value of A can cross the range of Integer.
 *
 * NOTE:
 *    Do not use the sqrt function from the standard library.
 *    Users are expected to solve this in O(log(A)) time.
 *
 *
 * Problem Constraints
 * 0 <= A <= 10^10
 *
 *
 *
 * * Example Input *
 * Input 1:
 *
 *  11
 * Input 2:
 *
 *  9
 *
 *
 * * Example Output *
 * Output 1:
 *
 *  3
 * Output 2:
 *
 *  3
 *
 *
 * * Example Explanation *
 * Explanation 1:
 * When A = 11 , square root of A = 3.316. It is not a perfect square so we return the
 * floor which is 3.
 * Explanatino 2:
 * When A = 9 which is a perfect square of 3, so we return 3.
 *
 *
 *
 *
 *
 *
 *
 */



package BinarySearch;

public class Square_Root_of_Integer {

    public int sqrtBinarySearchApproach(int A) {
        long left = 1;
        long right = A;
        while(left <= right) {
            long mid = (left+right) / 2L;
            if(mid * mid <= A && (mid + 1L) * (mid + 1L) > A) {
                return (int)mid;
            }
            if(mid * mid < A) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }

        return 0;
    }

    public int sqrtSquareApproach(int n) {
        int i;
        int ans = 0;
        for(i=1; i*i<= n; i++) {
            ans = i;
        }
        return ans;
    }

    public int sqrtRecursionApproach(int n, int i) {
        if(n == i*i) {
            return i;
        }
        if(n < i*i) {
            return i-1;
        }

        return sqrtRecursionApproach(n, i+1);
    }

    public int sqrtLinearApproach(int n) {
        int ans = 1;
        boolean found = false;
        for(int i=0; i<n; i++) {
            if(i*i == n) {
                ans = i;
            }
            if(!found &&i*i > n) {
                ans = i;
                found = true;
            }
        }

        return ans;
    }

    public int sqrtBruteForceApproach(int n) {
        return 1;
    }

    public static void main(String[] args) {
        Square_Root_of_Integer object = new Square_Root_of_Integer();
        int res = object.sqrtRecursionApproach(50, 1);
        System.out.println(res);
    }

}
