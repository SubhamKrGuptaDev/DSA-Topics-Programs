/**
 *
 * Problem Description
 * Given two binary strings A and B. Return their sum (also a binary string).
 *
 *
 * Problem Constraints
 * 1 <= length of A <= 10^5
 *
 * 1 <= length of B <= 10^5
 *
 * A and B are binary strings
 *
 *
 * * Example Input *
 * Input 1:
 * A = "100"
 * B = "11"
 * Input 2:
 * A = "110"
 * B = "10"
 *
 *
 * * Example Output *
 * Output 1:
 * "111"
 * Output 2:
 * "1000"
 *
 *
 * Example Explanation
 * For Input 1:
 * The sum of 100 and 11 is 111.
 * For Input 2:
 *
 * The sum of 110 and 10 is 1000.
 *
 *
 */


package string;

public class Add_Binary_Strings {

    public String addBinary(String A, String B) {
        int i = A.length() - 1;
        int j = B.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        /**
         * we are add value from last and if value come more than 2 than we just add carry
         * 3 / 2 = 1 and 2 / 2 = 1
         * if 1 / 2 = 0
         * 0101101 -> A
         *     011 -> B
         * 0110000 -> ans
         *
         */
        while(i >= 0 && j >= 0) {

            int num1 = A.charAt(i) - '0';
            int num2 = B.charAt(j) - '0';
            int temp = num1 + num2 + carry;

            sb.append(temp % 2);
            carry = temp / 2;

            i--;
            j--;
        }
        /**
         * after B complete loop will be ended but A is not completed
         * so this section need to be added
         */
        while(i >= 0) {
            int temp = A.charAt(i) - '0';
            temp += carry;
            sb.append(temp % 2);
            carry = temp / 2;
            i--;
        }
        /**
         * if B length longer then A,
         * this section will be handled
         */
        while(j >= 0) {
            int temp = B.charAt(j) - '0';
            temp += carry;
            sb.append(temp % 2);
            carry = temp / 2;
            j--;
        }
        /**
         * if carry still we have then this section will be handled
         * example:
         * 1111 -> A
         *    1 -> B
         * 10000 -> Ans
         */
        if(carry != 0) {
            sb.append(carry);
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {

    }

}
