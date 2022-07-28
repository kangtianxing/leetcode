package leetcode.hot100;

/**
 * @ClassName subarraysWithKDistinct
 * @Description TODO
 * @Author ktx
 * @Date 2022-07-28 21:52
 * @Version 1.0
 */
public class subarraysWithKDistinct {
    public int subarraysWithKDistinct(int[] A, int K) {
        // 恰好K个 = 最多K个 - 最多K-1个
        // 而“最多”，使用的就是最经典的滑窗模板
        return countWithKDistinct(A, K) - countWithKDistinct(A, K - 1);
    }
    private int countWithKDistinct(int[] A, int K) {
        int len = A.length;
        int[] countA = new int[len + 1];    // 统计具体数字
        int countK = 0;                     // 统计不同数字的个数

        int L = 0, R = 0;
        int res = 0;
        while (R < len) {
            if(countA[A[R]] == 0) {
                countK++;
            }
            countA[A[R]]++;
            while (countK > K) {
                countA[A[L]]--;
                if(countA[A[L]] == 0) {
                    countK--;
                }
                L++;
            }
            res += (R - L + 1);     // 每次R主动移动后，合法窗口的大小即为对结果的贡献
            R++;
        }
        return res;
    }

}
