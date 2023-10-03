/**
 *
 * Problem Statement
 * <>
 *     Given a string s, reverse the order of characters
 *     in each word within a sentence while still preserving
 *     whitespace and initial word order.
 * </>
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 5 * 10^4
 * s contains printable ASCII characters.
 * s does not contain any leading or trailing spaces.
 * There is at least one word in s.
 * All the words in s are separated by a single space.
 *
 *
 * Example 1:
 *
 * Input: s = "Let's take LeetCode contest"
 * Output: "s'teL ekat edoCteeL tsetnoc"
 * Example 2:
 *
 * Input: s = "God Ding"
 * Output: "doG gniD"
 *
 *
 */


package string;

public class Reverse_Words_in_a_String_III {

    // Without Split Operator
    public String reverseWords(String s) {
        StringBuilder answer =  new StringBuilder();
        StringBuilder tempStore = new StringBuilder();
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == ' ') {
                tempStore.reverse();
                answer.append(tempStore + " ");
                tempStore = new StringBuilder();
            }
            else {
                tempStore.append(s.charAt(i));
            }
        }

        tempStore.reverse();
        answer.append(tempStore);

        return answer.toString();
    }
    // With Split operator
    public String reverseStringWithSplit(String s) {
        String[] store = s.split(" ");
        StringBuilder answer = new StringBuilder();
        for(int i=0; i<store.length; i++) {
            StringBuilder sb = new StringBuilder(store[i]);
            sb.reverse();
            if(store.length-1 != i) {
                answer.append(sb + " ");
            }else {
                answer.append(sb);
            }
        }
        return answer.toString();
    }


    public static void main(String[] args) {

    }

}
