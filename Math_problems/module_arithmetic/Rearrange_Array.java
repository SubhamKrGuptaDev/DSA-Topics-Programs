/**
 *
 * Problem Statement
 * Given an array A of size N. Rearrange the given array so
 * that A[i] becomes A[A[i]] with O(1) extra space.
 *
 * Constraints:
 *
 * 1 <= N <= 5×104
 *
 * 0 <= A[i] <= N - 1
 *
 * Example 1:
 *
 * Input : [1, 0]
 * Return : [0, 1]
 * Example 2:
 *
 * Input : [0, 2, 1, 3]
 * Return : [0, 1, 2, 3]
 *
 *
 * * Hint *
 *
 * If you had extra space to do it, the problem will be very easy.
 * Store a copy of Arr in B.
 *
 * And then for every element, do Arr[i] = B[B[i]]
 *
 * Let's restate what we just said for extra space :
 *
 * If we could somehow store 2 numbers in every index
 * ( that is, Arr[i] can contain the old value and the new value somehow ),
 * then the problem becomes very easy.
 * NewValue of Arr[i] = OldValue of Arr[OldValue of Arr[i]]
 *
 * Now, we will do a slight trick to encode 2 numbers in one index.
 * This trick assumes that N * N does not overflow.
 *
 * 1) Increase every Array element Arr[i] by (Arr[Arr[i]] % n)*n.
 * 2) Divide every element by N.
 * Given a number as
 *
 *    A = B + C * N   if ( B, C < N )
 *    A % N = B
 *    A / N = C
 * We use this fact to encode 2 numbers into each element of Arr.
 *
 *
 */

package Math_problems.module_arithmetic;

import java.util.ArrayList;

public class Rearrange_Array {
    // WithOut extra space
    public void arrange1(ArrayList<Integer> A) {
        int n = A.size();
        for(int i=0; i<n; i++) {
            A.set(i, A.get(i) + (A.get(A.get(i)) % n) * n);
        }
        for(int i=0; i<n; i++) {
            A.set(i, A.get(i) / n);
        }
    }

    // With Extra Space
    public void arrange2(ArrayList<Integer> A) {
        int n = A.size();
        ArrayList<Integer> B = new ArrayList<>();
        for(int i=0; i<n; i++) {
            B.add(A.get(i));
        }
        for(int i=0; i<n; i++) {
            A.set(i, B.get(B.get(i)));
        }
    }

    public static void main(String[] args) {

    }

}
