package trie;

public class TrieNode {
    TrieNode[] child;
    boolean isEnd;
    TrieNode() {
        child = new TrieNode[26];
        isEnd = false;
    }
}
