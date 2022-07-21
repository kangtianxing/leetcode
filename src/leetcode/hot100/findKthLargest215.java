package leetcode.hot100;

import java.util.PriorityQueue;

/**
 * @ClassName findKthLargest215
 * @Description 数组中第K个最大元素
 * @Author ktx
 * @Date 2022-07-21 18:26
 * @Version 1.0
 */
public class findKthLargest215 {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0;i<n;i++){
            if(i<k){
                queue.offer(nums[i]);
            }else {
                if(queue.peek()<=nums[i]){
                    queue.poll();
                    queue.offer(nums[i]);
                }
            }
        }
        return queue.peek();
    }
}
