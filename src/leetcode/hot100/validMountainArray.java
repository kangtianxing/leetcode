package leetcode.hot100;

/**
 * @ClassName validMountainArray
 * @Description TODO
 * @Author ktx
 * @Date 2022-09-15 18:04
 * @Version 1.0
 */
public class validMountainArray {
    public boolean validMountainArray(int[] arr) {
        if(arr.length<3){
            return false;
        }
        int left = 0;
        int right = arr.length-1;
        while (left+1<arr.length&&arr[left]<arr[left+1]){
            left++;
        }
        // 注意防止指针越界
        while (right > 0 && arr[right] < arr[right - 1]) {
            right--;
        }
        if(left==right &&left!=0&&right!=arr.length-1){
            return true;
        }
        return false;
    }
}
