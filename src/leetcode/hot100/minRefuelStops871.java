package leetcode.hot100;

import java.util.PriorityQueue;

/**
 * 最低加油次数
 * @author ktx
 * @data 2022-07-02 18:17
 */
public class minRefuelStops871 {

    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int n= stations.length;
        if(n==0){
            return startFuel>=target?0:1;
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(((o1, o2) -> {
            return o2 - o1;
        }));
        int sum = startFuel;
        int ans = 0;
        for (int i =0;i<stations.length;i++){
            while (sum<stations[i][0]){
                Integer poll = priorityQueue.poll();
                if(poll==null)return -1;
                sum+=poll;
                ans++;
            }
            priorityQueue.offer(stations[i][1]);
        }
        while (sum<target){
            Integer ii = priorityQueue.poll();
            if(ii==null){
                return -1;
            }
            sum+=ii;
            ans++;
        }
        return ans;

    }
}
