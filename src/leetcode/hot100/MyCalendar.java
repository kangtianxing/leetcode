package leetcode.hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ktx
 * @data 2022-07-05 22:03
 */
public class MyCalendar {

    List<int[]> path;

    public MyCalendar() {
        path = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        for (int[] arr : path) {
            int l = arr[0],r = arr[1];
            if(l<end&&start<r){
                return false;
            }
        }
        path.add(new int[]{start,end});
        return true;
    }

}



























