/**
 *
 * Problem Description
 * Given a sorted array of integers A where every element appears twice except for one
 * element which appears once, find and return this single element that appears only once.
 *
 * Elements which are appearing twice are adjacent to each other.
 *
 * NOTE: Users are expected to solve this in O(log(N)) time.
 *
 *
 * Problem Constraints
 * 1 <= |A| <= 100000
 *
 * 1 <= A[i] <= 10^9
 *
 *
 * * Example Input *
 * Input 1:
 *
 * A = [1, 1, 7]
 * Input 2:
 *
 * A = [2, 3, 3]
 *
 *
 * * Example Output *
 * Output 1:
 *
 *  7
 * Output 2:
 *
 *  2
 *
 *
 * * Example Explanation *
 * Explanation 1:
 *
 *  7 appears once
 * Explanation 2:
 *
 *  2 appears once
 *
 *
 *
 *
 */


package BinarySearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Single_Element_in_Sorted {

    public int binarySearch(ArrayList<Integer> A) {
        int n = A.size();
        int left = 0;
        int right = n-1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if((mid == 0 || !A.get(mid).equals(A.get(mid - 1))) &&
                    (mid == n-1 || !A.get(mid).equals(A.get(mid + 1)))
            ) {
                return A.get(mid);
            }
            if(mid != 0 && A.get(mid).equals(A.get(mid - 1))) {
                if(mid % 2 == 0) right = mid - 1;
                else left = mid + 1;
            }
            else {
                if(mid % 2 == 0) left = mid + 1;
                else right = mid - 1;
            }
        }

        return -1;
    }

    public int usingXor(ArrayList<Integer> A) {
        int n = A.size();
        long xor = 0;  // For The Over Flow
        for(int i=0; i<n; i++) {
            xor ^= A.get(i);
        }

        return (int)xor;
    }

    public int usingHashMapFind(ArrayList<Integer> A) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = A.size();
        for(int x : A) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        for(Map.Entry<Integer,Integer> entry : map.entrySet())
            if(entry.getValue().equals(1)) return entry.getKey();

        return -1;
    }

    // If Array Sorted Then this Approach work other wise doesn't work
    public int linearApproach(ArrayList<Integer> A) {
        int n = A.size();

        if(n == 1) return A.get(0);
        if(!A.get(0).equals(A.get(1))) return A.get(0);
        if(!A.get(n-1).equals(A.get(n-2))) return A.get(n-1);

        for(int i=1; i<n; i++) {
            if(!A.get(i-1).equals(A.get(i)) && !A.get(i).equals(A.get(i+1))) return A.get(i);
        }

        return -1;
    }


    public int bruteForceFindElement(ArrayList<Integer> A) {
        int n = A.size();
        if(n == 1) return A.get(0);
        for(int i=0; i<n; i++) {
            boolean found = false;
            for(int j=i+1; j<n; j++) {
                if(A.get(i).equals(A.get(j))) {
                    found = true;
                    break;
                }
            }
            if(i != n-1 && !found) return A.get(i);
        }

        if(!A.get(n-1).equals(A.get(n-2))) return A.get(n-1);

        return -1;
    }

    public static void main(String[] args) {

    }

}
