package nowcoder;

import java.util.Arrays;

/**
 * @author ktx
 * @data 2022-06-16 22:15
 */
public class miniSpanningTreeAB14 {
    public int miniSpanningTree (int n, int m, int[][] cost) {
        // write code here
        Arrays.sort(cost,(a,b)->(a[2]-b[2]));
        UF uf = new UF(n);
        int menoy = 0;
        for (int i = 0;i<m;i++){
            int from = cost[i][0]-1;
            int to = cost[i][1]-1;
            int costMoney = cost[i][2];
            if(!uf.connected(from,to)){
                uf.union(from,to);
                menoy+=costMoney;
            }
            if(uf.count()==1){
                break;
            }
        }
        return menoy;
    }
}

class UF{
    private int count;
    private int[] parent;

    public UF(int count) {
        this.count = count;
        parent = new int[count];
        for (int i = 0;i<count;i++){
            parent[i] = i;
        }
    }

    public void union(int p,int q){
        int rootP = find(p);
        int rootQ = find(q);
        if(rootP==rootQ){
            return;
        }
        parent[rootP] = rootQ;
        count--;
    }

    public boolean connected(int p,int q){
        int rootP = find(p);
        int rootQ = find(q);
        return rootP == rootQ;
    }

    private int find(int x) {
        if(parent[x]!=x){
            parent[x] =find(parent[x]);
        }
        return parent[x];
    }
    public int count(){
        return count;
    }
}
