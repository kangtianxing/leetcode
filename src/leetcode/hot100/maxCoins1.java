package leetcode.hot100;

import java.util.Arrays;

/**
 * @ClassName maxCoins1
 * @Description TODO
 * @Author ktx
 * @Date 2022-07-27 12:43
 * @Version 1.0
 */
public class maxCoins1 {
    int[] newNum;
    public int maxCoins(int[] nums) {
        int len = nums.length+2;
        newNum = new int[len];
        newNum[0] =1;
        newNum[len-1] =1;
        for (int i = 1; i < len - 1; i++) {
            newNum[i] = nums[i-1];
        }
        res = new int[len][len];
        for(int i = 0; i < len; i++){
            Arrays.fill(res[i], -1);
        }
        return getCoins(0,len-1);
    }

    int[][] res;
    private int getCoins(int i, int j) {
        if(res[i][j]!=-1){
            return res[i][j];
        }
        int sum = 0;

        for (int k = i+1;k<j;k++){
            sum=Math.max(sum,getCoins(i,k)+newNum[i]*newNum[k]*newNum[j]+getCoins(k,j));
        }
        res[i][j] = sum;
        return sum;
    }

    public int maxCoins1(int[] nums) {
        int len = nums.length + 2;
        int[] newNums = new int[len];
        newNums[0] = 1;
        newNums[len - 1] = 1;
        for(int i = 1; i < len - 1; i++){
            newNums[i] = nums[i - 1];
        }
        int[][] dp =new int[len][len];
        for (int j = 1;j<len;j++){
            for (int i = j-1;i>=0;i--){
                for (int k = i+1;k<j;k++){
                    dp[i][j] = Math.max(dp[i][j],dp[i][k]+newNum[i]*newNum[k]*newNum[j]+dp[k][j]);
                }
            }
        }
        return dp[0][len-1];
    }
}
