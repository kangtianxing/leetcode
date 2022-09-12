package leetcode.hot100;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName twoSum
 * @Description TODO
 * @Author ktx
 * @Date 2022-09-07 10:13
 * @Version 1.0
 */
public class twoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            map.put(nums[i],i);
//        }
        for (int i = 0;i<nums.length;i++){
            if(map.containsKey(target-nums[i])){
                return new int[]{map.get(target-nums[i]),i};
            }
            map.put(nums[i],i);
        }
        return new int[]{-1,-1};
    }
}
