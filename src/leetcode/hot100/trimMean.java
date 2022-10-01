package leetcode.hot100;

import java.util.Arrays;

/**
 * @ClassName trimMean
 * @Description TODO
 * @Author ktx
 * @Date 2022-09-14 9:46
 * @Version 1.0
 */
public class trimMean {
    public double trimMean(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        int partialSum = 0;
        for (int i = n/20;i<19*n/20;i++){
            partialSum+=arr[i];
        }
        return partialSum/(n*0.9);
    }
}
