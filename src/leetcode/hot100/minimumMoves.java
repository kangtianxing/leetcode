package leetcode.hot100;

/**
 * @ClassName minimumMoves
 * @Description TODO
 * @Author ktx
 * @Date 2022-07-19 23:37
 * @Version 1.0
 */
public class minimumMoves {
    public int minimumMoves(int[] arr) {
        int len = arr.length;
        // dp[i][j]的含义是：删除从i到j的数字需要的最少删除次数
        int[][] dp = new int[len][len];
        // 初始化
        for (int i = 0; i < len; i++) {
            dp[i][i] = 1;
        }
        for (int i = 0; i < len - 1; i++) {
            dp[i][i + 1] = (arr[i] == arr[i + 1] ? 1 : 2);
        }
        // 动态规划
        for (int j = 2; j < len; j++) {
            for (int i = j - 2; i >= 0; i--) {
                if (arr[i] == arr[j]) {
                    dp[i][j] = dp[i + 1][j - 1];
                } else {
                    for (int k = i + 1; k < j; k++) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j]);
                    }
                }
            }
        }
        return dp[0][len - 1];
    }
}
