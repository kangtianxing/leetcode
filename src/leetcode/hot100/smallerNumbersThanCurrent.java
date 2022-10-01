package leetcode.hot100;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName smallerNumbersThanCurrent
 * @Description TODO
 * @Author ktx
 * @Date 2022-09-15 17:58
 * @Version 1.0
 */
public class smallerNumbersThanCurrent {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int[] res = Arrays.copyOf(nums,nums.length);
        Arrays.sort(res);
        for (int i = 0; i < res.length; i++) {
            if(!map.containsKey(res[i])){//// 遇到了相同的数字，那么不需要更新该 number 的情况
                map.put(res[i],i);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            res[i] = map.get(nums[i]);
        }
        return res;
    }
}
