package leetcode.hot100;

import java.util.*;

/**
 * @author ktx
 * @data 2022-06-30 20:46
 */
public class minimumEffortPath1631 {
    public int minimumEffortPath(int[][] heights) {
        int M = heights.length;
        int N = heights[0].length;
        List<int[]> graph = new ArrayList<>();
        for (int i = 0;i<M;i++){
            for (int j =0;j<N;j++){
                if(i+1<M){
                    graph.add(new int[]{Math.abs(heights[i][j] - heights[i+1][j]), i * N + j, (i+1) * N + j});
                }
                if(j+1<N){
                    graph.add(new int[]{Math.abs(heights[i][j] - heights[i][j+1]), i * N + j, i * N + j + 1});
                }
            }
        }
        Collections.sort(graph, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        UnionFind unionFind = new UnionFind(M * N);
        for (int[] edge : graph) {
            unionFind.union(edge[1],edge[2]);
            if(unionFind.find(0)==unionFind.find(N*M-1)){
                return edge[0];
            }
        }
        return 0;
    }
}
class UnionFind{
    int count;
    int[] parent;

    public UnionFind(int count) {
        this.count = count;
        this.parent = new int[count];
        for (int i = 0;i<count;i++){
            parent[i] = i;
        }
    }
    public void union(int p ,int q){
        int rootP = find(p);
        int rootQ = find(q);
        if(rootP==rootQ){
            return;
        }
        parent[rootP] = rootQ;
        count--;
    }
    public int find(int x){
        if(x!=parent[x]){
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
    public boolean isUnion(int p,int q){
        return find(p)==find(q);
    }
    public int getCount(){
        return count;
    }
}
