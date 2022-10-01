package base.test;

import java.util.TreeMap;

/**
 * @ClassName Trie
 * @Description TODO
 * @Author ktx
 * @Date 2022-09-18 11:44
 * @Version 1.0
 */
public class Trie {

    private class Node{

        public boolean isWord; // 是否是某个单词的结束

        public TreeMap<Character, Node> next; //到下一个节点的映射

        public Node(boolean isWord){
            this.isWord = isWord;
            //初始化字典树
            next = new TreeMap<>();
        }

        public Node(){
            this(false);
        }
    }

    //根节点
    private Node root;
    //Trie单词个数
    private int size;

    public Trie(){
        root = new Node();
        size = 0;
    }

    // 获得Trie中存储的单词数量
    public int getSize(){
        return size;
    }


    public void add(String word) {

        Node cur = root;
        //循环判断新的cur节点是否包含下一个字符到下一个节点的映射
        for (int i = 0; i < word.length(); i++) {
            //将c当成一个节点插入Trie中
            char c = word.charAt(i);
            //判断cur.next是不是已经指向我们要找的c字符相应的节点
            if (cur.next.get(c) == null) {
                //新建节点
                cur.next.put(c, new Node());
            }
            //否则，就直接走到该节点位置即可
            cur = cur.next.get(c);
        }
        //判断该单词并不表示任何一个单词的结尾
        if (!cur.isWord) {
            //确定cur是新的单词
            cur.isWord = true;
            size++;
        }
    }


    /**
     * 查询单词word是否在Trie中(非递归写法)
     *
     * @param word
     * @return
     */
    public boolean contains(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null) {
                return false;
            } else {
                cur = cur.next.get(c);
            }
        }
        return cur.isWord;
    }


    /**
     * 查询是否在Trie中有单词一prefix为前缀
     *
     * @param prefix
     * @return
     */
    public boolean isPrefix(String prefix) {
        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (cur.next.get(c) == null) {
                return false;
            }
            cur = cur.next.get(c);
        }
        return true;
    }

}
