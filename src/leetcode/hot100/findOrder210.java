package leetcode.hot100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 找到任一拓扑排序顺序
 * @author ktx
 * @data 2022-06-16 21:58
 */
public class findOrder210 {
    List<List<Integer>> edges;
    int[] indeg;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<>();
        for(int i = 0;i<numCourses;i++){
            edges.add(new ArrayList<>());
        }
        indeg = new int[numCourses];
        for(int[] info:prerequisites){
            edges.get(info[1]).add(info[0]);
            ++indeg[info[0]];
        }
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        for(int i = 0;i<numCourses;i++){
            if(indeg[i]==0){
                queue.offer(i);

            }
        }
        int visted = 0;
        while(!queue.isEmpty()){
            visted++;
            int u = queue.poll();
            result.add(u);
            for(int v:edges.get(u)){
                --indeg[v];
                if(indeg[v]==0){
                    queue.offer(v);
                }
            }
        }
        if(result.size()<numCourses){
            return new int[0];
        }
        int[] nums = new int[numCourses];
        for(int i = 0;i<numCourses;i++){
            nums[i] = result.get(i);
        }
        return nums;
    }
}
