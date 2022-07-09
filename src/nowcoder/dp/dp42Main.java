package nowcoder.dp;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName dp42Main
 * @Description 完全背包问题
 * @Author ktx
 * @Date 2022-07-09 21:40
 * @Version 1.0
 */
public class dp42Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int V = sc.nextInt();
        //存放体积
        int[] v=new int[n+1];
        //存放价值
        int[] w=new int[n+1];
        for(int i=1;i<=n;i++){
            v[i]=sc.nextInt();
            w[i]=sc.nextInt();
        }

        //dp1[i]表示不考虑背包是否装满，在容量为i的情况下，最多装多大价值的物品
        int[] dp1=new int[V+1];
        for(int i=1;i<=n;i++){
            //由于每个物品只能用一次，为了防止重复计算，需要倒序遍历
            for(int j=v[i];j<=V;j++){
                //状态转移，要么选择第i件物品，要么不选，取价值最大的
                dp1[j]=Math.max(dp1[j-v[i]]+w[i],dp1[j]);
            }
        }

        System.out.println(dp1[V]);

        //dp2[i]表示背包恰好装满时，在容量为i的情况下，最多装多大价值的物品
        int[] dp2=new int[V+1];
        Arrays.fill(dp2,Integer.MIN_VALUE);
        //没有物品时，价值为0
        dp2[0]=0;
        for(int i=1;i<=n;i++){
            //由于每个物品只能用一次，为了防止重复计算，需要倒序遍历
            for(int j=v[i];j<=V;j++){
                //状态转移，要么选择第i件物品，要么不选，取价值最大的
                dp2[j]=Math.max(dp2[j-v[i]]+w[i],dp2[j]);
            }
        }
        //如果小于0，说明不能从初始状态转移过来，无解
        if(dp2[V]<0){
            dp2[V]=0;
        }
        System.out.println(dp2[V]);
    }
}
