package nowcoder;

import java.util.Scanner;

/**
 * @author ktx
 * @data 2022-06-19 12:20
 */
public class longestCommonSubsequenceAB38 {
    public static void main(String[] args){
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int m = scanner.nextInt();
//        String str1 = scanner.nextLine();
//        String str2 = scanner.nextLine();
        String str1 = "abcde";
        String str2 = "bdcaaa";
        int result = getResult(str1,str2);
        System.out.println(result);
    }
    public static int getResult(String str1,String str2){
        int n = str1.length();
        int m = str2.length();
        int[][] dp = new int[n+1][m+1];
        for(int i = 1;i<=n;i++){
            for(int j = 1;j<=m;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],Math.max(dp[i-1][j-1],dp[i][j-1]));
                }
            }
        }
        return dp[n][m];
    }
}
