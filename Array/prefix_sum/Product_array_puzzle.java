/**
 *
 * Given an array of integers A, find and return the product array of the same size where the ith element of the product array will be equal to the product of all the elements divided by the ith element of the array.
 *
 * Note: It is always possible to form the product array with integer (32 bit) values. Solve it without using the division operator.
 *
 *
 * Input Format
 *
 * The only argument given is the integer array A.
 * Output Format
 *
 * Return the product array.
 * Constraints
 *
 * 2 <= length of the array <= 1000
 * 1 <= A[i] <= 10
 * For Example
 *
 * Input 1:
 *     A = [1, 2, 3, 4, 5]
 * Output 1:
 *     [120, 60, 40, 30, 24]
 *
 * Input 2:
 *     A = [5, 1, 10, 1]
 * Output 2:
 *     [10, 50, 5, 50]
 *
 *
 */


package Array.prefix_sum;

import java.util.ArrayList;

public class Product_array_puzzle {

    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        ArrayList<Integer> arr = new ArrayList<>();

        for(int i=0; i<A.size(); i++) {
            int product = 1;
            for(int j=0; j<A.size(); j++) {
                if(i != j) {
                    product *= A.get(j);
                }

            }
            arr.add(product);
        }

        return arr;
    }

    public static void main(String[] args) {

    }

}
