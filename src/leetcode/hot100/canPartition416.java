package leetcode.hot100;

/**
 * @author ktx
 * @data 2022-06-25 15:30
 */
public class canPartition416 {

    public static void main(String[] args) {
        canPartition416 canPartition416 = new canPartition416();
        int[] arr = {1,5,11,5};
        boolean b = canPartition416.canPartition(arr);
        System.out.println(b);
    }
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0,maxNum = 0;
        if(n<2){
            return false;
        }

        for (int num : nums) {
            sum+=num;
            maxNum = Math.max(maxNum,num);
        }
        if(sum%2!=0){
            return false;
        }
        int target = sum/2;
        if(maxNum>target){
            return false;
        }
        boolean[][] dp = new boolean[n][target+1];
        for (int i = 0;i<n;i++){
            dp[i][0] = true;
        }
        dp[0][nums[0]] = true;
        for (int i = 1;i<n;i++){
            for (int j = 1;j<=target;j++){
                if(j>=nums[i]){
                    dp[i][j] = dp[i-1][j]|dp[i-1][j-nums[i]];
                }else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n-1][target];
    }
}
