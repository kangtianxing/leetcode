package leetcode.hot100;

/**
 * @ClassName findMin
 * @Description TODO
 * @Author ktx
 * @Date 2022-07-18 23:07
 * @Version 1.0
 */
public class findMin {

    // 寻找旋转数组中的最小值，不存在重复
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }
    // 存在重复数组
    public int findMin1(int[] nums){
        int left = 0;
        int right = nums.length-1;
        int mid;
        while (left<right){
            mid = left + (right - left) / 2;
            if(nums[mid]>nums[right]){
                left = mid+1;
            }else if(nums[mid]<nums[right]){
                right = mid;
            }else {
                right -= 1;
            }
        }
        return nums[left];
    }
    // 假设原数组严格递增 不存在重复
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (left<=right){
            mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if(nums[mid]<nums[right]){
                if(target<=nums[right]&&target>nums[mid]){
                    left = mid+1;
                }else {
                    right = mid-1;
                }
            }else {
                // 左侧保证有序
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }
    public boolean search1(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[mid] < nums[right]) {
                // 右侧必定有序
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else if (nums[mid] > nums[right]) {
                // 左侧必定有序
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (nums[mid] == nums[right]) {
                // 不能确定
                while (left <= right && right > 1 && nums[right - 1] == nums[right]) {
                    right--;
                }
                right--;
            }
        }
        return false;
    }
    public int search3(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        int mid;
        while (left<=right){
            mid = left+(right-left)/2;
            if(nums[mid]== target){
                return mid;
            }
            if(nums[mid]<nums[right]){
                // 保证右侧有序
                if(nums[mid]<target&&nums[right]>=target){
                    left = mid+1;
                }else {
                    right = mid-1;
                }
            }else {
                if(nums[mid]>target&&nums[left]<=target){
                    right =mid-1;
                }else {
                    left = mid+1;
                }
            }
        }
        return -1;
    }


}
