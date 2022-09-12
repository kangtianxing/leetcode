package leetcode.hot100;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @ClassName mincostToHireWorkers
 * @Description TODO
 * @Author ktx
 * @Date 2022-09-11 10:37
 * @Version 1.0
 */
public class mincostToHireWorkers {

    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        double[][] workers = new double[quality.length][2];
        for (int i = 0; i < quality.length; i++) {
            workers[i] = new double[]{(double)(wage[i]) / quality[i], (double)quality[i]};
        }
        Arrays.sort(workers,(a,b)->Double.compare(a[0],b[0]));
        double res = Double.MAX_VALUE;
        double qsum = 0.0; //qsum保存K个工人的质量和
        PriorityQueue<Double> pq = new PriorityQueue<>();
        for (double[] worker : workers) {
            qsum += worker[1];
            pq.add(-worker[1]);
            if (pq.size() > k) {
                qsum += pq.poll();
            }
            if (pq.size() == k) {
                res = Math.min(res, qsum * worker[0]);
            }
        }
        return res;
    }
}
