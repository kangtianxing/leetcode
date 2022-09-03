package leetcode.hot100;

/**
 * @ClassName pathSum
 * @Description TODO
 * @Author ktx
 * @Date 2022-09-02 13:26
 * @Version 1.0
 */
public class pathSum {
    //
    public int pathSum(TreeNode root, int sum) {
        if(root==null){
            return 0;
        }
        int ret = rootSum(root,sum);
        ret+=pathSum(root.left,sum);
        ret+=pathSum(root.right,sum);
        return ret;
    }

    private int rootSum(TreeNode root, int sum) {
        int ret = 0;
        if(root==null){
            return 0;
        }
        int val = root.val;
        if(val==sum){
            ret++;
        }
        ret+=rootSum(root.left,sum-val);
        ret+=rootSum(root.right,sum-val);
        return ret;
    }
}
