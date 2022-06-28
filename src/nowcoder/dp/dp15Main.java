package nowcoder.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Dilworth定理 最少的下降序列个数就等于整个序列最长上升子序列的长度
 * @author ktx
 * @data 2022-06-27 22:02
 */
public class dp15Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0;i<n;i++){
            arr[i] = scanner.nextInt();
        }
        int[] result = getResult(n,arr);
        System.out.println(result[0]);
        System.out.println(result[1]);

    }

    private static int[] getResult(int n, int[] arr) {
        int[] dp = new int[n];
        int[] dp2 = new int[n];
        int[] res = new int[2];
        res[0] = 1;
        res[1] = 0;
        Arrays.fill(dp,1);
        Arrays.fill(dp2,1);
        for (int i =1;i<n;i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] <= arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                } else {
                    dp2[i] = Math.max(dp2[i], dp2[j] + 1);
                }
            }
            res[0] = Math.max(res[0], dp[i]);
            res[1] = Math.max(res[1], dp2[i]);
        }
        return res;
    }
}
