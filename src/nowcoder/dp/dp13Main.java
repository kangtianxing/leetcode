package nowcoder.dp;

import java.util.Scanner;

/**
 * @author ktx
 * @data 2022-06-27 21:32
 */
public class dp13Main {
    public static void main(String []args){
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        int m=input.nextInt();
        int x=input.nextInt();
        int y=input.nextInt();
        long result = getResult(n,m,x,y);
        System.out.println(result);
    }
    public static long getResult(int n,int m,int x,int y){
        long[][] dp = new long[n+1][m+1];
        dp[0][0] = 1;
        for(int i = 1;i<=n;i++){
            dp[i][0] = (check(i,0,x,y)?0:dp[i-1][0]);
        }
        for(int j = 1;j<=m;j++){
            dp[0][j] = (check(0,j,x,y)?0:dp[0][j-1]);
        }
        for(int i =1;i<=n;i++){
            for(int j = 1;j<=m;j++){
                dp[i][j] = (check(i,j,x,y)?0:dp[i-1][j]+dp[i][j-1]);
            }
        }
        return dp[n][m];
    }
    public static boolean check(int i,int j ,int x,int y){
        return (Math.abs(i-x) + Math.abs(j-y) == 3 && i != x && j != y) || (i == x && j == y);
    }
}
