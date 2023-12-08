/**
 *
 * Problem Description
 * Given an array of words A (dictionary) and another array B (which contain some words).
 *
 * You have to return the binary array (of length |B|) as the answer where 1 denotes that the
 * word is present in the dictionary and 0 denotes it is not present.
 *
 * Formally, for each word in B, you need to return 1 if it is present in Dictionary and 0 if not.
 *
 * Such problems can be seen in real life when we work on any online editor (like Google Documnet),
 * if the word is not valid it is underlined by a red line.
 *
 * NOTE: Try to do this in O(n) time complexity.
 *
 *
 *
 * Problem Constraints
 * 1 <= |A| <= 1000
 *
 * 1 <= sum of all strings in A <= 50000
 *
 * 1 <= |B| <= 1000
 *
 *
 *
 * Input Format
 * First argument is array of strings A.
 *
 * First argument is array of strings B.
 *
 *
 *
 * Output Format
 * Return the binary array of integers according to the given format.
 *
 *
 *
 * * Example Input *
 * Input 1:
 *
 * A = [ "hat", "cat", "rat" ]
 * B = [ "cat", "ball" ]
 * Input 2:
 *
 * A = [ "tape", "bcci" ]
 * B = [ "table", "cci" ]
 *
 *
 * * Example Output *
 * Output 1:
 *
 * [1, 0]
 * Output 2:
 *
 * [0, 0]
 *
 *
 * * Example Explanation *
 * Explanation 1:
 *
 * Only "cat" is present in the dictionary.
 * Explanation 2:
 *
 * None of the words are present in the dictionary.
 *
 *
 */

package trie;

import java.util.ArrayList;
import java.util.HashSet;

public class Spelling_Checker {
    public ArrayList<Integer> solve(ArrayList<String> A, ArrayList<String> B) {
        return trieApproach(A,B);
    }


    // Trie Approach
    private ArrayList<Integer> trieApproach(ArrayList<String> A, ArrayList<String> B) {

        TrieNode node = new TrieNode();
        TrieNode head = node;

        for(int i=0; i<A.size(); i++) {
            String str = A.get(i);
            TrieNode cur = node;
            for(int j=0; j<str.length(); j++) {
                int ch = str.charAt(j) - 'a';
                if(cur.child[ch] == null) {
                    cur.child[ch] = new TrieNode();
                    cur = cur.child[ch];
                }
                else {
                    cur = cur.child[ch];
                }
            }

            cur.isEnd = true;

        }

        ArrayList<Integer> result = new ArrayList<>();
        for(int i=0; i<B.size(); i++) {
            String str = B.get(i);
            TrieNode cur = head;
            int count = 0;
            for(int j=0; j<str.length(); j++) {
                int ch = str.charAt(j) - 'a';
                if(cur.child[ch] != null) {
                    cur = cur.child[ch];
                }
            }

            if(cur.isEnd) {
                result.add(1);
            }
            else {
                result.add(0);
            }
        }

        return result;
    }

    // HashSet   Approach
    public ArrayList<Integer> hashMapApproach(ArrayList<String> A, ArrayList<String> B) {
        HashSet<String> set = new HashSet<>();

        for(String s : A) {
            set.add(s);
        }

        ArrayList<Integer> result = new ArrayList<>();

        for(int i=0; i<B.size(); i++) {
            String temp = B.get(i);
            if(set.contains(temp)) {
                result.add(1);
            }
            else {
                result.add(0);
            }
        }

        return result;
    }
}
