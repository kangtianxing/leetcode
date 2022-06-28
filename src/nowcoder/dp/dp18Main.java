package nowcoder.dp;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author ktx
 * @data 2022-06-28 20:57
 */
public class dp18Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] matrix =new int[n][m];
        for (int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                matrix[i][j] = scanner.nextInt();
            }
        }
        int maxResult =0;
        int[][] dp = new int[n][m];
        for (int i = 0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        for (int i = 0;i<n;i++){
            for (int j = 0;j<m;j++){
                maxResult = Math.max(maxResult,dp(i,j,matrix,dp));
            }
        }
        System.out.println(maxResult);
    }
    static int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
    private static int dp(int i, int j, int[][] matrix,int[][] dp) {
        int dv = dp[i][j];
        if(dv!=-1){
            return dv;
        }
        int v = 1;
        for (int k = 0;k<4;k++){
            int a =i+dir[k][0];
            int b =j+dir[k][1];
            if(a>=0&&b>=0&&a<matrix.length&&b<matrix[0].length&&matrix[a][b]<matrix[i][j]){
                v = Math.max(v,dp(a,b,matrix,dp)+1);
            }
        }
        dp[i][j] = v;
        return v;

    }
}
