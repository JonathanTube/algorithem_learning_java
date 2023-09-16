package educative.trie.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Trie {
    private TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    public int getIndex(char c) {
        return c - 'a';
    }

    public void insert(String key) {
        if(key == null || key.contains(" ") || key.length() == 0) return;
        String lowerKey = key.toLowerCase();
        TrieNode currentNode = root;

        for (int i = 0; i < lowerKey.length(); i++) {
            char c  = lowerKey.charAt(i);
            int index = getIndex(c);
            TrieNode trieNode = currentNode.trieNodes[index];
            if(trieNode == null) currentNode.trieNodes[index] = new TrieNode();
            currentNode = currentNode.trieNodes[index];
        }
        currentNode.isEndWord = true;
    }

    public String print(){
        StringBuilder sb = new StringBuilder();
        print(this.root, sb);
        return sb.toString();
    }
    public void print(TrieNode root,StringBuilder sb) {
        if (root == null) return;
        if(root.isEndWord) sb.append("#");
        for (int i = 0; i < 26; i++) {
            if (root.trieNodes[i] != null){
                sb.append((char)(i + 'a'));
            }
            print(root.trieNodes[i],sb);
        }
    }


    public boolean search(String key) {
        if(key == null || key.length() == 0 || key.contains(" ")) return false;
        String lowerKey = key.toLowerCase();
        TrieNode current = this.root;

        for(int i = 0; i < lowerKey.length(); i++) {
            if(current == null) return false;
            char c = lowerKey.charAt(i);
            int index = getIndex(c);
            current = current.trieNodes[index];
        }
        return current != null && current.isEndWord;
    }
}
