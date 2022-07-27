package leetcode.hot100;

import javax.management.NotificationEmitter;
import java.util.Arrays;

/**
 * @ClassName Skiplist
 * @Description TODO
 * @Author ktx
 * @Date 2022-07-27 13:54
 * @Version 1.0
 */
public class Skiplist {
    private static final int MAX_LEVEL = 32;
    private static final double SKIPLIST_P = 0.25;
    private Node head;
    private int curLevel;

    public Skiplist() {
        this.head = new Node(-1,MAX_LEVEL);
        this.curLevel = 0;
    }
    public boolean search(int target){
        Node cur = this.head;
        for (int i = curLevel-1;i>=0;i--){
            while (cur.next[i]!=null && cur.next[i].val<target){
                cur = cur.next[i];
            }
        }
        cur = cur.next[0];
        return cur!=null &&cur.val==target;
    }
    public void add(int num){
        Node[] update = new Node[MAX_LEVEL];
        Arrays.fill(update,head);
        Node cur =this.head;
        for (int i = curLevel - 1; i >= 0; i--) {
            //找到所有层的前驱结点
            while (cur.next[i] != null && cur.next[i].val < num) {
                cur = cur.next[i];
            }
            update[i] = cur;
        }
        int randomLevel = randomLevel();
        this.curLevel = Math.max(this.curLevel,randomLevel);
        Node newNode = new Node(num, randomLevel);
        //插入随机出来的所有level
        for (int i = 0; i < randomLevel; i++) {
            newNode.next[i] = update[i].next[i];
            update[i].next[i] = newNode;
        }
    }
    public boolean erase(int num) {
        Node[] update = new Node[MAX_LEVEL];
        Node cur =this.head;
        for (int i = curLevel - 1; i >= 0; i--) {
            //找到第i层最大的小于target的元素
            while (cur.next[i] != null && cur.next[i].val < num) {
                cur = cur.next[i];
            }
            update[i] = cur;
        }
        cur = cur.next[0];
        //判断num是否存在
        if (cur == null || cur.val != num) {
            return false;
        }
        for (int i = 0; i < curLevel; i++) {
            if (update[i].next[i] != cur) {
                break;
            }
            //删除第i层的值和num相等的元素
            update[i].next[i] = cur.next[i];
        }
        //有可能最上层只有一个元素，缩短层数
        while (curLevel > 1 && head.next[curLevel - 1] == null) {
            curLevel--;
        }
        return true;
    }

    /**
     * 该 randomLevel 方法会随机生成 1~MAX_LEVEL 之间的数，且
     * 1/2 的概率返回 2
     * 1/4 的概率返回 3
     * 1/8 的概率返回 4 以此类推
     */
    private int randomLevel() {
        int level = 1;
        // 当 level < MAX_LEVEL，且随机数小于设定的晋升概率时，level + 1
        while (Math.random() < SKIPLIST_P && level < MAX_LEVEL) {
            level++;
        }
        return level;
    }

}

class Node {
    int val;
    Node[] next;

    public Node(int val, int maxLevel) {
        this.val = val;
        this.next = new Node[maxLevel];
    }
}