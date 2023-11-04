package _2_pointer;

import java.util.ArrayList;
import java.util.Collections;

public class Pairs_with_given_difference {
    public int solve(ArrayList<Integer> A, int B) {
        return Approach2Pointer(A, B);
    }

    private int Approach2Pointer(ArrayList<Integer> A, int B) {
        Collections.sort(A);
        int n = A.size();
        int count = 0;

        int left = 0;
        int right = 1;

        while (right < n && left < n) {
            if(left == right) {
                right++;
                continue;
            }
            if (A.get(left) - A.get(right) == B) {
                int x = A.get(left);
                int y = A.get(right);
                count++;
                while(left < n && x == A.get(left)) left++;
                while(right < n && y == A.get(right)) right++;
            }
            else if (A.get(left) - A.get(right) > B)
                left++;
            else // A.get(left) - A.get(right) < B
                right++;
        }

        return count;
    }

    public static void main(String[] args) {

    }

}
