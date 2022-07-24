package leetcode.hot100;

/**
 * @ClassName distanceBetweenBusStops
 * @Description TODO
 * @Author ktx
 * @Date 2022-07-24 21:02
 * @Version 1.0
 */
public class distanceBetweenBusStops {

    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int sum = 0;
        for (int num : distance) {
            sum+=num;
        }
        int res = 0;
        int min = Math.min(start,destination);
        int max = Math.max(start,destination);

        for (int i = min;min<max;i++){
            res+=distance[i];
        }
        res = sum-res>res?res:sum-res;
        return res;
    }
}
