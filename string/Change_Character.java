/**
 *
 * * Problem Description *
 * You are given a string A of size N consisting of lowercase alphabets.
 *
 * You can change at most B characters in the given string to any other
 * lowercase alphabet such that the number of distinct characters in the string is minimized.
 *
 * Find the minimum number of distinct characters in the resulting string.
 *
 * * Problem Constraints *
 * 1 <= N <= 100000
 *
 * 0 <= B <= N
 *
 * * Example Input *
 * A = "abcabbccd"
 * B = 3
 *
 * * Example Output *
 * 2
 *
 *
 * * Example Explanation *
 * We can change both 'a' and one 'd' into 'b'.So the new string becomes "bbcbbbccb".
 * So the minimum number of distinct character will be 2.
 *
 *
 *
 *
 * * Other Solution *
 *
 *     public int solve(String A, int B) {
 *         int cnt[] = new int[26];
 *         for(int i = 0; i < A.length(); ++i){
 *             ++cnt[A.charAt(i)-'a'];
 *         }
 *         ArrayList<Integer> C = new ArrayList<Integer>();
 *         for(int i = 0; i < 26; ++i){
 *             if(cnt[i] > 0){
 *                 C.add(cnt[i]);
 *             }
 *         }
 *         Collections.sort(C);
 *         for(int i = 0; i < C.size(); ++i){
 *             B -= C.get(i);
 *             if(B < 0){
 *                 return C.size() - i;
 *             }
 *         }
 *         return 1;
 *     }
 *
 */



package string;

import java.util.Arrays;

public class Change_Character {

    public static int solve(String A, int B) {
        if(A.length() == B) {
            return B;
        }
        int[] seq = new int[26];
        for(Character ch : A.toCharArray()) {
            int index = ch - 'a';
            seq[index] += 1;
        }
        Arrays.sort(seq);
        int count = 0;
        for(int temp : seq) {
            if(temp != 0 && temp <= B) {
                B -= temp;
            }
            else if(B <= 0 && temp != 0) {
                count++;
            }
            else if(temp != 0 && temp > B && B > 0) {
                count++;
            }
        }

        return count;
    }


    public static void main(String[] args) {
        int result = solve("abcabbccd", 3);
        System.out.println(result);
    }

}
