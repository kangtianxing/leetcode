package leetcode.graph;

/**
 * @ClassName isBipartite
 * @Description TODO
 * @Author ktx
 * @Date 2022-09-18 11:58
 * @Version 1.0
 */
public class isBipartite {
    public boolean isBipartite(int[][] graph){
        int len = graph.length;
        int[] draw = new int[len];
        for (int i = 0;i<len;i++){
            if(draw[i]==0 &&!dfs(graph,i,1,draw)){
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int[][] graph, int v, int color, int[] draw) {
        if(draw[v]!=0){
            return draw[v]==color;
        }
        draw[v]=color;
        for (int w : graph[v]) {
            if(!dfs(graph,w,-color,draw)){
                return false;
            }
        }
        return true;
    }
}
