package leetcode.hot100;

import java.util.HashMap;

public class lenLongestFibSubseq {
    public int lenLongestFibSubseq(int[] arr){
        HashMap<Integer, Integer> indices = new HashMap<>();
        int n = arr.length;
        for (int i = 0;i<n;i++){
            indices.put(arr[i],i);
        }
        int[][] dp = new int[n][n];
        int ans = 0;
        for (int i = 0;i<n;i++){
            for (int j = i-1;j>=0&&arr[j]*2>arr[i];j--){
                int k = indices.getOrDefault(arr[i]-arr[j],-1);
                if(k>=0){
                    dp[j][i] = Math.max(dp[k][j]+1,3);
                }
                ans = Math.max(ans,dp[j][i]);
            }
        }
        return ans;
    }











}
