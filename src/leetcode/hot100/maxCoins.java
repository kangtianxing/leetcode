package leetcode.hot100;

/**
 * @ClassName maxCoins
 * @Description TODO
 * @Author ktx
 * @Date 2022-07-19 23:36
 * @Version 1.0
 */
public class maxCoins {
    public int maxCoins(int[] nums) {
        int len = nums.length+2;
        int[] myNums = new int[len];
        myNums[0] = 1;
        myNums[len-1] = 1;
        for (int i = 1; i < len - 1; i++) {
            myNums[i] = nums[i - 1];
        }
        // dp[i][j]的含义：戳破从(i, j)开区间内的所有气球可以获得的最大金币数
        int[][] dp = new int[len][len];
        for(int j = 1;j<len;j++){
            for(int i = j-1;i>=0;i--){
                for(int k = i+1;k<j;k++){
                    dp[i][j] = Math.max(dp[i][j],dp[i][k]+myNums[i]*myNums[k]*myNums[j]+dp[k][j]);
                }
            }
        }
        return dp[0][len-1];
    }
}
