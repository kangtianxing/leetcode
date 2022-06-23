package nowcoder.dp;

/**
 * 乘机为正的最大连续子数组
 * @author ktx
 * @data 2022-06-23 21:10
 */
//同时维护最长连续正数和最长连续负数
public class dp8getMaxLen {

    public int getMaxLen(int[] nums) {
        int n = nums.length;
        int[] positive = new int[n];
        int[] negative = new int[n];
        if(nums[0]>0){
            positive[0] = 1;
        }else if(nums[0]<0){
            negative[0] = 1;
        }
        int maxLength = positive[0];
        for (int i = 1;i<n;i++){
            if(nums[i]>0) {
                positive[i] = positive[i - 1] + 1;
                negative[i] = negative[i - 1] > 0 ? negative[i - 1] + 1 : 0;
            }else if(nums[i]<0){  // 会改变乘机的正负性
                positive[i] = negative[i-1]>0?negative[i-1]+1:0;
                negative[i] = positive[i-1]+1;
            }else {
                positive[i] = 0;
                negative[i] = 0;
            }
            maxLength = Math.max(maxLength,positive[i]);
        }
        return maxLength;
    }
}
