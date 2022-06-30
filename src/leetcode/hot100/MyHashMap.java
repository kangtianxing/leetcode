package leetcode.hot100;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author ktx
 * @data 2022-06-29 11:43
 */
public class MyHashMap {
    private class Pair{
        private int key;
        private int value;

        public Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

    private static final int BASE = 769;
    private LinkedList[] data;

    public MyHashMap() {
        data = new LinkedList[BASE];
        for (int i = 0;i<BASE;i++){
            data[i] = new LinkedList<Pair>();
        }
    }

    public void put(int key, int value) {
        int h = hash(key);
        Iterator<Pair> iterator = data[h].iterator();
        while (iterator.hasNext()){
            Pair element = iterator.next();
            if(element.getKey()==key){
                element.setValue(value);
                return;
            }
        }
        data[h].offerLast(new Pair(key,value));
    }

    public int get(int key) {
        int h = hash(key);
        Iterator<Pair> iterator = data[h].iterator();
        while (iterator.hasNext()){
            Pair element = iterator.next();
            if(element.getKey()==key){
                return element.getValue();
            }
        }
        return -1;
    }

    public void remove(int key) {
        int h = hash(key);
        Iterator<Pair> iterator = data[h].iterator();
        while (iterator.hasNext()){
            Pair element = iterator.next();
            if(element.getKey()==key){
                data[h].remove(element);
                return;
            }
        }
    }

    private int hash(int key) {
        return key%BASE;
    }
}
