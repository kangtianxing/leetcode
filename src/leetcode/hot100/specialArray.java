package leetcode.hot100;

import java.util.Arrays;

/**
 * @ClassName specialArray
 * @Description TODO
 * @Author ktx
 * @Date 2022-09-12 10:00
 * @Version 1.0
 */
public class specialArray {

    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        if(nums[0]>=n)return n;
        for (int i = 1; i < n; i++) {
            if(nums[n-i]>=i&&nums[n-i-1]<i)return i;
        }
        return -1;
    }
}
