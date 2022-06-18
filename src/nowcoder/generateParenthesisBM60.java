package nowcoder;

import java.util.ArrayList;

public class generateParenthesisBM60 {
    public ArrayList<String> generateParenthesis (int n) {
        // write code here
        ArrayList<String> res = new ArrayList<>();
        if(n==0){
            return res;
        }
        StringBuilder path = new StringBuilder();
        dfs(path,n,n,res);
        return res;
    }

    private void dfs(StringBuilder path, int left, int right, ArrayList<String> res) {
        if(left==0&&right==0){
            res.add(path.toString());
            return;
        }
        if(left>right){
            return;
        }
        if(left>0){
            path.append("(");
            dfs(path,left-1,right,res);
            path.deleteCharAt(path.length()-1);
        }
        if(right>0){
            path.append(")");
            dfs(path,left,right-1,res);
            path.deleteCharAt(path.length()-1);
        }
    }
}
