/**
 * Problem Description
 * Given a list of N words, find the shortest unique prefix to represent each word in the list.
 * <p>
 * NOTE: Assume that no word is the prefix of another. In other words, the representation is always possible
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= Sum of length of all words <= 106
 * <p>
 * <p>
 * <p>
 * Input Format
 * First and only argument is a string array of size N.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return a string array B where B[i] denotes the shortest unique prefix to represent the ith word.
 * <p>
 * <p>
 * <p>
 * * Example Input *
 * Input 1:
 * <p>
 * A = ["zebra", "dog", "duck", "dove"]
 * Input 2:
 * <p>
 * A = ["apple", "ball", "cat"]
 * <p>
 * <p>
 * * Example Output *
 * Output 1:
 * <p>
 * ["z", "dog", "du", "dov"]
 * Output 2:
 * <p>
 * ["a", "b", "c"]
 * <p>
 * <p>
 * * Example Explanation *
 * Explanation 1:
 * <p>
 * Shortest unique prefix of each word is:
 * For word "zebra", we can only use "z" as "z" is not any prefix of any other word given.
 * For word "dog", we have to use "dog" as "d" and "do" are prefixes of "dov".
 * For word "du", we have to use "du" as "d" is prefix of "dov" and "dog".
 * For word "dov", we have to use "dov" as "d" and do" are prefixes of "dog".
 * <p>
 * Explanation 2:
 * <p>
 * "a", "b" and c" are not prefixes of any other word. So, we can use of first letter of each to represent.
 */


package trie;

public class Shortest_Unique_Prefix {

    public static class Trie {  // trie class structure

        Trie[] child;
        int freq;

        Trie() {
            child = new Trie[26];
            freq = 1;
        }
    }

    public void Insert(String word, Trie root) {  // function to add string in trie;
        Trie temp = root;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            if (temp.child[ch - 'a'] != null) {   // if common for two or more char increase freq
                // eg. "dog", "duck" the d will have freq 2;

                temp.child[ch - 'a'].freq += 1;  // increasing freq if the path is common for other char

            } else {
                temp.child[ch - 'a'] = new Trie(); // if new char in path adding new path with freq set to 1;
            }

            temp = temp.child[ch - 'a']; // moving to new pointer;

        }

    }


    int check_prefix(Trie root, String word) { // function for cheking prefix using freq;
        Trie temp = root;
        int j = 1;
        char ch = word.charAt(0);      // first is root so freq will be as always
        temp = temp.child[ch - 'a'];  // start checking from next of root;

        while (temp.freq != 1) {        // loopin till the freg is 1 , i,e the path has no common character
            ch = word.charAt(j);
            temp = temp.child[ch - 'a'];
            j++;
        }
        return j;           // returning counter;
    }

    public String[] prefix(String[] A) {

        Trie root = new Trie();

        String[] ans = new String[A.length];
        for (int i = 0; i < A.length; i++) {    // loop for adding words in trie;
            Insert(A[i], root);              // calling insert func.
        }

        for (int i = 0; i < A.length; i++) {   // loop for checking the shortest prefix;

            int size = check_prefix(root, A[i]);    // calling check_prefix function to find the prefix.
            ans[i] = A[i].substring(0, size); // adding to ans  from starting of word to place where freq is 1;
        }


        return ans;
    }


    public static void main(String[] args) {

    }

}
