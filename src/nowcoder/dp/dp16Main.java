package nowcoder.dp;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 两个dp
 * dp1 从左到右最长上升子序列
 * dp2 从右向左，最长下降子序列
 * @author ktx
 * @data 2022-06-28 17:44
 */
public class dp16Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0;i<n;i++){
            arr[i] = scanner.nextInt();
        }
        int result = getResult(n,arr);
        System.out.println(result);

    }

    private static int getResult(int n, int[] arr) {
        int[] dp = new int[n];
        int[] dp2 = new int[n];
        int res = Integer.MAX_VALUE;
        Arrays.fill(dp,1);
        Arrays.fill(dp2,1);
        for (int i =1;i<n;i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] >arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        for (int i = n-1;i>=0;i--){
            for (int j = n-1;j>i;j--){
                if(arr[i]>arr[j]){
                    dp2[i] = Math.max(dp2[i],dp2[j]+1);
                }
            }
        }
        for (int i = 0;i<n;i++){
            res = Math.min(res,n-(dp[i]+dp2[i])+1);
        }
        return res;
    }
}
//            333333333                    \\