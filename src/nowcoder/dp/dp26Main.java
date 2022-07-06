package nowcoder.dp;

import java.util.Scanner;

/**
 * @author ktx
 * @data 2022-07-06 19:44
 */
public class dp26Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0;i<n;i++){
            arr[i] = scanner.nextInt();
        }
        boolean result = getResult(arr);
        System.out.println(result);

    }
    // 方法一：保存布尔型dp数组表示该格子能否到达
    private static boolean getResult(int[] nums) {
        int length = nums.length;
        boolean[] dp = new boolean[length];
        dp[0] = true;

        for(int i =0;i<length;i++){
            if(dp[i] == true){
                for(int j = i+1;j<=nums[i]+i;j++){
                    if(j<length){
                        dp[j] = true;
                    }
                }
            }else{
                break;
            }
        }
        return dp[length-1];
    }
    private static boolean getResult1(int[] nums){
        int dp = nums[0];
        for (int i =1;i<nums.length&&i<=dp;i++){
            dp = Math.max(dp,nums[i]+i);
        }
        return dp>=nums.length-1;
    }

}
