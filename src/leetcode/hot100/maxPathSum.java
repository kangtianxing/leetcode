package leetcode.hot100;

/**
 * @ClassName maxPathSum
 * @Description TODO
 * @Author ktx
 * @Date 2022-09-03 13:13
 * @Version 1.0
 */
public class maxPathSum {
    private int res =Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root){
        getMax(root);
        return res;
    }

    private int getMax(TreeNode root) {
        if(root==null){
            return 0;
        }
        int left = Math.max(0,getMax(root.left));
        int right = Math.max(0,getMax(root.right));
        res = Math.max(res,left+right+root.val);
        return Math.max(left+root.val,right+root.val);
    }
}
