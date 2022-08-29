package leetcode.hot100;

/**
 * @ClassName maxProduct
 * @Description TODO
 * @Author ktx
 * @Date 2022-08-26 20:46
 * @Version 1.0
 */
public class maxProduct {
    public int maxProduct(int[] nums) {
         int a = Math.max(nums[0],nums[1]);
         int b = Math.min(nums[0],nums[1]);
         for (int i = 2;i<nums.length;i++){
             if(nums[i]>a){
                 b = a;
                 a = nums[i];
             }else if(nums[i]>b){
                 b = nums[i];
             }
         }
         return (a-1)*(b-1);
    }
//    public static void main(String[] args) {
//
//    }
}
