package nowcoder.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author ktx
 * @data 2022-06-27 22:02
 */
public class dp15Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0;i<n;i++){
            arr[i] = scanner.nextInt();
        }
        int[] result = getResult(n,arr);
        System.out.println(result);

    }

    private static int[] getResult(int n, int[] arr) {
        int[] dp = new int[n];
        int[] res = new int[2];
        res[0] = 1;
        res[1] = 1;
        Arrays.fill(dp,1);
        for (int i =1;i<n;i++){
            for (int j = 0;j<i;j++){
                if(arr[i]<arr[j]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            res[0] = Math.max(res[0],dp[i]);
        }
        List<Integer> list = new ArrayList<>();
        return res;
    }
}
