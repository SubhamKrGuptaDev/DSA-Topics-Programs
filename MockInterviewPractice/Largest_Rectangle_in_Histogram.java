/**
 *
 * leetcode - https://leetcode.com/problems/largest-rectangle-in-histogram/description/
 *
 * Given an array of integers A .
 *
 * A represents a histogram i.e A[i] denotes height of the ith histogram's bar. Width of each bar is 1.
 *
 * Find the area of the largest rectangle formed by the histogram.
 *
 *
 *
 * Problem Constraints
 * 1 <= |A| <= 100000
 *
 * 1 <= A[i] <= 1000000000
 *
 *
 *
 * Input Format
 * The only argument given is the integer array A.
 *
 *
 *
 * Output Format
 * Return the area of largest rectangle in the histogram.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [2, 1, 5, 6, 2, 3]
 * Input 2:
 *
 *  A = [2]
 *
 *
 * Example Output
 * Output 1:
 *
 *  10
 * Output 2:
 *
 *  2
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 * The largest rectangle has area = 10 unit. Formed by A[3] to A[4].
 * Explanation 2:
 *
 * Largest rectangle has area 2.
 *
 *
 */




package MockInterviewPractice;

import java.util.Stack;

public class Largest_Rectangle_in_Histogram {


    // Solution with stack
    public int largestRectangleAreaWithStack(int[] heights) {
        int n = heights.length;
        int maxArea = 0;
        Stack<Integer> st = new Stack<>();

        for(int i = 0; i <= n; i++){
            int currHeight = i == n ? 0 : heights[i];
            // check if currHeight becomes greater then height[top] element of stack. we do a push because it's an increasing sequence
            // otherwise we do pop and find area, so for that we write a while loop
            while(!st.isEmpty() && currHeight < heights[st.peek()]){
                int top = st.pop(); // current element on which we are working
                // now we need width & area
                int width = st.isEmpty() ? i : i - st.peek() - 1; // width differ, if stack is empty or not empty after we pop the element
                int area = heights[top] * width; // current height * width
                maxArea = Math.max(area, maxArea);
            }
            // if it doesn't enter in while loop, it means it's an increasing sequence & we need to push index
            st.push(i);
        }
        return maxArea;
    }



}
