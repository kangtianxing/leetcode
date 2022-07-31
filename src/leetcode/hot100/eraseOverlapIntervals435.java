package leetcode.hot100;

import java.util.Arrays;

/**
 * @ClassName eraseOverlapIntervals435
 * @Description TODO
 * @Author ktx
 * @Date 2022-07-30 22:19
 * @Version 1.0
 */
public class eraseOverlapIntervals435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length==0)return 0;
        Arrays.sort(intervals,(a,b)->(a[1]-b[1]));
        int count = 1;
        int x_end = intervals[0][1];
        for (int[] interval : intervals) {
            int start = interval[0];
            if(start>=x_end){
                count++;
                x_end = interval[1];
            }
        }
        return count;
    }
}
