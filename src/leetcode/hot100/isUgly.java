package leetcode.hot100;

import java.util.*;

/**
 * @ClassName isUgly
 * @Description TODO
 * @Author ktx
 * @Date 2022-07-19 18:09
 * @Version 1.0
 */
public class isUgly {

    public boolean isUgly(int n) {
        if(n<1){
            return false;
        }
        while (n%2==0){
            n/=2;
        }
        while (n%3==0){
            n/=3;
        }
        while (n%5==0){
            n/=5;
        }
        return n==1;
    }
    /*
    * 使用一个最小堆（优先队列），先加入一个1进行初始化。
      每次取堆顶元素x（x是当前堆中最小的丑数），然后把丑数 2x、3x、5x 加入堆中。那么，当你第n次poll的时候，取出的就是第n个丑数啦！
      * 上述操作会向堆中加入重复的元素。我们还需要使用一个哈希集合避免重复。
    * */
    public int nthUglyNumber(int n) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        HashSet<Integer> set = new HashSet<>();
        heap.offer(1);
        set.add(1);
        int[] items = {2,3,5};
        for (int i = 0; i < n - 1; i++) {
            Integer ugly = heap.poll();
            for (int item : items) {
                int next = ugly * item;
                if(set.add(next)){
                    heap.offer(next);
                }
            }
        }
        return heap.poll();
    }

    public int nthUglyNumber1(int n) {
        int[] nums = new int[n];
        int p2 = 0;
        int p3 = 0;
        int p5 = 0;
        for (int i = 1; i < n; i++) {
            int num2 = nums[p2]*2;
            int num3 = nums[p3]*3;
            int num5 = nums[p5]*5;
            nums[i] = Math.min(num2, Math.min(num3, num5));
            if(nums[i]==num2){
                p2++;
            }
            if(nums[i]==num3){
                p3++;
            }
            if(nums[i]==num5){
                p5++;
            }

        }
        return nums[n-1];
    }

    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] dp = new int[n+1];
        int m = primes.length;
        int[] pointers = new int[m];
        int[] nums = new int[m];
        Arrays.fill(nums,1);
        for (int i = 1; i <= n; i++) {
            int minNum = Arrays.stream(nums).min().getAsInt();
            dp[i] = minNum;
            for (int j = 0;j<m;j++){
                if(nums[j]==minNum){
                    pointers[j]++;
                    nums[j] = dp[pointers[j]]*primes[j];
                }
            }
        }
        return dp[n];
    }


}
