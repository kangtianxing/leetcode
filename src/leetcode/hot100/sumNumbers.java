package leetcode.hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName sumNumbers
 * @Description TODO
 * @Author ktx
 * @Date 2022-09-28 10:28
 * @Version 1.0
 */
public class sumNumbers {
    List<Integer> path = new ArrayList<>();
    int res = 0;
    public int sumNumbers(TreeNode root) {
        if(root==null){
            return 0;
        }
        path.add(root.val);
        dfs(root);
        return res;
    }

    private void dfs(TreeNode root) {
        if(root.left==null&&root.right==null){
            res+=listToInt(path);
            return;
        }
        if(root.left!=null){
            path.add(root.left.val);
            dfs(root.left);
            path.remove(path.size()-1);
        }
        if(root.right!=null){
            path.add(root.right.val);
            dfs(root.right);
            path.remove(path.size()-1);
        }
    }
    public int listToInt(List<Integer> path){
        int sum = 0;
        for (Integer num:path){
            // sum * 10 表示进位
            sum = sum * 10 + num;
        }
        return sum;
    }
}
