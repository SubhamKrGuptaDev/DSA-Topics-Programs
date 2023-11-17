/**
 *
 * Problem Description
 * Given an array A, find the nearest smaller element G[i] for every element A[i] in the array
 * such that the element has an index smaller than i.
 *
 * More formally,
 *
 * G[i] for an element A[i] = an element A[j] such that
 *
 * j is maximum possible AND
 *
 * j < i AND
 *
 * A[j] < A[i]
 *
 * Elements for which no smaller element exist, consider the next smaller element as -1.
 *
 *
 *
 * Problem Constraints
 * 1 <= |A| <= 100000
 *
 * -109 <= A[i] <= 109
 *
 *
 *
 * Input Format
 * The only argument given is integer array A.
 *
 *
 *
 * Output Format
 * Return the integar array G such that G[i] contains the nearest smaller number than A[i].
 * If no such element occurs G[i] should be -1.
 *
 *
 *
 * * Example Input *
 * Input 1:
 *
 *  A = [4, 5, 2, 10, 8]
 * Input 2:
 *
 *  A = [3, 2, 1]
 *
 *
 * * Example Output *
 * Output 1:
 *
 *  [-1, 4, -1, 2, 2]
 * Output 2:
 *
 *  [-1, -1, -1]
 *
 *
 * * Example Explanation *
 * Explanation 1:
 *
 * index 1: No element less than 4 in left of 4, G[1] = -1
 * index 2: A[1] is only element less than A[2], G[2] = A[1]
 * index 3: No element less than 2 in left of 2, G[3] = -1
 * index 4: A[3] is the nearest element which is less than A[4], G[4] = A[3]
 * index 4: A[3] is the nearest element which is less than A[5], G[5] = A[3]
 * Explanation 2:
 *
 * index 1: No element less than 3 in left of 3, G[1] = -1
 * index 2: No element less than 2 in left of 2, G[2] = -1
 * index 3: No element less than 1 in left of 1, G[3] = -1
 *
 *
 *
 */

package stack;

import java.util.ArrayList;
import java.util.Stack;

public class Nearest_Smaller_Element {

    public ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {
        return stackApproach(A);
    }

    // Brute Force Approach
    private ArrayList<Integer> bruteForceApproach(ArrayList<Integer> A) {
        int n = A.size();
        ArrayList<Integer> result = new ArrayList<>();
        for(int i=0; i<n; i++) {
            boolean found = false;
            for(int j=i-1; j>=0; j--) {
                if(A.get(j) < A.get(i)) {
                    result.add(A.get(j));
                    found = true;
                    break;
                }
            }
            if(!found) {
                result.add(-1);
            }
        }

        return result;
    }

    // Stack Approach
    private ArrayList<Integer> stackApproach(ArrayList<Integer> A) {
        Stack<Integer> stack = new Stack<>();
        int n = A.size();

        ArrayList<Integer> result = new ArrayList<>();

        for(int i=0; i<n; i++) {
            while(!stack.isEmpty() && stack.peek() >= A.get(i)) {
                stack.pop();
            }
            if(stack.isEmpty()) result.add(-1);
            else result.add(stack.peek());

            stack.push(A.get(i));
        }

        return result;
    }

    public static void main(String[] args) {

    }

}
