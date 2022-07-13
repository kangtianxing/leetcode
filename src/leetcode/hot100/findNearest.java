package leetcode.hot100;

/**
 * @ClassName findNearest
 * @Description TODO
 * @Author ktx
 * @Date 2022-07-13 21:45
 * @Version 1.0
 */
public class findNearest {
    public int findNearest(int[] nums, int target){
        int len = nums.length;
        // 最接近的数有可能是边界，判特一下
        if(nums[0]>target){
            return nums[0];
        }
        if(nums[len-1]<target){
            return nums[len-1];
        }
        int left = 0;
        int right = len-1;
        int mid;
        while (left<=right){
            mid = (left+right)/2;
            if(nums[left]>target){
                return target -nums[left-1]<=nums[left] - target?nums[left-1]:nums[left];
            }
            if(nums[right]<right){
                return target - nums[right] <= nums[right + 1] - target ? nums[right] : nums[right + 1];
            }
            if(nums[mid]==target){
                return nums[mid];
            }else if(nums[mid]<target){
                left = mid+1;
            }else if(nums[mid]>target){
                right = mid-1;
            }
        }
        return -1;
    }
}
