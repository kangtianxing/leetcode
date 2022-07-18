package nowcoder.dp;

import java.util.Scanner;

/**
 * @ClassName dp59
 * @Description 数位染色
 * @Author ktx
 * @Date 2022-07-18 21:37
 * @Version 1.0
 */
public class dp59 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int n = str.length();
        int[] arr = new int[n];
        for(int i = 0;i<n;i++){
            arr[i] = str.charAt(i)-'0';
        }
        int sum = 0;
        for (int num : arr) {
            sum+=num;
        }
        if(sum%2!=0){
            System.out.println("No");
            return;
        }
        int target = sum/2;
        boolean[] dp = new boolean[target+1];
        dp[0] = true;
        for (int i = 0;i<n;i++){
            for (int j = target;j>=arr[i];j--){
                dp[j] = dp[j]|dp[j-arr[i]];
            }
        }
        if(dp[target]){
            System.out.println("Yes");
        }else {
            System.out.println("No");
        }

    }
}
