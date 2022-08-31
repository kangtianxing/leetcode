package leetcode.hot100;

/**
 * @ClassName Cai
 * @Description TODO
 * @Author ktx
 * @Date 2022-08-31 17:36
 * @Version 1.0
 */
public class Cai {
//    public static int getMoneyAmount(int n) {
//        int[][] f = new int[n + 1][n + 1];
//        for (int i = n - 1; i >= 1; i--) {
//            for (int j = i + 1; j <= n; j++) {
//                f[i][j] = j + f[i][j - 1];
//                for (int k = i; k < j; k++) {
//                    f[i][j] = Math.min(f[i][j], k + Math.max(f[i][k - 1], f[k + 1][j]));
//                }
//            }
//        }
//        return f[1][n];
//    }
//
//    public static int  guessNumber(int n) {
//        int left = 1, right = n;
//        while (left < right) { // 循环直至区间左右端点相同
//            int mid = left + (right - left) / 2; // 防止计算时溢出
//            if (guess(mid) <= 0) {
//                right = mid; // 答案在区间 [left, mid] 中
//            } else {
//                left = mid + 1; // 答案在区间 [mid+1, right] 中
//            }
//        }
//        // 此时有 left == right，区间缩为一个点，即为答案
//        return left;
//    }

    public static void main(String[] args) {
        int target = 5;
        int result = 0;
        for (int i = 1;i<=5;i++){
            result+=getMoneyAmount(i);
        }
        System.out.println(result);
    }

    private static int getMoneyAmount(int i) {
        return (int)(Math.log(i) / Math.log(2)+1);
    }

}
