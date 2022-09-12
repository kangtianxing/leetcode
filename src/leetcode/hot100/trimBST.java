package leetcode.hot100;

/**
 * @ClassName trimBST
 * @Description TODO
 * @Author ktx
 * @Date 2022-09-10 10:18
 * @Version 1.0
 */
public class trimBST {

    public TreeNode trimBST(TreeNode root, int low, int high) {
        if(root==null){
            return null;
        }
        if(root.val<low){
            return trimBST(root.right,low,high);
        }else if(root.val>high){
            return trimBST(root.left,low,high);
        }else {
            root.left = trimBST(root.left,low,high);
            root.right = trimBST(root.right,low,high);
            return root;
        }
    }
}
