package nowcoder.dp;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName stonedp
 * @Description 每堆石子有一定的质量，可以用一个整数来描述，现在要将这 N堆石子合并成为一堆。
 * 每次只能合并相邻的两堆，合并的代价为这两堆石子的质量之和，合并后与这两堆石子相邻的石子将和新堆相邻，
 * 合并时由于选择的顺序不同，合并的总代价也不相同。
 * 使得总的代价最小
 * 状态表示：f(i,j)表示从i到j中合并方法的集合 集合中的min
 * @Author ktx
 * @Date 2022-07-12 21:35
 * @Version 1.0
 */
public class stonedp {

    static int max = 0x3f3f3f3f;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            //石子数组
            int[] num = new int[n+1];
            //石子堆数组
            int[] sum = new int[n+1];
            //记忆化数组,用来记录总的代价
            int[][] dp = new int[n+1][n+1];
            // dp数组初始化
            for (int i = 0;i<=n;i++){
                Arrays.fill(dp[i],max);
            }
            sum[0] = 0;
            for (int i =1;i<=n;i++){
                num[i] = scanner.nextInt();
                sum[i] = sum[i-1]+num[i];
                dp[i][i] = 0;
            }
            // 第一层len代表区间长度
            for (int len = 1;len<n;len++){
                // 第二层区间i代表开头
                for (int i = 1;i+len<=n;i++){
                    int j = i+len;
                    // 第三层k代表区间分割的位置
                    for (int k = i;k<j;k++){
                        dp[i][j] = Math.min(dp[i][j],dp[i][k]+dp[k+1][j]+sum[j]-sum[i-1]);
                    }
                }
            }
            // 即表示1-n石子的最小代价
            System.out.println(dp[1][n]);

        }


    }
}
