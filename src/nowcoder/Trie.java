package nowcoder;

/**
 * @ClassName Trie
 * @Description TODO
 * @Author ktx
 * @Date 2022-07-23 12:41
 * @Version 1.0
 */
public class Trie {
    TrieNode root;// 根节点

    public Trie() {
        root = new TrieNode();// 构造字典树，就是先构造出一个空的根节点
    }

    //【向字典树插入单词word】
    // 思路：按照word的字符，从根节点开始，一直向下走：
    //如果遇到null，就new出新节点；如果节点已经存在，cur顺着往下走就可以
    public void insert(String word){
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            int c = word.charAt(i)-'a';
            if(cur.children[c]==null){
                cur.children[c] = new TrieNode();
            }
            cur = cur.children[c];
        }
        cur.isWord = true;
    }
    //【判断一个单词word是否完整存在于字典树中】
    // 思路：cur从根节点开始，按照word的字符一直尝试向下走：
    //          如果走到了null，说明这个word不是前缀树的任何一条路径，返回false;
    //          如果按照word顺利的走完，就要判断此时cur是否为单词尾端：如果是，返回true；如果不是，说明word仅仅是一个前缀，并不完整，返回false
    public boolean search(String word){
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            int c = word.charAt(i)-'a';
            if(cur.children[c]==null){
                return false;
            }
            cur = cur.children[c];
        }
        return cur.isWord;
    }
    //【判断一个单词word是否是字典树中的前缀】
    // 思路：和sesrch方法一样，根据word从根节点开始一直尝试向下走：
    //          如果遇到null了，说明这个word不是前缀树的任何一条路径，返回false;
    //          如果安全走完了，直接返回true就行了———我们并不关心此事cur是不是末尾(isWord)
    public boolean startsWith(String word) {
        TrieNode cur = root;

        for (int i = 0; i < word.length(); i++) {
            int c = word.charAt(i) - 'a';
            if (cur.children[c] == null) {
                return false;
            }
            cur = cur.children[c];
        }
        return true;
    }

}

class TrieNode{
    boolean isWord;
    TrieNode[] children = new TrieNode[26];

}
