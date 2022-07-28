package leetcode.hot100;

/**
 * @ClassName maxProfit
 * @Description TODO
 * @Author ktx
 * @Date 2022-07-28 21:15
 * @Version 1.0
 */
public class maxProfit {
    // 不限制购买次数
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int[][] dp = new int[len][2];
        // 初始化
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        // 状态转移
        for(int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[len - 1][0];
    }
    // 只能购买一次
    public int maxProfit1(int[] prices) {
        int len = prices.length;
        int[][] dp = new int[len][2];
        // 初始化
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        // 状态转移
        for(int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }
        return dp[len - 1][0];
    }
    // 限制两次
    /*
    * 由于买卖次数的限制，一共有5种状态：
dp[i][0]的状态是 什么都不做（固定为0）
dp[i][1]的状态是 第1次持股
dp[i][2]的状态是 第1次不持股
dp[i][3]的状态是 第2次持股
dp[i][4]的状态是 第2次不持股

这时的状态转移也不是第一个例题那样的两个状态双向转化，而是一个单向的过程
    * */
    public int maxProfit2(int[] prices) {
        int len = prices.length;
        int[][] dp = new int[len][5];
        // 初始化
        dp[0][1] = -prices[0];
        dp[0][3] = -prices[0];
        // 状态转移
        for(int i = 1; i < len; i++) {
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] + prices[i]);
            dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] - prices[i]);
            dp[i][4] = Math.max(dp[i - 1][4], dp[i - 1][3] + prices[i]);
        }
        return dp[len - 1][4];
    }
    // 限制k次买卖
    //dp[i][j][1]的含义是：处于第i天，第j次交易，持股的状态
    //dp[i][j][0]的含义是：处于第i天，第j次交易，不持股的状态
    public int maxProfit3(int k, int[] prices) {
        int len = prices.length;
        int[][][] dp = new int[len][k + 1][2];
        // 初始化
        for(int j = 1; j < k + 1; j++) {
            dp[0][j][0] = 0;
            dp[0][j][1] = -prices[0];
        }
        // 状态转移
        for(int i = 1; i < len; i++) {
            for(int j = 1; j < k + 1; j++) {
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
            }
        }
        return dp[len - 1][k][0];
    }
    // 收手续费
    public int maxProfit(int[] prices, int fee) {
        int len = prices.length;
        int[][] dp = new int[len][2];
        // 初始化
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        // 状态转移
        for(int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[len - 1][0];
    }
    // 含冷冻期
    public int maxProfit4(int[] prices) {
        int len = prices.length;
        int[][] dp = new int[len][3];
        // 初始化
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[0][2] = 0;
        // 状态转移
        for(int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            dp[i][2] = dp[i - 1][1] + prices[i];
        }
        return Math.max(dp[len - 1][0], dp[len - 1][2]);
    }


}
