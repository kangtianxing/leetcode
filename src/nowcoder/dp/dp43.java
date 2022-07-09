package nowcoder.dp;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName dp43
 * @Description 最少的完全平方数
 * @Author ktx
 * @Date 2022-07-09 22:09
 * @Version 1.0
 */
public class dp43 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] dp = new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        dp[1] = 1;
        for (int i =2;i<=n;i++){
            for (int j = 1;j*j<=i;j++){
                dp[i] = Math.min(dp[i],dp[i-j*j]+1 );
            }
        }
        System.out.println(dp[n]);
    }
}
