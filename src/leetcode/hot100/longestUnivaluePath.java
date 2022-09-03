package leetcode.hot100;

/**
 * @ClassName longestUnivaluePath
 * @Description TODO
 * @Author ktx
 * @Date 2022-09-02 10:12
 * @Version 1.0
 */
public class longestUnivaluePath {

    int res = 0;
    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return res;
    }

    private int dfs(TreeNode root) {
        if(root==null){
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        int left1 = 0;
        int right1 = 0;
        if (root.left != null && root.left.val == root.val) {
            left1 = left + 1;
        }
        if (root.right != null && root.right.val == root.val) {
            right1 = right + 1;
        }
        res = Math.max(res,left1+right1);
        return Math.max(left1,right1);
    }
}
