/**
 * Problem Description
 * Given an array with N objects colored red, white, or blue,
 * sort them so that objects of the same color are adjacent, with the colors in the
 * order red, white, and blue.
 *
 *
 * We will represent the colors as,
 *
 * red -> 0
 * white -> 1
 * blue -> 2
 *
 * Note: Using the library sort function is not allowed.
 *
 *
 * Problem Constraints
 * 1 <= N <= 1000000
 * 0 <= A[i] <= 2
 *
 *
 * * Example Input *
 * Input 1 :
 *     A = [0, 1, 2, 0, 1, 2]
 * Input 2:
 *
 *     A = [0]
 *
 *
 * * Example Output *
 * Output 1:
 *     [0, 0, 1, 1, 2, 2]
 * Output 2:
 *
 *     [0]
 *
 * * Example Explanation *
 * Explanation 1:
 *     [0, 0, 1, 1, 2, 2] is the required order.
 * Explanation 2:
 *     [0] is the required order
 *
 *
 *
 *
 *
 *
 */


package comparator;

import java.util.ArrayList;

public class Sort_by_Color {

    public ArrayList<Integer> sortColors(ArrayList<Integer> A) {
        int countZero = 0;
        int countOne = 0;
        for(int X : A) {
            if(X == 0) countZero++;
            else if(X == 1) countOne++;
        }
        ArrayList<Integer> result = new ArrayList<>();
        for(int i=0; i<countZero; i++) {
            result.add(0);
        }
        for(int i=countZero; i<countZero+countOne; i++) {
            result.add(1);
        }
        for(int i=countZero+countOne; i<A.size(); i++) {
            result.add(2);
        }

        return result;
    }

    public static void main(String[] args) {

    }

}
