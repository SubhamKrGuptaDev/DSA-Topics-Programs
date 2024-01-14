/**
 *
 * Problem Description
 * Say you have an array, A, for which the ith element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 *
 * Return the maximum possible profit.
 *
 *
 *
 * Problem Constraints
 * 0 <= A.size() <= 700000
 * 1 <= A[i] <= 107
 *
 *
 *
 * Input Format
 * The first and the only argument is an array of integers, A.
 *
 *
 * Output Format
 * Return an integer, representing the maximum possible profit.
 *
 *
 * Example Input
 * Input 1:
 * A = [1, 2]
 * Input 2:
 *
 * A = [1, 4, 5, 2, 4]
 *
 *
 * Example Output
 * Output 1:
 * 1
 * Output 2:
 *
 * 4
 *
 *
 * Example Explanation
 * Explanation 1:
 * Buy the stock on day 0, and sell it on day 1.
 * Explanation 2:
 *
 * Buy the stock on day 0, and sell it on day 2.
 *
 *
 */


package Array.carry_forward;

import java.util.List;

public class Best_Time_to_Buy_and_Sell_Stocks_I {

    public int maxProfit(final List<Integer> A) {
        int n = A.size();
        if(n == 0) return 0;
        int buy = A.get(0);
        int maxProfit = 0;
        for(int i=0; i<n; i++) {
            int current = A.get(i) - buy;
            maxProfit = Math.max(maxProfit, current);
            buy = Math.min(buy, A.get(i));
        }

        return maxProfit;
    }

}
