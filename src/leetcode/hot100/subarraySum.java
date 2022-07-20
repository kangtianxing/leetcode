package leetcode.hot100;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName subarraySum
 * @Description TODO
 * @Author ktx
 * @Date 2022-07-20 23:18
 * @Version 1.0
 */
public class subarraySum {
    public int subarraySum(int[] nums, int target){
        // 前缀和
        int len = nums.length;
        int[] preSum = new int[len + 1];
        for (int i = 0; i < len; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }
        // 计数
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < len; i++) {
            if(map.containsKey(preSum[i+1]-target)){
                count+=map.get(preSum[i+1]-target);
            }
            map.put(preSum[i+1],map.getOrDefault(preSum[i+1],0)+1);
        }
        return count;
    }
}
