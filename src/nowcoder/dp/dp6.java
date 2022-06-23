package nowcoder.dp;

import java.util.Scanner;

/**
 * @author ktx
 * @data 2022-06-23 20:38
 */
public class dp6 {
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
    public static int getResult(int n,int[] arr){
        int[] dp = new int[n];
        dp[0] = arr[0];
        for(int i =1;i<n;i++){
            if(dp[i-1]<=0){
                dp[i] = arr[i];
            }else{
                dp[i] = dp[i-1]+arr[i];
            }
        }
        int maxResult = dp[0];
        for(int i = 1;i<n;i++){
            maxResult = Math.max(maxResult,dp[i]);
        }
        return maxResult;
    }
}
