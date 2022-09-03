package leetcode.hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName binaryTreePaths
 * @Description TODO
 * @Author ktx
 * @Date 2022-09-02 10:29
 * @Version 1.0
 */
public class binaryTreePaths {

    List<String> res = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        dfs(root,"");
        return res;
    }

    private void dfs(TreeNode root, String path) {
        if(root==null){
            return;
        }
        path+=root.val;
        if(root.left==null&&root.right==null){
            res.add(path);
            return;
        }
        dfs(root.left,path+"->");
        dfs(root.right,path+"->");
    }
}
