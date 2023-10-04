/**
 *
 * Problem Description
 * Given a sorted array of integers A (0-indexed) of size N,
 * find the left most and the right most index of a given integer B in the array A.
 *
 * Return an array of size 2, such that
 *           First element = Left most index of B in A
 *           Second element = Right most index of B in A.
 * If B is not found in A, return [-1, -1].
 *
 * Note : Your algorithm's runtime complexity must be in the order of O(log n).
 *
 *
 *
 * Problem Constraints
 * 1 <= N <= 10^6
 * 1 <= A[i], B <= 10^9
 *
 *
 *
 * * Example Input *
 * Input 1:
 *
 *  A = [5, 7, 7, 8, 8, 10]
 *  B = 8
 * Input 2:
 *
 *  A = [5, 17, 100, 111]
 *  B = 3
 *
 *
 * * Example Output *
 * Output 1:
 *
 *  [3, 4]
 * Output 2:
 *
 *  [-1, -1]
 *
 *
 * * Example Explanation *
 * Explanation 1:
 *
 *  The first occurrence of 8 in A is at index 3.
 *  The last occurrence of 8 in A is at index 4.
 *  ans = [3, 4]
 * Explanation 2:
 *
 *  There is no occurrence of 3 in the array.
 *
 *  <>
 *  public ArrayList<Integer> searchRange(final List<Integer> A, int B) {
 * 	    int low, up;
 * 	    ArrayList<Integer> res = new ArrayList<>();
 * 	    low = lowerBound(A, 0, A.size() - 1, B);
 * 	    if (low == -1) {
 * 	        res.add(-1);
 * 	        res.add(-1);
 * 	        return res;
 *                }
 * 	   up = upperBound(A, 0, A.size() - 1, B);
 * 	   res.add(low);
 * 	   res.add(up);
 * 	   return r    ;
 * 	}
 *
 * 	public int lowerBound(final List<Integer> A, int start, int end, int num) {
 * 	    int steps = end - start + 1;
 * 	    int mid;
 * 	    int low = -1;
 * 	    int val;
 * 	    while (steps > 0) {
 * 	        mid = (start + end) / 2;
 * 	        val = A.get(mid);
 * 	        if (num < val)
 * 	            end = mid - 1;
 * 	        else if (num > val)
 * 	            start = mid + 1;
 * 	        else{
 * 	            low = mid;
 * 	            end = mid - 1;
 *            }
 * 	        steps /= 2;
 *        }
 * 	    return l    ;
 * 	}
 * 	public int upperBound(final List<Integer> A, int start, int end, int num) {
 * 	    int steps = end - start + 1;
 * 	    int mid;
 * 	    int up = end + 1;
 * 	    int val;
 * 	    while (steps > 0) {
 * 	        mid = (start + end) / 2;
 * 	        val = A.get(mid);
 * 	        if (num < val)
 * 	            end = mid - 1;
 * 	        else if (num > val)
 * 	            start = mid + 1;
 * 	        else{
 * 	            up = mid;
 * 	            start = mid + 1;
 *            }
 * 	        steps /= 2;
 *        }
 * 	    return     ;
 * 	}
 *  </>
 *
 *
 */



package BinarySearch;

import java.util.ArrayList;
import java.util.List;

public class Search_for_a_Range {

    // Linear Search
    public ArrayList<Integer> linearSearch(List<Integer> A, int B) {
        ArrayList<Integer> result = new ArrayList<>();
        int leftMost = -1;
        int rightMost = -1;
        int n = A.size();
        for(int i=0; i<n; i++) {
            if(A.get(i) == B) {
                leftMost = i;
                break;
            }
        }
        for(int i=n-1; i>=0; i--) {
            if(A.get(i) == B) {
                rightMost = i;
                break;
            }
        }

        result.add(leftMost);
        result.add(rightMost);

        return result;
    }


    // Binary Search
    public ArrayList<Integer> searchRange(final List<Integer> A, int B) {
        ArrayList<Integer> result = new ArrayList<>();
        int leftMostElement = binarySearchLeftMostElement(A,B);
        int rightMostElement = binarySearchRightMostElement(A,B);
        result.add(leftMostElement);
        result.add(rightMostElement);

        return result;
    }

    private int binarySearchLeftMostElement(List<Integer> A, int B) {
        int left = 0;
        int right = A.size() - 1;
        // left most checking B value
        while(left <= right) {
            int mid = (left + right) / 2;
            if(A.get(mid) == B) {
                if(mid == 0 || !A.get(mid).equals(A.get(mid - 1))) {
                    return mid;
                }
            }
            if(A.get(mid) < B) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return -1;
    }

    private int binarySearchRightMostElement(List<Integer> A, int B) {
        int left = 0;
        int right = A.size() - 1;
        int n = A.size() - 1;
        // left most checking B value
        while(left <= right) {
            int mid = (left + right) / 2;
            if(A.get(mid) == B) {
                if(mid == n || !A.get(mid).equals(A.get(mid + 1))) {
                    return mid;
                }
            }
            if(A.get(mid) <= B) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

    }

}
