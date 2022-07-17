package leetcode.hot100;

/**
 * @ClassName arrayNesting565
 * @Description 数组嵌套
 * @Author ktx
 * @Date 2022-07-17 22:26
 * @Version 1.0
 */
public class arrayNesting565 {

    public int arrayNesting(int[] nums) {
        int ans = 0;
        for (int i =0 ;i<nums.length;i++){
            ans = Math.max(ans,maxLength(nums,i));
        }
        return ans;
    }

    private int maxLength(int[] nums, int start) {
        boolean has[] = new boolean[nums.length];
        int ans = 0;
        while (!has[start]){
            has[start] = true;
            start = nums[start];
            ans++;
        }
        return ans;
    }

    public int arrayNesting1(int[] nums) {
        int ans = 0;
        boolean has[] = new boolean[nums.length];
        for (int i =0 ;i<nums.length;i++){
            if (!has[i]){
                int count = 0;
                while (!has[i]){
                    has[i] = true;
                    count++;
                    i = nums[i];
                }
                ans = Math.max(ans,count);
            }

        }
        return ans;
    }
}
