package leetcode.hot100;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author ktx
 * @data 2022-07-06 18:32
 */
public class nextGreateElement {

    int[] nextGreaterElement(int[] nums){
        int length = nums.length;
        int[]res = new int[length];
        Stack<Integer> stack = new Stack<>();
        for (int i = length-1;i>=0;i--){
            // 判断个子高矮
            while (!stack.isEmpty()&&stack.peek()<=nums[i]){
                stack.pop();
            }
            res[i] = stack.isEmpty()?-1:stack.peek();
            stack.push(nums[i]);
        }
        return res;
    }
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> greaterMap = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = nums2.length-1;i>=0;i--){
            while (!stack.isEmpty()&&stack.peek()<=nums2[i]){
                stack.pop();
            }
            greaterMap.put(nums2[i],stack.isEmpty()?-1:stack.peek());
            stack.push(nums2[i]);
        }
        int[] res = new int[nums1.length];
        for (int i = 0;i<nums1.length;i++){
            res[i] = greaterMap.get(nums1[i]);
        }
        return res;
    }
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 2*n-1;i>=0;i--){
            while (!stack.isEmpty()&&stack.peek() <= nums[i % n])stack.pop();
            res[i % n] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i % n]);
        }
        return res;
    }
}
