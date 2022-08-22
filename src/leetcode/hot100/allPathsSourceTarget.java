package leetcode.hot100;

import org.w3c.dom.ls.LSInput;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName allPathsSourceTarget
 * @Description TODO
 * @Author ktx
 * @Date 2022-08-21 11:12
 * @Version 1.0
 */
public class allPathsSourceTarget {

    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length;
        LinkedList<Integer> path = new LinkedList<>();
        dfs(graph,path,0);
        return result;
    }

    private void dfs(int[][] graph, LinkedList<Integer> path, int s) {
        path.add(s);
        if(s==graph.length-1){
            result.add(new LinkedList<>(path));
            return;
        }
        for (int i : graph[s]) {
            dfs(graph,path,i);
            path.removeLast();
        }
    }
}
