package leetcode.hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Solution_17_13_2
 * @Description TODO
 * @Author ktx
 * @Date 2022-07-23 15:49
 * @Version 1.0
 */
public class Solution_17_13_2 {
/*
    【动态规划 + 字典树】

    我们发现，在给dp[i]填值时，需要切割出所有以 i-1 处字符为结尾的子串———这导致了O(n²)的复杂度
    但实际上，当某个后缀已经不存在时，就没有再继续切割的必要了
    比如"abcdef"，给dp[4]填值时("前4个字符的最少未被匹配字符数")，发现已经不存在以"cd"为后缀的word，那么就不用继续切割出"bcd"，"abcd"了

    因此我们使用【字典树】，对这一点进行优化————
    不是切割出所有子串然后判断，而是根据字典树从i-1处的字符开始，尝试扩大这个后缀串，并返回所有可能作为word开头的坐标；直接根据找的坐标更新dp
     */

    public boolean search(String word) {
        TrieNode root=null;
        return match(word, root, 0);
    }

    /* macth方法
    // 基本思路是：根据word和start得到此时的字符，然后看该字符是否与此时的节点node配对————即node.children[c]有值(!=null)
    // (其实start就相当于非递归写法中的for(i)的i)，用来遍历word
    */
    public boolean match(String word, TrieNode node, int start){		// 这个三个参数直接背下来，这是模板参数
        if(start == word.length()){
            return node.isWord;					// (★)
        }

        int c = word.charAt(start) - 'a';
        return node.children[c] != null && match(word, node.children[c], start + 1);
    }
    public int respace(String[] dictionary, String sentence) {
        int len = sentence.length();
        int[] dp = new int[len + 1];

        Trie trie = new Trie();
        for(String word : dictionary){
            trie.insert(word);
        }

        // 动态规划
        for(int i = 1; i <= len; i++){
            dp[i] = dp[i - 1] + 1;
            for(int j : trie.search(sentence, i - 1)){  // 前i个字符，结尾单词的下标是 i - 1
                dp[i] = Math.min(dp[i], dp[j]);
            }
        }
        return dp[len];
    }
    class TrieNode{
        boolean isWord;
        TrieNode[] children = new TrieNode[26];
        public TrieNode() {}
    }

    class Trie{
        TrieNode root;      // 根节点

        public Trie(){
            root = new TrieNode();
        }

        // 单词word插入字典树(逆序) 【模板】
        public void insert(String word){
            TrieNode cur = root;

            for(int i = word.length() - 1; i >= 0; i--){
                int c = word.charAt(i) - 'a';
                if(cur.children[c] == null){
                    cur.children[c] = new TrieNode();
                }
                cur = cur.children[c];
            }
            cur.isWord = true;
        }

        // 找到 sentence 中以 sentence[end] 为结尾的单词(可能不止一个)，返回这些单词的开头下标 【★关键】
        public List<Integer> search(String sentence, int end){
            List<Integer> resList = new ArrayList<>();
            TrieNode cur = root;

            for(int i = end; i >= 0; i--){
                int c = sentence.charAt(i) - 'a';
                if(cur.children[c] == null){        // 从结尾处开始，一直尝试向前找，如果发现后缀已经不合法，直接终止
                    break;                          // 这两行就是字典树对原算法的优化
                }
                cur = cur.children[c];
                if(cur.isWord){
                    resList.add(i);
                }
            }
            return resList;
        }
    }

}
