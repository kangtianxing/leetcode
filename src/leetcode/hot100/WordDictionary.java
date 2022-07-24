package leetcode.hot100;

/**
 * @ClassName WordDictionary
 * @Description 添加与搜索单词
 * @Author ktx
 * @Date 2022-07-23 15:56
 * @Version 1.0
 */
public class WordDictionary {

    public class TrieNode{
        boolean isWordEnd;
        TrieNode[] children = new TrieNode[26];
    }

    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            int c = word.charAt(i)-'a';
            if(cur.children[c]==null){
                cur.children[c] = new TrieNode();
            }
            cur = cur.children[c];
        }
        cur.isWordEnd = true;
    }

    public boolean search(String word) {
        return match(word,root,0);
    }

    private boolean match(String word, TrieNode node, int start) {
        if(start==word.length()){
            return node.isWordEnd;
        }
        if (word.charAt(start)!='.') {
            int c = word.charAt(start)-'a';
            return node.children[c]!=null&&match(word,node.children[c],start+1 );
        }else {
            for (int i = 0; i < 26; i++) {
                if(node.children[i]!=null &&match(word,node.children[i],start+1 )){
                    return true;
                }
            }
        }
        return false;
    }


}
