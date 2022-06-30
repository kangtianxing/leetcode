package leetcode.hot100;

import base.design.bridge.Brand;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * 哈希集合有几个关键的数据结构
 * 哈希函数：能够将集合中任意可能的元素映射 到一个固定范围的整数值，并将该元素存储到整数值对应的地址上。
 * 冲突处理：由于不同元素可能的映射到相同的整数值，因此需要在出现冲突时，需要进行冲突处理
 *         处理方式：链地址法/开放地址法/再哈希法
 * 扩容：当元素过多时，冲突的概率将越来越大，而查询效率越来越低，因为需要开辟另一块更大空间，来缓解哈希表中的冲突
 * @author ktx
 * @data 2022-06-29 10:52
 */
public class MyHashSet {
    private static final int BASE = 769;
    private LinkedList[] data;

    public MyHashSet() {
        data = new LinkedList[BASE];
        for (int i = 0;i<BASE;i++){
            data[i] = new LinkedList<Integer>();
        }
    }

    public void add(int key) {
        int h = hash(key);
        Iterator<Integer> iterator = data[h].iterator();
        while (iterator.hasNext()){
            Integer element = iterator.next();
            if(element==key){
                return;
            }
        }
        data[h].offerLast(key);
    }

    public void remove(int key) {
        int h = hash(key);
        Iterator<Integer> iterator = data[h].iterator();
        while (iterator.hasNext()){
            Integer element = iterator.next();
            if(element==key){
                data[h].remove(element);
                return;
            }
        }
    }

    public boolean contains(int key) {
        int h = hash(key);
        Iterator<Integer> iterator = data[h].iterator();
        while (iterator.hasNext()){
            Integer element = iterator.next();
            if(element==key){
                return true;
            }
        }
        return false;
    }

    private int hash(int key) {
        return key%BASE;
    }
}
