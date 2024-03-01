/**
 *
 * Q3. Word Break
 * feature icon
 * Get your doubts resolved blazing fast with Chat GPT Help
 * Check Chat GPT
 * feature icon
 * Using hints is now penalty free
 * Use Hint
 * Given a string A and a dictionary of words B, determine if A can be segmented into a space-separated sequence of one or more dictionary words.
 *
 * Input Format:
 *
 * The first argument is a string, A.
 * The second argument is an array of strings, B.
 * Output Format:
 *
 * Return 0 / 1 ( 0 for false, 1 for true ) for this problem.
 * Constraints:
 *
 * 1 <= len(A) <= 6500
 * 1 <= len(B) <= 10000
 * 1 <= len(B[i]) <= 20
 * Examples:
 *
 * Input 1:
 *     A = "myinterviewtrainer",
 *     B = ["trainer", "my", "interview"]
 *
 * Output 1:
 *     1
 *
 * Explanation 1:
 *     Return 1 ( corresponding to true ) because "myinterviewtrainer" can be segmented as "my interview trainer".
 *
 * Input 2:
 *     A = "a"
 *     B = ["aaa"]
 *
 * Output 2:
 *     0
 *
 * Explanation 2:
 *     Return 0 ( corresponding to false ) because "a" cannot be segmented as "aaa".
 *
 *
 *
 */



package BackTracking;

import java.util.*;

public class Word_Break {

    public boolean wordBreak(String s, List<String> wordDict) {
        Boolean[] found = new Boolean[s.length()];
        return find(s, new HashSet<>(wordDict), 0, found);
    }

    // Without HashMap Solution with a boolean array
    boolean recWay2(String s, List<String> wordDict) {
        Boolean[] memo = new Boolean[s.length() + 1];
        return wordBreak2(s, new HashSet<>(wordDict), 0, memo);
    }

    boolean wordBreak2(String s, Set<String> wordDict, int k, Boolean[] memo) {
        int n = s.length();
        if (k == n) return true;

        if (memo[k] != null) return memo[k];

        for (int i=k + 1; i<=n; i++) {
            String word = s.substring(k, i);
            if (wordDict.contains(word) && wordBreak2(s, wordDict, i, memo)) {
                return memo[k] = true;
            }
        }

        return memo[k] = false;
    }

    private boolean find(String word, HashSet<String> set, int index, Boolean[] found) {
        if(index == word.length()) return true;
        if(found[index] != null) return found[index];
        for(int i=index+1; i<=word.length(); i++) {
            String left = word.substring(index, i);
            if(set.contains(left) && find(word, set, i, found)) {
                return found[index] = true;
            }
        }

        return found[index] = false;
    }

    // HashMap and HashSet Approach
    private boolean hashMapApproach(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>();
        HashMap<String, Boolean> map = new HashMap<>();

        for(String temp : wordDict) set.add(temp);

        return find(s, set, map);
    }

    private boolean find(String word, HashSet<String> set, HashMap<String, Boolean> map) {
        if(set.contains(word)) return true;
        if(map.containsKey(word)) map.get(word);

        for(int i=1; i<word.length(); i++) {
            String left = word.substring(0, i);
            String right = word.substring(i);
            if(set.contains(left) && find(right, set, map)) {
                map.put(word, true);
                return true;
            }
        }
        map.put(word, false);
        return false;
    }

}
