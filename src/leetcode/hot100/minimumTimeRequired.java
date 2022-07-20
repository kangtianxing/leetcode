package leetcode.hot100;

import java.util.Arrays;

/**
 * @ClassName minimumTimeRequired
 * @Description 给你一个整数数组 jobs ，其中 jobs[i] 是完成第 i 项工作要花费的时间。
 * 请你将这些工作分配给 k 位工人。如何尽快完成这些工作？请给出你的解决方案。
 * @Author ktx
 * @Date 2022-07-20 21:54
 * @Version 1.0
 */
public class minimumTimeRequired {
    private int res = Integer.MAX_VALUE;
    public int minimumTimeRequired(int[] jobs, int k) {
        traceback(jobs,0,new int[k]);
        return res;
    }

    private void traceback(int[] jobs, int index, int[] workers) {
        if(index==jobs.length){
            res = Math.min(res, Arrays.stream(workers).max().getAsInt());
            return;
        }
        for (int i = 0; i < workers.length; i++) {
            workers[i]+=jobs[index];
            traceback(jobs,index+1,workers);
            workers[i]-=jobs[index];
        }
    }
    private void traceback1(int[] jobs, int index, int[] workers) {
        // 优化1：如果某次分配后，某个工人的时长已经超过所维护的最小值，则尽快结束这个递归
        if (Arrays.stream(workers).max().getAsInt() >= res) {
            return;
        }
        if (index == jobs.length) {
            res = Math.min(res, Arrays.stream(workers).max().getAsInt());
            return;
        }
        for (int i = 0; i < workers.length; i++) {
            // 优化2：如果第i-1个工人没有被分配工作，那么就不给第i个工人分配工作
            if (i > 0 && workers[i - 1] == 0) {
                continue;
            }
            workers[i] += jobs[index];
            traceback1(jobs, index + 1, workers);
            workers[i] -= jobs[index];
        }
    }

}
