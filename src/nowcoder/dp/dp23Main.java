package nowcoder.dp;

import java.util.Scanner;

/**
 * @author ktx
 * @data 2022-07-02 21:27
 */
public class dp23Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0;i<n;i++){
            arr[i] = scanner.nextInt();
        }
        int result=getMaxSum(arr);
    }

    private static int getMaxSum(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        dp[0] = arr[0];
        dp[1] = Math.max(arr[0],arr[1]);
        if(n<=2){
            return dp[1];
        }
        for (int i = 2;i<n;i++){
            dp[i] = Math.max(dp[i-1],dp[i-2]+arr[i]);
        }
        return dp[n-1];
    }
}
