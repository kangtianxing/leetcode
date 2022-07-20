package leetcode.hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName MyCalendarTwo
 * @Description TODO
 * @Author ktx
 * @Date 2022-07-19 22:46
 * @Version 1.0
 */
public class MyCalendarTwo {
    List<int[]> booked;
    List<int[]> overlaps;

    public MyCalendarTwo() {
        booked = new ArrayList<int[]>();
        overlaps = new ArrayList<int[]>();
    }

    public boolean book(int start, int end) {
        for (int[] arr : overlaps) {
            int l = arr[0],r = arr[1];
            if(l<end && start<r){
                return false;
            }
        }
        for (int[] arr : booked) {
            int l = arr[0],r = arr[1];
            if(l<end && start<r){
                overlaps.add(new int[]{Math.max(l,start),Math.min(r,end)});
            }
        }
        booked.add(new int[]{start,end});
        return true;
    }

}
