package nowcoder.dp;

import java.util.Scanner;

/**
 * @author ktx
 * @data 2022-07-02 21:08
 */
public class dp22Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String str=in.next();
        int result = getMaxHhuiwen(str);
        System.out.println(result);
    }

    private static int getMaxHhuiwen(String str) {
        int length = str.length();
        int[][] dp = new int[length][length];
        for (int i = 0;i<length;i++){
            dp[i][i] = 1;
        }
        for (int i=length-2;i>=0;i--){
            for (int j = i+1;j<length;j++){
                if(str.charAt(i)==str.charAt(j)){
                    dp[i][j] = Math.max(dp[i][j-1],dp[i+1][j])+1;
                }else {
                    dp[i][j] =Math.max(dp[i][j-1],dp[i+1][j]);
                }
            }
        }
        return dp[0][length-1];
    }

}
