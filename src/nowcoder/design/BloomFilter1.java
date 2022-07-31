package nowcoder.design;

import java.util.ArrayList;

/**
 * @ClassName BloomFilter
 * @Description redis布隆过滤器
 * @Author ktx
 * @Date 2022-07-30 21:17
 * @Version 1.0
 */
public class BloomFilter1 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param s1 string字符串ArrayList
     * @param s2 string字符串ArrayList
     * @param n int整型
     * @return int整型ArrayList
     */
    public ArrayList<Integer> BloomFilter (ArrayList<String> s1, ArrayList<String> s2, int n) {
        // write code here
        ArrayList<Integer> list = new ArrayList<>(s2.size());
        BloomFilter bloomFilter = new BloomFilter(n);
        for(String s: s1){
            bloomFilter.add(s);
        }
        for(String s: s2){
            list.add(bloomFilter.contains(s));
        }
        return list;
    }

    // 布隆过滤器
    class BloomFilter{
        //使用byte数组来实现bitmap，每一bit代表一个hash值
        //使用byte数组来实现bitmap，每一bit代表一个hash值
        private byte[] bitArray;

        private int[] modies;

        private int num;

        public BloomFilter(int num){
            this.num = num;
            //2501 byte * 8bit/byte = 20008bit > 20001 bit
            int lenth = 2501;
            bitArray = new byte[lenth];
            modies = new int[num];
            for(int i=0;i<num;i++){
                //每个hashcode取模后最大不会超过20001
                modies[i] = (int)(Math.random()*10001) + 10000;
            }
        }
        //hashcode计算
        private int hashCode(String s, int i){
            int hashCode = 0;
            int lenth = s.length();
            for(int index=0;index<lenth;index++){
                hashCode = (i * hashCode + s.charAt(index)) % modies[i-1];
            }
            return hashCode;
        }
        //通过按位 与 设置hashcode对应下标为true
        private void setIndex(int hashCode){
            int offset = hashCode%8;
            int index = hashCode/8;
            bitArray[index] = (byte)(bitArray[index] | (byte)1 << offset);
        }
        //获取对应下标bool值
        private int getBit(int hashCode){
            int offset = hashCode%8;
            int index = hashCode/8;
            return bitArray[index] >>> offset & 1;
        }
        //bitmap添加元素
        public void add(String s){
            for(int i=1;i<=num;i++){
                setIndex(hashCode(s,i));
            }
        }
        //判断是否可能含有字符串 s
        public int contains(String s){
            for(int i=1;i<=num;i++){
                if(getBit(hashCode(s,i)) == 0) return 0;
            }
            return 1;
        }
    }
}
