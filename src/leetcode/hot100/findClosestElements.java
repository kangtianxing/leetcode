package leetcode.hot100;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName findClosestElements
 * @Description TODO
 * @Author ktx
 * @Date 2022-08-25 9:59
 * @Version 1.0
 */
public class findClosestElements {
    // 按照规则排序
    public List<Integer> findClosestElements(int[] arr, int k, int x){
        List<Integer> list = new ArrayList<>();
        for (Integer num : list) {
            list.add(num);
        }
        Collections.sort(list,(a,b)->{
            if(Math.abs(a-x)!=Math.abs(b-x)){
                return Math.abs(a - x) - Math.abs(b - x);
            }else {
                return a-b;
            }
        });
        List<Integer> ans = list.subList(0,k);
        Collections.sort(ans);
        return ans;
    }
    // 二分查找+双指针
    public List<Integer> findClosestElements1(int[] arr, int k, int x){
        int right = binarySearch(arr,x);
        int left = right-1;
        while (k-->0){
            if(left<0){
                right++;
            }else if(right>=arr.length){
                left--;
            }else if(x-arr[left]<=arr[right]-x){
                left--;
            }else {
                right++;
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = left+1;i<right;i++){
            ans.add(arr[i]);
        }
        return ans;
    }

    private int binarySearch(int[] arr, int x) {
        int l = 0,h = arr.length-1;
        while (l<h){
            int m = l+(h-l)/2;
            if(arr[m]>=x){
                h = m;
            }else {
                l = m+1;
            }
        }
        return l;
    }
}
