/**
 *
 * Problem Description
 *
 * You are given two positive numbers A and B .
 * You need to find the maximum valued integer X such that:
 *
 * X divides A i.e. A % X = 0
 * X and B are co-prime i.e. gcd(X, B) = 1
 *
 *
 *
 * Problem Constraints
 *
 * 1 <= A, B <= 10^9
 *
 *
 * Example Input
 *
 * Input 1:
 *
 *  A = 30
 *  B = 12
 * Input 2:
 *
 *  A = 5
 *  B = 10
 *
 *
 * Example Output
 *
 * Output 1:
 *
 *  5
 * Output 2:
 *
 *  1
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 *  All divisors of A are (1, 2, 3, 5, 6, 10, 15, 30).
 *  The maximum value is 5 such that A%5 == 0 and gcd(5,12) = 1
 * Explanation 2:
 *
 *  1 is the only value such that A%5 == 0 and gcd(1,10) = 1
 *
 * <>
 *     * Hint *
 *      *  We can try to remove the common factors of A and B from A by finding the
 *      *  greatest common divisor (gcd) of A and B and dividing A with that gcd.
 *      *
 *      * Mathematically, A = A / gcd(A, B) —— STEP1
 *      * Now, we repeat STEP1 till we get gcd(A, B) = 1.
 *      * Atlast, we return X = A
 *      *
 *      * How does this work ?
 *      *
 *      * On doing prime factorization of A and B, we get :
 *      *
 *      * A = p1x1 . p2x2 . … . pkxk
 *      * B = q1y1 . q2y2 . … . qlyl
 *      * Where pi ; i = 1, 2, …, k are prime factors of A and xi ; i = 1, 2, …, k
 *      * are their respective powers
 *      * Similarly, qj ; i = 1, 2, …, l are prime factors of B and yi ; j = 1, 2, …, l
 *      * are their respective powers
 *      *
 *      * Let ri ; i = 1, 2, …, m be the common factors of A and B. By repeating STEP1,
 *      * we are reducing the respective powers of ri by at least one each time
 *      * (Proof of this is left to the reader). Therefore, we reach a point where
 *      * powers of ri become zero, and the product of the rest prime-powers in
 *      * A form the largest divisor of A that is co-prime with B.
 *
 *
 *
 * </>
 *
 */

package Math_GCD;

public class Largest_Coprime_Divisor {

    // Iterative Solution
    public int cpFact(int A, int B) {
        int gcdValue = gcdIterative(A,B);
        while(gcdValue != 1) {
            A /= gcdValue;
            gcdValue = gcdIterative(A, B);
        }
        return A;
    }
    private int gcdIterative(int A, int B) {
        while(B > 0) {
            int temp = A % B;
            A = B;
            B = temp;
        }
        return A;
    }

    // Recursion Solution
    public int recursionFact(int A, int B) {
        int gcd = gcd(A,B);
        if(gcd == 1) return A;
        return cpFact(A/gcd, B);
    }
    private int gcd(int n1, int n2) {
        if(n1 == 0) return n2;
        if(n2 == 0) return n1;
        return gcd(n2, n1 % n2);
    }

    public static void main(String[] args) {
        Largest_Coprime_Divisor object = new Largest_Coprime_Divisor();

        int answer = object.cpFact(12, 30);

        System.out.println(answer);
    }

}
