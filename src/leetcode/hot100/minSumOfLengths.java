package leetcode.hot100;

import java.util.Arrays;

/**
 * @ClassName minSumOfLengths
 * @Description TODO
 * @Author ktx
 * @Date 2022-09-13 17:38
 * @Version 1.0
 */
public class minSumOfLengths {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int[] dp =new int[n];
        Arrays.fill(dp,Integer.MAX_VALUE/2);

        int ans = Integer.MAX_VALUE;
        for (int i = 0,j = 0,sum = 0;j<n;j++){
            sum+=arr[j];
            while (i<=j&&sum>target){
                sum-=arr[i++];
            }
            if(sum==target){
                dp[j] = j-i+1;
                if(i!=0){
                    ans  = Math.min(ans,dp[i-1]+j-i+1);
                }
            }
            if(j!=0){
                dp[j] = Math.min(dp[j],dp[j-1]);
            }
        }
        return ans>arr.length?-1:ans;
    }
}
