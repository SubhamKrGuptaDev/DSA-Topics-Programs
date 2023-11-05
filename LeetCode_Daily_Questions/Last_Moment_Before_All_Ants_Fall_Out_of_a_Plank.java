/**
 *
 * Problem name
 * Last Moment Before All Ants Fall Out of a Plank
 *
 *
 * We have a wooden plank of the length n units. Some ants are walking on the plank,
 * each ant moves with a speed of 1 unit per second. Some of the ants move to the left,
 * the other move to the right.
 *
 * When two ants moving in two different directions meet at some point, they change their
 * directions and continue moving again. Assume changing directions does not take any additional
 * time.
 *
 * When an ant reaches one end of the plank at a time t, it falls out of the plank immediately.
 *
 * Given an integer n and two integer arrays left and right, the positions of the ants moving
 * to the left and the right, return the moment when the last ant(s) fall out of the plank.
 *
 *
 *
 * Constraints:
 *
 * 1 <= n <= 104
 * 0 <= left.length <= n + 1
 * 0 <= left[i] <= n
 * 0 <= right.length <= n + 1
 * 0 <= right[i] <= n
 * 1 <= left.length + right.length <= n + 1
 * All values of left and right are unique, and each value can appear only in one of the two arrays.
 *
 *
 */



package LeetCode_Daily_Questions;

public class Last_Moment_Before_All_Ants_Fall_Out_of_a_Plank {

    public int getLastMoment(int n, int[] left, int[] right) {
        int leftMax = Integer.MIN_VALUE;
        int rightMax = Integer.MIN_VALUE;

        for(int i=0; i<left.length; i++)
            leftMax = Math.max(leftMax, left[i]);

        for(int i=0; i<right.length; i++)
            rightMax = Math.max(rightMax, n - right[i]);

        int max = Math.max(leftMax, rightMax);

        return max;
    }

    public static void main(String[] args) {
        
    }

}
