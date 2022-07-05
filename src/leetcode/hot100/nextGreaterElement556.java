package leetcode.hot100;

import java.util.Arrays;

/**
 * @author ktx
 * @data 2022-07-04 16:58
 */
public class nextGreaterElement556 {
    public int nextGreaterElement(int n){
        char[] nums = Integer.toString(n).toCharArray();
        int i = nums.length-2;
        while (i>=0&&nums[i]>=nums[i+1]){
            i--;
        }
        if(i<0){
            return -1;
        }
        int j = nums.length-1;
        while (j>=0&&nums[i]>=nums[j]){
            j--;
        }
        swap(nums,i,j);
        reverse(nums,i+1);
        long ans = Long.parseLong(new String(nums));
        return ans>Integer.MAX_VALUE?-1:(int)ans;

    }

    private void reverse(char[] nums, int i) {
        int j = nums.length-1;
        while (i<j){
            swap(nums,i,j);
            i++;
            j--;
        }
    }

    public void swap(char[] nums,int i,int j ){
        char temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        nextGreaterElement556 nextGreaterElement556 = new nextGreaterElement556();
        int num = 1231;
        int nextGreaterElement = nextGreaterElement556.nextGreaterElement(num);
        System.out.println(nextGreaterElement);
    }

    public int nextGreaterElement1(int n){
        char[] array = Integer.toString(n).toCharArray();
        for (int i = array.length-1;i>=0;i--){
            if(array[i]>array[i-1]){
                // 从后往前找到第一个相邻的升序元素对
                Arrays.sort(array,i,array.length);
                for (int j = i;j<array.length;j++){
                    if(array[j]>array[i-1]){
                        char t = array[i-1];
                        array[i-1] = array[j];
                        array[j] = t;
                        long ans = Long.parseLong(String.valueOf(array));
                        if(ans>Integer.MAX_VALUE){
                            return -1;
                        }
                        return (int)ans;
                    }
                }
            }
        }
        return -1;
    }
}
