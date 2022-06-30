package leetcode.hot100;

import java.util.Arrays;

/**
 * @author ktx
 * @data 2022-06-30 17:40
 */
public class maximumGap164 {
    public int maximumGap(int[] nums) {
        // 数组长度小于2直接 return 0
        int len = nums.length;
        if(len < 2){
            return 0;
        }

        int min = Arrays.stream(nums).min().getAsInt();
        int max = Arrays.stream(nums).max().getAsInt();
        int d = Math.max(1, (max - min) / (len - 1));   // 桶的宽度
        int bucketNum = (max - min) / d + 1;            // 桶的个数

        // 初始化桶
        int[][] bucket = new int[bucketNum][2];
        for(int[] arr : bucket){
            Arrays.fill(arr, -1);   // (-1, -1)表示空桶
        }

        // 向桶中装填数字，维护每个桶中的最大/最小值
        for(int i = 0; i < len; i++){
            int index = (nums[i] - min) / d;
            if(bucket[index][0] == -1){
                bucket[index][0] = nums[i];
                bucket[index][1] = nums[i];
            }else{
                bucket[index][0] = Math.min(bucket[index][0], nums[i]);
                bucket[index][1] = Math.max(bucket[index][1], nums[i]);
            }
        }

        // 遍历桶
        // 后一个桶的最小值 - 前一个桶的最大值，尝试更新res
        int res = 0;
        int pre = -1;
        for(int index = 0; index < bucket.length; index++){
            if(bucket[index][0] == -1){
                continue;
            }
            if(pre != -1){
                res = Math.max(res, bucket[index][0] - bucket[pre][1]);
            }
            pre = index;
        }
        return res;
    }
}
