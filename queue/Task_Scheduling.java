package queue;

import java.util.LinkedList;
import java.util.Queue;

public class Task_Scheduling {

    public int solve(int[] A, int[] B) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < A.length; i++) {
            q.add(A[i]);
        }
        int ans = 0;
        for (int i = 0; i < B.length; i++) {
            // move the task to the back of the queue if it is not equal to B[i]
            while (B[i] != q.peek()) {
                ans++;
                q.add(q.poll());
            }
            q.remove();
            ans++;
        }
        return ans;
    }

    public static void main(String[] args) {

    }

}
