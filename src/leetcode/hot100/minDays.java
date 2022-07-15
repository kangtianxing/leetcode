package leetcode.hot100;

import java.util.Arrays;

/**
 * @ClassName minDays
 * @Description 【题目描述】
 * 给你一个整数数组 bloomDay，以及两个整数 m 和 k 。
 * 现需要制作 m 束花。制作花束时，需要使用花园中 相邻的 k 朵花 。
 * 花园中有 n 朵花，第 i 朵花会在 bloomDay[i] 时盛开，恰好可以用于一束花中。
 * 请你返回从花园中摘 m 束花需要等待的最少的天数。如果不能摘到 m 束花则返回 -1 。
 * 【测试用例】
 * 输入：bloomDay = [1,10,3,10,2], m = 3, k = 1
 * 输出：3
 * 输入：bloomDay = [1,10,3,10,2], m = 3, k = 2
 * 输出：-1
 * 输入：bloomDay = [7,7,7,7,12,7,7], m = 2, k = 3
 * 输出：12
 * 输入：bloomDay = [1000000000,1000000000], m = 1, k = 1
 * 输出：1000000000
 * 输入：bloomDay = [1,10,2,9,3,8,4,7,5,6], m = 4, k = 2
 * 输出：9
 * @Author ktx
 * @Date 2022-07-15 21:18
 * @Version 1.0
 */
public class minDays {

    public int findMin(int[] bloomDay,int m,int k ){
        int left = 1;
        int right = Arrays.stream(bloomDay).max().getAsInt();
        int mid;
        while (left<right){
            mid = left+(right-left)/2;
            if(countM(bloomDay,k,mid)<m){
               left = mid+1;
            }else {
                right = mid;
            }
        }
        return countM(bloomDay,k,left)>=m?left:-1;
    }
    // 贪心--如果一天的天数为mid，可以做几朵花
    private int countM(int[] bloomDay, int k, int mid) {
        int count = 0;
        int len = 0;
        for (int i = 0;i<bloomDay.length;i++){
            if(bloomDay[i]<=mid){
                len++;
                if(len==k){
                    count++;
                    len=0;
                }
            }else {
                len = 0;
            }
        }
        return count;
    }


}
