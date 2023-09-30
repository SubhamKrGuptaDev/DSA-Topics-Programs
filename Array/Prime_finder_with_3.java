/**
 *
 * Problem Description
 * in the small town of Numeric, there was a legendary math club called "the prime
 * detectives." this club consisted of a group of brilliant young students who loved
 * solving mathematical mysteries.
 *
 * one day, a mysterious message arrived at the club's headquarters.
 * The message contained two numbers, A and B, nad a cryptic challenge stated that
 * within the range of numbers from A to B, There were special prime numbers that
 * held the key to unlocking a hidden treasure. special prime numbers are the
 * prime number that end with 3.
 *
 *
 * Given A and B can You find All prime number in the range whose last digit is 3.
 *
 * problem Constraints
 * 1 <= A, B <= 10^5
 *
 *
 */


package Array;

public class Prime_finder_with_3 {

    // linear Approach
    private boolean linearPrimeNumber(int n) {
        if(n <= 1) return false;
        int i;
        for(i=2; i<=n; i++) {
            if(n % i == 0) break;
        }
        return i == n;
    }

    // N/2 Approach
    private boolean halfPrimeChecker(int n) {
        for(int i=2; i<=n/2; i++) {
            if(n % i == 0) return false;
        }
        return true;
    }

    // sqrt approach
    private boolean sqrtPrimeChecker(int n) {
        if(n <= 1) return false;
        for(int i=2; i*i<=n; i++) {
            if(n % i == 0) return false;
        }
        return true;
    }

    // factor checking approach
    private boolean factorCheckingPrime(int n) {
        int factor = 0;
        int i;
        for(i=1; i*i<=n; i++) {

            if(n % i == 0) {
                factor += 2;
            }
        }
        if((i-1) * (i-1) == n) factor--;
        return factor == 2;
    }




    public static void main(String[] args) {

    }
}
