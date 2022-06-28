package nowcoder.dp;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 俄罗斯套娃，固定一个维度，求另一个维度最长上升子序列
 *要排除一个维度有重复值的情况，我们按照w升序，如果w相同则按h降序
 *
 * @author ktx
 * @data 2022-06-28 20:18
 */
public class dp17maxEnvelopes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] arr =new int[n][2];
        for (int i = 0;i<n;i++){
            arr[i][0] = scanner.nextInt();
            arr[i][1] = scanner.nextInt();
        }
        int result = maxEnvelopes(arr);
        System.out.println(result);

    }
    public static int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        int result = 1;
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]==o2[0]){
                    return o2[1]-o1[1];
                }else {
                    return o1[0]-o2[0];
                }
            }
        });
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        for (int i = 1;i<n;i++){
            for (int j = 0;j<i;j++){
                if(envelopes[i][1]>envelopes[j][1]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            result = Math.max(result,dp[i]);
        }
        return result;
    }
}
