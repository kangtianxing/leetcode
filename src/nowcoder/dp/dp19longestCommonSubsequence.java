package nowcoder.dp;

import java.util.Scanner;

/**
 * @author ktx
 * @data 2022-06-29 22:08
 */
public class dp19longestCommonSubsequence {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();
        String str1 = scanner.nextLine();
        String str2 = scanner.nextLine();
        int result = getResultlongestCommonSubsequence(str1,str2);
        System.out.println(result);
    }

    private static int getResultlongestCommonSubsequence(String str1, String str2) {
        int n = str1.length(),m = str2.length();
        int[][] dp = new int[n+1][m+1];
        for (int i = 1;i<=n;i++){
            for (int j = 1;j<=m;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }
}
