package educative.trie.basic;

public class TestTrie {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("hello");
        trie.insert("helloWorld");
        System.out.println("===============");
        System.out.println(trie.print());
        System.out.println("===============");
        System.out.println(trie.search("hello"));
        System.out.println(trie.search("hell"));
        System.out.println(trie.search("hellou"));

//        System.out.println('b' - 'a');
//        char c = 1 + 'a';
//        String ss = "dd-" + (char)(1 + 'a');
//        System.out.println(ss);
    }
}
