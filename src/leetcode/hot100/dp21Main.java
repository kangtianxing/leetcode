package leetcode.hot100;

import java.util.Scanner;

/**
 * @author ktx
 * @data 2022-07-01 22:04
 */
public class dp21Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String str=in.next();
        String pattern=in.next();
        System.out.println(match(str,pattern));
    }
    public static boolean match (String str, String pattern) {
        if(str==null||pattern==null){
            return false;
        }
        int m = str.length(),n =pattern.length();
        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;
        //"" 和p的匹配关系初始化，a*a*a*a*a*这种能够匹配空串，其他的是都是false。
        //  奇数位不管什么字符都是false，偶数位为* 时则: dp[0][i] = dp[0][i - 2]
        for (int i = 2;i<=n;i+=2){
            if(pattern.charAt(i-1)=='*'){
                dp[0][i] = dp[0][i-2];
            }
        }
        for (int i = 1;i<=m;i++){
            for (int j = 1;j<=n;j++){
                char sc = str.charAt(i-1);
                char pc = str.charAt(j-1);
                if(sc==pc|| pc=='.'){
                    dp[i][j] = dp[i-1][j-1];
                }else if(pc=='*'){
                    if(dp[i][j-2]){
                        dp[i][j] = true;
                    }else if(sc== pattern.charAt(j-2)||pattern.charAt(j-2)=='.'){
                        dp[i][j] = dp[i-1][j];
                    }
                }
            }
        }
        return dp[m][n];
    }
}
