package educative.trie.basic;

public class TrieNode {
    TrieNode[] trieNodes;
    boolean isEndWord;
    public TrieNode() {
        trieNodes = new TrieNode[26];
    }
}
