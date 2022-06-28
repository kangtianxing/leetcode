package leetcode.hot100;

import java.util.Arrays;

/**
 * @author ktx
 * @data 2022-06-28 16:34
 */
public class wiggleSort324 {
    public void wiggleSort(int[] nums) {
        int n = nums.length;
        int[] clone = nums.clone();
        Arrays.sort(clone);
        int left = (n-1)/2,right = n-1;
        for (int i = 0;i<n;i++){
            if(n%2==0){
                nums[i] = clone[left--];
            }else {
                nums[i] = clone[right--];
            }
        }
    }

}
