package nowcoder.dp;

import java.util.Scanner;

/**
 * @author ktx
 * @data 2022-06-27 21:34
 */
public class dp14LongestAscendingSubsequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0;i<n;i++){
            arr[i] = scanner.nextInt();
        }
        int result = longestAscendingSubsequence(n,arr);
        System.out.println(result);

    }

    private static int longestAscendingSubsequence(int n, int[] arr) {
        int[] dp = new int[n];  // 从i到j的最长递增子序列
        int maxLength = 1;
        for (int i = 0;i<n;i++){
            dp[i] = 1;
        }
        for (int i = 1;i<n;i++){
            for (int j = 0;j<i;j++){
                if(arr[i]>arr[j]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            maxLength = Math.max(maxLength,dp[i]);
        }
        return maxLength;
    }
}
