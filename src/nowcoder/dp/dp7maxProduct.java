package nowcoder.dp;

/**
 * 最大乘积子数组
 * @author ktx
 * @data 2022-06-23 20:42
 */
public class dp7maxProduct {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int[] maxDP = new int[n];
        int[] minDP = new int[n];
        System.arraycopy(nums,0,maxDP,0,n);
        System.arraycopy(nums,0,minDP,0,n);
        for (int i = 1;i<n;i++){
            maxDP[i] = Math.max(maxDP[i-1]*nums[i],Math.max(minDP[i-1]*nums[i],nums[i]));
            minDP[i] = Math.min(minDP[i-1]*nums[i],Math.min(maxDP[i-1]*nums[i],nums[i]));
        }
        int ans = maxDP[0];
        for (int i = 1;i<n;i++){
            ans = Math.max(ans,maxDP[i]);
        }
        return ans;
    }
}
