package leetcode.hot100;

/**
 * @author ktx
 * @data 2022-07-08 14:52
 */
public class Trie {
    private Trie[] children;
    private boolean isEnd;
    public Trie() {
        children = new Trie[26];
        isEnd = false;
    }

    public void insert(String word) {
        Trie node = this;
        for (int i =0;i<word.length();i++){
            char ch = word.charAt(i);
            int index = ch-'a';
            if(node.children[index]==null){
                node.children[index] = new Trie();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        Trie node = searchPrefix(word);
        return node!=null&&node.isEnd;
    }

    public boolean startsWith(String prefix) {
        return searchPrefix(prefix)!=null;
    }
    private Trie searchPrefix(String pre){
        Trie node = this;
        for (int i = 0;i<pre.length();i++){
            char ch = pre.charAt(i);
            int index = ch-'a';
            if(node.children[index]==null){
                return null;
            }
            node = node.children[index];
        }
        return node;
    }
}
