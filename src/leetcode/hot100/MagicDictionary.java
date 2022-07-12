package leetcode.hot100;

/**
 * @ClassName MagicDictionary
 * @Description TODO
 * @Author ktx
 * @Date 2022-07-11 17:10
 * @Version 1.0
 */
public class MagicDictionary {
    Trie1 root;
    public MagicDictionary() {
        root = new Trie1();
    }

    public void buildDict(String[] dictionary) {
        for (String word : dictionary) {
            Trie1 cur = root;
            for (int i = 0; i < word.length(); ++i) {
                char ch = word.charAt(i);
                int idx = ch - 'a';
                if (cur.child[idx] == null) {
                    cur.child[idx] = new Trie1();
                }
                cur = cur.child[idx];
            }
            cur.isFinished = true;
        }
    }

    public boolean search(String searchWord) {
        return dfs(searchWord, root, 0, false);
    }

    private boolean dfs(String searchWord, Trie1 node, int pos, boolean modified) {
        if (pos == searchWord.length()) {
            return modified && node.isFinished;
        }
        int idx = searchWord.charAt(pos) - 'a';
        if (node.child[idx] != null) {
            if (dfs(searchWord, node.child[idx], pos + 1, modified)) {
                return true;
            }
        }
        if (!modified) {
            for (int i = 0; i < 26; ++i) {
                if (i != idx && node.child[i] != null) {
                    if (dfs(searchWord, node.child[i], pos + 1, true)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

//    String[] dic;
//    public MagicDictionary() {
//
//    }
//
//    public void buildDict(String[] dictionary) {
//        dic = dictionary;
//    }
//
//    public boolean search(String searchWord) {
//        for (String d : dic) {
//            if (d.length()!=searchWord.length()) {
//                continue;
//            }
//            int diff = 0;
//            for (int i = 0;i<searchWord.length();i++){
//                if(searchWord.charAt(i)!=d.charAt(i)){
//                    diff++;
//                }
//            }
//            if(diff==1){
//                return true;
//            }
//        }
//        return false;
//    }
}
class Trie1 {
    boolean isFinished;
    Trie1[] child;

    public Trie1() {
        isFinished = false;
        child = new Trie1[26];
    }
}

