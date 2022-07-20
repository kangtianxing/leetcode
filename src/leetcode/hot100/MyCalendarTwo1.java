package leetcode.hot100;

import java.util.TreeMap;

/**
 * @ClassName MyCalendarTwo1
 * @Description TODO
 * @Author ktx
 * @Date 2022-07-19 23:00
 * @Version 1.0
 */
public class MyCalendarTwo1 {
    TreeMap<Integer,Integer> map;
    public MyCalendarTwo1() {
        map=new TreeMap<>();
    }

    public boolean book(int start,int end){
        map.put(start,map.getOrDefault(start,0)+1);
        map.put(end,map.getOrDefault(end,0)-1);
        int count = 0;
        for (Integer a : map.keySet()) {
            count+=map.get(a);
            if(count==3){
                map.put(start,map.get(start)-1);
                map.put(end,map.get(end)+1);
                return false;
            }
        }
        return true;
    }
}
