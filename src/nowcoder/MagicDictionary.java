package nowcoder;

/**
 * @ClassName MagicDictionary
 * @Description TODO
 * @Author ktx
 * @Date 2022-07-23 16:19
 * @Version 1.0
 */
public class MagicDictionary {
    class TrieNode{
        boolean isWord;
        TrieNode[] children = new TrieNode[26];
        public TrieNode() {}
    }
    TrieNode root;

    public MagicDictionary() {
        root = new TrieNode();
    }

    // 构建字典树的代码省略了
    public void buildDict(String[] dictionary) {
        for (String word : dictionary) {
            TrieNode cur = root;
            for (int i = 0; i < word.length(); i++) {
                int c = word.charAt(i) - 'a';
                if (cur.children[c] == null) {
                    cur.children[c] = new TrieNode();
                }
                cur = cur.children[c];
            }
            cur.isWord = true;

        }
    }


    public boolean search(String word) {
        return match(word, root, 0, true);
    }
    /*
     * 这个递归本身是极其简练、优美的 (两个if)
     */
    public boolean match(String word, TrieNode node, int start, boolean hasChance){
        if(start == word.length()){
            return node.isWord && !hasChance;		// 因为"必须变一个字符"，因此 "&& !hasChance"
        }
        for(int i = 0; i < 26; i++){
            if(node.children[i] != null){
                if(word.charAt(start)-'a' == i && match(word, node.children[i], start + 1, hasChance)){
                    return true;
                }
                if(word.charAt(start)-'a' != i && hasChance && match(word, node.children[i], start + 1, false)){
                    return true;
                }
            }
        }
        return false;
    }



}
