package nowcoder;

import java.util.HashSet;
import java.util.Set;

public class Nqueen59 {

    Set<Integer> column = new HashSet<>(); // 标记列不可用
    Set<Integer> posSlant = new HashSet<>();// 标记正斜线
    Set<Integer> conSlant = new HashSet<>(); // 标记反斜线
    int result = 0;
    int Nqueen(int n) {
        // write code here
        dfs(0,n);
        return result;
    }

    private void dfs(int i, int n) {
        if(i==n){
            result++;
            return;
        }
        for (int j = 0;j<n;j++){
            if(column.contains(j)||posSlant.contains(i-j)||conSlant.contains(i+j)){
                continue;
            }
            column.add(j);
            posSlant.add(i-j);
            conSlant.add(i+j);
            dfs(i+1,n);
            column.remove(j);
            posSlant.remove(i-j);
            conSlant.remove(i+j);
        }
    }
}
