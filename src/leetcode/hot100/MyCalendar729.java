package leetcode.hot100;

import java.util.TreeMap;

/**
 * @author ktx
 * @data 2022-07-06 18:19
 */
public class MyCalendar729 {
    TreeMap<Integer,Integer> map;
    public MyCalendar729(){
        map = new TreeMap<>();
        map.put(-1,-1);
        map.put((int)1e9+1,(int)1e9+1);
    }
    public boolean book(int start,int end){
        Integer a = map.ceilingKey(start);  // 右边
        Integer b=map.floorKey(start);//左边
        if(a<end||map.get(b)>start){return false;}
        map.put(start,end);
        return true;
    }
}
