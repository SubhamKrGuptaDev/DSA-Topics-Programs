/**
 *
 *
 *
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
