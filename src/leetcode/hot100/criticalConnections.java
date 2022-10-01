package leetcode.hot100;

import java.util.*;

/**
 * @ClassName criticalConnections
 * @Description TODO
 * @Author ktx
 * @Date 2022-09-27 11:19
 * @Version 1.0
 */
public class criticalConnections {
    int n;
    Map<Integer,List<Integer>> G;
    int[] id; // 每个顶点的时间戳。表示进行本次深度优先搜索时被访问的时间顺序。
    int[] low;// 追溯值。顶点 i 能够访问到的所有顶点中，时间戳最小的值。
    boolean[] visited; // 也可以把 low 初始化成 -1 来表示是否已经访问该顶点。
    List<List<Integer>> cutEdges;
    Set<Integer> cutVertices; // 割点
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        if (connections == null || connections.size() == 0) return new ArrayList<>();
        this.n = n;
        this.id = new int[n];
        this.low = new int[n];
        this.visited = new boolean[n];
        this.cutEdges = new ArrayList<>();
        this.cutVertices = new HashSet<>();
        // 建图
        buildGraph(connections);
        // 以某一个未访问节点 i 出发进行深度优先搜索
        for (int i = 0; i < n; i++) {
            dfs(-1, i, 0);
        }
        return cutEdges;

    }

    private void dfs(int parent, int i, int timestamp) {
        visited[i] = true;
        id[i] = low[i] = timestamp;
        for (Integer nei : G.get(i)) {
            if(nei==parent)continue;
            if(visited[nei]){
                low[i] = Math.min(low[i],id[nei]);
            }else {
                dfs(i,nei,timestamp+1);
                low[i] = Math.min(low[i],low[nei]);
                if(id[i]<low[nei])cutEdges.add(Arrays.asList(i,nei));
            }
        }
    }

    private void buildGraph(List<List<Integer>> connections) {
        this.G = new HashMap<>();
        for (int i = 0; i < n; i++)
            G.put(i, new ArrayList<>());

        for (List<Integer> c : connections) {
            int v1 = c.get(0), v2 = c.get(1);
            G.get(v1).add(v2);
            G.get(v2).add(v1);
        }
    }

}
