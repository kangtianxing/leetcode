package leetcode.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ktx
 * @data 2022-07-04 20:00
 */
public class minimumAbsDifference1200 {

    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> res = new ArrayList<>();
        int minsub = Math.abs(arr[1]-arr[0]);
        int cursub = minsub;
        ArrayList<Integer> path = new ArrayList<>();
        path.add(arr[0]);
        path.add(arr[1]);
        res.add(path);
        for (int i =2;i<arr.length;i++){
            cursub = arr[i]-arr[i-1];
            if(cursub<minsub){
                res.clear();
                path = new ArrayList<>();
                path.add(arr[i-1]);
                path.add(arr[i]);
                res.add(path);
                minsub = cursub;
            }else if(cursub==minsub){
                path = new ArrayList<>();
                path.add(arr[i-1]);
                path.add(arr[i]);
                res.add(path);
            }
        }
        return res;
    }
}
