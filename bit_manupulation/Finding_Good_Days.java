/**
 *
 * * Problem Description *
 *
 * Alex has a cat named Boomer. He decides to put his cat to the test for eternity.
 * He starts on day 1 with one stash of food unit,
 * every next day, the stash doubles.
 * If Boomer is well-behaved during a particular day,
 * only then she receives food worth equal to the stash produced on that day.
 *
 * Boomer receives a net worth of A units of food.
 * What is the number of days she received the stash?
 *
 *
 * * Problem Constraints *
 * 1 <= A <= 231-1
 *
 * * Example Input *
 *
 * Input 1:
 * A = 5
 * Input 2:
 * A = 8
 *
 * * Example Output *
 * Output 1: 2
 * Output 2: 1
 *
 * * Example Explanation *
 *
 * * Explanation 1: *
 * To eat a total of 5 units of food, Boomer behaved normally on Day 1 and on the Day 3.
 *
 * * Explanation 2: *
 * To eat a total of 8 units of food, Boomer behaved normally only on day 4.
 *
 *
 *
 *
 * -----------------------------------------------------------------------------------------------
 * * Hint *
 * Can you try thinking of each day as bits of A and
 * -----------------------------------------------------------------------------------------------
 *
 *
 *
 *
 *
 */


package bit_manupulation;

public class Finding_Good_Days {

    public static int solve(int A) {
        int count = 0;
        while(A > 0) {
            count += (A & 1) == 1 ? 1 : 0;
            A >>= 1;
        }
        return count;
    }

    public static void main(String[] args) {
        int result = solve(5);
        if(result != 2) {
            throw new RuntimeException("Test Case doesn't Pass");
        }
        System.out.println(result);
    }

}
