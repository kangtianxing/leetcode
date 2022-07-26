package leetcode.hot100;

import java.util.LinkedList;

/**
 * @ClassName isBipartite
 * @Description TODO
 * @Author ktx
 * @Date 2022-07-26 22:59
 * @Version 1.0
 */
public class isBipartite {
    /**
     *【BFS】
     * BFS经典思路：每次出队时，就判断出队节点的邻居是否被染色：
     *        如果未被染色，就染成出队节点的反色
     *        如果已经染色，就检查邻居的颜色是否合法，即与出队节点互为反色
     *
     */
    public boolean isBipartite(int[][] graph){
        int len = graph.length;
        int[] draw = new int[len];
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            if(draw[i]!=0){
                continue;
            }
            draw[i] = 1;
            queue.offer(i);
            while (!queue.isEmpty()){
                Integer index = queue.poll();
                for (int node : graph[index]) {
                    if(draw[node]==0){
                        draw[node] = -draw[index];
                        queue.offer(node);
                    }else if(draw[node]==draw[index]){
                        return false;
                    }
                }
            }
        }
        return true;
    }
    /**
     *【DFS】
     * BFS返回一个boolean值，BFS的含义是：给当前节点(draw[index])染成color是否合法
     *          如果已经染色，就检查是否是要涂的color
     *          如果还未染色，就涂上color，并给其所有邻居尝试染上反色(递归)
     */
    public boolean isBipartite1(int[][] graph){
        int len = graph.length;
        int[] draw = new int[len];

        for (int i = 0; i < len; i++) {
            if(draw[i] ==0&&!DFS(graph,draw,i,1)){
                return false;
            }
        }
        return true;
    }

    private boolean DFS(int[][] graph, int[] draw, int index, int color) {
        if(draw[index]!=0){// 如果已经染色，就检查是否是要涂的color
            return draw[index]==color;
        }
        draw[index]=color;// 如果还未染色，就涂上color，并给其所有邻居尝试染上反色(递归)
        for (int node : graph[index]) {
            if (!DFS(graph,draw,node,-color)) {
                return false;
            }
        }
        return true;
    }
}

class UnionSet{
    int[] roots;
    public UnionSet(int len){
        roots = new int[len];
        for (int i = 0; i < len; i++) {
            roots[i] = i;
        }
    }
    public int findRoot(int node){
        if(node==roots[node]){
            return node;
        }
        roots[node] = findRoot(roots[node]);
        return roots[node];
    }
    public boolean isUnion(int node1, int node2) {
        return findRoot(node1) == findRoot(node2);
    }

    public void union(int node1, int node2) {
        roots[node1] = findRoot(node2);
    }

}
