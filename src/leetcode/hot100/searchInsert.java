package leetcode.hot100;

/**
 * @ClassName searchInsert
 * @Description TODO
 * @Author ktx
 * @Date 2022-07-13 22:05
 * @Version 1.0
 */
public class searchInsert {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[left] > target) {
                return left;
            }
            if (nums[right] < target) {
                return right + 1;
            }
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                return mid;
            }
        }
        return -1;
    }

}
