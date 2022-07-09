package leetcode.hot100;

import java.util.Arrays;
import java.util.Scanner;
/*
* dp[i][j]表示前i个物品，背包容量为j的最大价值
* */
public class dp41Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();  // n种物品
        int V = sc.nextInt(); // V 体积为V
        //存放体积
        int[] v=new int[n+1];
        //存放价值
        int[] w=new int[n+1];
        for(int i=1;i<=n;i++){
            v[i]=sc.nextInt();
            w[i]=sc.nextInt();
        }
        int[] dp1 = new int[V+1];
        for (int i=1;i<=n;i++){
            for (int j = V;j>=v[i];j--){
                dp1[j] =Math.max(dp1[j],dp1[j-v[i]]+w[i]);
            }
        }
        System.out.println(dp1[V]);
        int[] dp2 = new int[V+1];
        Arrays.fill(dp2,Integer.MIN_VALUE);
        dp2[0] = 0;
        for (int i = 1;i<=n;i++){
            for (int j =V;j>=v[i];j--){
                dp2[j] = Math.max(dp2[j],dp2[j-v[i]]+w[i]);
            }
        }
        if(dp2[V]<0){
            dp2[V]=0;
        }
        System.out.println(dp2[V]);
    }
}
