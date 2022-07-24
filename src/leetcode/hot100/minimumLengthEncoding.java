package leetcode.hot100;

import java.util.Arrays;

/**
 * @ClassName minimumLengthEncoding
 * @Description 单词的压缩
 * @Author ktx
 * @Date 2022-07-23 13:54
 * @Version 1.0
 */
public class minimumLengthEncoding {
 /*
    【字典树】——— 之所以想到使用字典树，是因为该题完全发挥了字符串的后缀特征

    我们构造出这样的一个[逆序]字典树，很容易发现： "编码"后的字符串长度，就是忽略了后缀单词后，所有单词的(长度+1)之和
    这不难理解，比如"abcd#","bcd","cd","d"这种后缀单词就默认被包括了，因而算整个字符串的长度时，算"abcd"这个最长的就行了

    核心思路是：每次往字典树插入一个"新的word"时，就 += 该word的长度 + 1(#)
    需要注意的是，不是每一次插入单词，都需要加上该单词的长度
    而是先根据长度对words进行一次排序，先插入长的，再插入短的。如果插入时需要new出新节点，我们就认为这是一个"新word"

    举几个例子：
        1. 先插"cba"，再插"dba" ———— 虽然后缀有重合，但是依旧需要new出新节点，认为是"新word",最终字符串只能为"cba#dba#"
        2. 先插"ba"，再插"dcba" ———— 两次插入都有new出新节点的行为，因此算多了，3+1 + 5+1 =8，实际为"dcba#"，为5
        3. 先插"dcba"，再插"ba" ———— 因为先插长的，第二次插入并没有出现new的行为，4+1 = 5，正确 ! ! !
     */
    public int minimumLengthEncoding(String[] words) {
        int resLen = 0;
        Arrays.sort(words,(s1,s2)->s2.length()-s1.length());
        Trie trie = new Trie();
        for(String word : words){
            resLen += trie.insert(word);
        }

        return resLen;
    }
    class TrieNode {
        boolean isWord;
        TrieNode[] children = new TrieNode[26];

        TrieNode() {
        }
    }
    class Trie{
        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }
        // 单词逆序插入字典树；插入的同时，还会判断插入的单词是不是"新的"，如果是新单词，返回其length+1；否则返回0
        public int insert(String word) {
            TrieNode cur =root;
            boolean isNew = false;
            for (int i = word.length() - 1; i >= 0; i--) {
                int c = word.charAt(i)-'a';
                if (cur.children[c]==null) {
                    cur.children[c] = new TrieNode();
                    isNew = true;
                }
                cur = cur.children[c];
            }
            cur.isWord = true;
            return isNew?word.length()+1:0;
        }

    }
}



