package inter.zhong;

import javax.security.sasl.SaslClient;
import java.util.*;

/**
 * @ClassName Main2
 * @Description TODO
 * @Author ktx
 * @Date 2022-08-20 10:27
 * @Version 1.0
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = 4;

        List<List<Integer>> list = new ArrayList<>();
        // 根据数组生成邻接表(小插曲)
        int[][] arr = {{2,1},{3,1},{4,2},{5,3}};

        int maxNum = 5;
        int[] res = new int[maxNum];
        int resIndex = 0;
        for(int i = 0; i <= maxNum; i++){
            list.add(new ArrayList<>());
        }
        int[] degree = new int[maxNum];
        for(int[] a : arr){
            list.get(a[0]).add(a[1]);
            degree[a[1]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(4);
        res[resIndex++] = 4;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int index : list.get(node)) {
                degree[index]--;
                if (degree[index] == 0) {
                    queue.offer(index);
                    res[resIndex++] = index;
                }
            }
        }
        for (int re : res) {
            System.out.println(re);
        }

    }
}
