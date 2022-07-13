package leetcode.hot100;

/**
 * @ClassName countTarget
 * @Description 二分模板--命中
 * @Author ktx
 * @Date 2022-07-13 21:26
 * @Version 1.0
 */
public class countTarget {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,4,4,5,6};
        countTarget countTarget = new countTarget();
        int countTarget1 = countTarget.countTarget(nums, 4);
        System.out.println(countTarget1);
    }
    private int countTarget(int[] nums,int target){
        int borderL = serchLeftBorder(nums,target);
        int borderR = serchRightBorder(nums,target);
        if(borderL != -1 && borderR != -1){
            return borderR-borderL+1;
        }else {
            return 0;
        }
    }

    private int serchRightBorder(int[] nums, int target) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        int mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] == target) {
                if (mid == len-1 || nums[mid + 1] != target) {
                    return mid;
                } else {
                    left = mid+1;
                }
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    private int serchLeftBorder(int[] nums, int target) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        int mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] == target) {
                if (mid == 0 || nums[mid - 1] != target) {
                    return mid;
                } else {
                    right = mid - 1;
                }
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;

    }
}
