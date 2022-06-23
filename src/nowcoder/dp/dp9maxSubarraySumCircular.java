package nowcoder.dp;

import java.util.Scanner;

/**
 *
 * 分两种情况，一种为没有跨越边界的情况，一种为跨越边界的情况
 * 没有跨越边界的情况直接求子数组的最大和即可；
 * 跨越边界的情况可以对数组求和再减去无环的子数组的最小和，即可得到跨越边界情况下的子数组最大和；
 * 求以上两种情况的大值即为结果，另外需要考虑全部为负数的情况
 * @author ktx
 * @data 2022-06-23 22:13
 */
public class dp9maxSubarraySumCircular {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0;i<n;i++){
            arr[i] = scanner.nextInt();
        }
        int result = getResult(n,arr);
        System.out.println(result);
    }
    public static int getResult(int n,int[] nums){
        int len = nums.length;
        int[] dp = new int[len];
        int max = nums[0];
        int sum = nums[0];
        dp[0] = nums[0];
        for(int i = 1;i<len;i++){
            dp[i] = Math.max(dp[i-1]+nums[i],nums[i]);
            if(dp[i]>max){
                max = dp[i];
            }
            sum+=nums[i];
        }
        int min = 0;
        for(int i =1;i<len-1;i++){
            dp[i] = nums[i]+Math.min(dp[i-1],0);
            if(dp[i]<min){
                min = dp[i];
            }
        }
        return Math.max(max,sum-min);
    }
}
