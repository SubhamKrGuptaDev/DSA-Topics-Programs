/**
 *
 * Problem Description
 * You are given an array A of N integers.
 * Return a 2D array consisting of all the subarrays of the array
 *
 * Note : The order of the subarrays in the resulting 2D array does not matter.
 *
 *
 * Problem Constraints
 * 1 <= N <= 100
 * 1 <= A[i] <= 105
 *
 *
 * Input Format
 * First argument A is an array of integers.
 *
 *
 * Output Format
 * Return a 2D array of integers in any order.
 *
 *
 * Example Input
 * Input 1:
 * A = [1, 2, 3]
 * Input 2:
 * A = [5, 2, 1, 4]
 *
 *
 * Example Output
 * Output 1:
 * [[1], [1, 2], [1, 2, 3], [2], [2, 3], [3]]
 * Output 2:
 * [[1 ], [1 4 ], [2 ], [2 1 ], [2 1 4 ], [4 ], [5 ], [5 2 ], [5 2 1 ], [5 2 1 4 ] ]
 *
 *
 * Example Explanation
 * For Input 1:
 * All the subarrays of the array are returned. There are a total of 6 subarrays.
 * For Input 2:
 * All the subarrays of the array are returned. There are a total of 10 subarrays.
 *
 *
 */


package Array.subarray;

import java.util.ArrayList;

public class Generate_all_subarrays {

    public ArrayList<ArrayList<Integer>> solve1(ArrayList<Integer> A) {
        int n = A.size();
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        for(int i=0; i<n; i++) {
            for(int j=i; j<n; j++) {
                ArrayList<Integer> temp = new ArrayList<>();
                for(int k=i; k<=j; k++) {
                    temp.add(A.get(k));
                }
                arr.add(temp);
            }
        }
        return arr;
    }

    public ArrayList<ArrayList<Integer>> solve2(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        int n = A.size();
        for(int i = 0 ; i < n ; i++){
            for(int j = i ; j <n ; j++){
                ArrayList<Integer> v = new ArrayList<Integer>();
                for(int k = i ; k <= j ; k++){
                    v.add(A.get(k));
                }
                ans.add(v);
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }

}
