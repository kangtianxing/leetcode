package leetcode.hot100;

/**
 * @ClassName minSubArrayLen
 * @Description TODO
 * @Author ktx
 * @Date 2022-07-28 21:44
 * @Version 1.0
 */
public class minSubArrayLen {
    public int minSubArrayLen(int target, int[] nums) {
        int len = nums.length;
        int count = 0;
        int L  = 0,R = 0;
        int res = Integer.MAX_VALUE;
        while (R<len){
            count+=nums[R];
            while (count>=target&&L<=R){
                res = Math.min(res,R-L+1);
                count-=nums[L];
                L++;
            }
            R++;
        }
        return res ==Integer.MAX_VALUE?0:res;
    }
}
