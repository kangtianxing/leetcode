package leetcode.hot100;

/**
 * @ClassName longestOnes
 * @Description TODO
 * @Author ktx
 * @Date 2022-07-27 23:19
 * @Version 1.0
 */
public class longestOnes {
    /*
    * 题意转换。把「最多可以把 K 个 0 变成 1，求仅包含 1 的最长子数组的长度」转换为 「找出一个最长的子数组，该子数组内最多允许有 K 个 0 」
    * */
    public int longestOnes(int[] nums, int k) {
        int length = nums.length;
        int left = 0;
        int right = 0;
        int res = 0;
        int zeros = 0;
        while (right<length){
            if(nums[right]==0){
                zeros++;
            }
            right++;
            while (zeros>k){
                if(nums[left]==0){
                    zeros--;
                }
                left++;
            }
            res = Math.max(res,right-left);
        }
        return res;
    }
}
