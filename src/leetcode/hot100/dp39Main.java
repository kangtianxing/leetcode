package leetcode.hot100;

import java.util.Scanner;

/**
 * @author ktx
 * @data 2022-07-08 18:35
 */
public class dp39Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] arr = new int[n][m];
        String[] str = new String[n];
        for(int i = 0;i<n;i++){
            str[i] = scanner.nextLine();
        }
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(str[i].charAt(j)=='l'){
                    arr[i][j] = 4;
                } else if(str[i].charAt(j)=='o'){
                    arr[i][j] = 3;
                } else if(str[i].charAt(j)=='v'){
                    arr[i][j] = 2;
                } else if(str[i].charAt(j)=='e'){
                    arr[i][j] = 1;
                }
            }
        }
        int[][] dp =new int[n][m];
        dp[0][0] = arr[0][0];
        for (int i =1;i<n;i++){
            dp[i][0] =dp[i-1][0]+arr[i][0];
        }
        for (int j = 1;j<m;j++){
            dp[0][j] = dp[0][j-1]+arr[0][j];
        }
        for (int i =1;i<n;i++){
            for (int j =1;j<m;j++){
                dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1])+arr[i][j];
            }
        }
        System.out.println(dp[n-1][m-1]);
    }
}
