package leetcode.hot100;

/**
 * @ClassName isSameTree
 * @Description TODO
 * @Author ktx
 * @Date 2022-09-28 10:42
 * @Version 1.0
 */
public class isSameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null&&q!=null){
            return false;
        }
        if(p!=null&&q!=null){
            return false;
        }
        if(p==null&&q==null){
            return true;
        }
        if(p.val!= q.val){
            return false;
        }
        boolean left = isSameTree(p.left,q.left);
        boolean right = isSameTree(p.right,q.right);
        return left&&right;
    }
}
