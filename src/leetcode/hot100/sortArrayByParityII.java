package leetcode.hot100;

/**
 * @ClassName sortArrayByParityII
 * @Description TODO
 * @Author ktx
 * @Date 2022-09-25 12:12
 * @Version 1.0
 */
public class sortArrayByParityII {
    public int[] sortArrayByParityII(int[] nums){
        int n = nums.length;
        int[] ans = new int[n];
        int i = 0;
        for (int num : nums) {
            if(num%2==0){
                ans[i] = num;
                i+=2;
            }
        }
        i = 1;
        for (int num : nums) {
            if(num%2==1){
                ans[i] = num;
                i+=2;
            }
        }
        return ans;
    }
    public int[] sortArrayByParityII1(int[] nums){
        int n = nums.length;
        int j =1;
        for (int i = 0;i<n;i+=2){
            if(nums[i]%2==1){
                while (nums[j]%2==1){
                    j+=2;
                }
                swap(nums,i,j);
            }
        }
        return nums;
    }
    public void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }







}
