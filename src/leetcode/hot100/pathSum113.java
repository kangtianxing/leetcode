package leetcode.hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName pathSum113
 * @Description TODO
 * @Author ktx
 * @Date 2022-09-02 13:32
 * @Version 1.0
 */
public class pathSum113 {
    List<List<Integer>> res =new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        dfs(root,targetSum);
        return res;
    }

    private void dfs(TreeNode root, int targetSum) {
        if(root==null){
            return;
        }
        targetSum-=root.val;
        path.add(root.val);
        if(root.left==null&&root.right==null&&targetSum==0){
            res.add(new ArrayList<>(path));
        }
        dfs(root.left,targetSum);
        dfs(root.right,targetSum);
        path.remove(path.size()-1);

    }
}
