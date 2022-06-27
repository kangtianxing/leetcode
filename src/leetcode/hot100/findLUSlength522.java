package leetcode.hot100;

import java.util.Arrays;

/**
 * @author ktx
 * @data 2022-06-27 9:39
 */
public class findLUSlength522 {

    public int findLUSlength(String[] strs) {
        int length = strs.length;
        int maxLength = -1;
        for (int i = 0;i<length;i++){
            if(strs[i].length()<=maxLength)continue;
            boolean ok = true;
            for (int j = 0;j<length;j++){
                if(i==j)continue;
                if(isSub(strs[i],strs[j]))ok = false;
            }
            if(ok) maxLength = Math.max(maxLength,strs[i].length());
        }
        return maxLength;
    }

    private boolean isSub(String str1, String str2) {
        int m = str1.length(),n = str2.length();
        int[][] dp = new int[m+1][n+1];
        for (int i = 1;i<=m;i++){
            for (int j = 1;j<=n;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
                if(dp[i][j]==m)return true;
            }
        }
        return false;

    }
}
