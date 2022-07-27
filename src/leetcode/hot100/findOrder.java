package leetcode.hot100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName findOrder
 * @Description TODO
 * @Author ktx
 * @Date 2022-07-27 23:15
 * @Version 1.0
 */
public class findOrder {
    public int[] findOrder(int numCourses, int[][] prerequisites){
        List<List<Integer>> list = new ArrayList<>();
        int[] degree = new int[numCourses];
        int[] res = new int[numCourses];
        int resIndex = 0;

        // 根据数组生成邻接表
        for(int i = 0; i < numCourses; i++){
            list.add(new ArrayList<>());
        }
        for(int[] arr : prerequisites){
            list.get(arr[1]).add(arr[0]);
            degree[arr[0]]++;
        }
        // BFS核心代码(★☆★)
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(degree[i] == 0){
                queue.offer(i);
                res[resIndex++] = i;
            }
        }
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for(int index : list.get(node)){
                degree[index]--;
                if(degree[index] == 0){
                    queue.offer(index);
                    res[resIndex++] = index;
                }
            }
        }
        return resIndex == numCourses ? res : new int[0];
    }
}
