package nowcoder;

/**
 * @ClassName TreeNode
 * @Description TODO
 * @Author ktx
 * @Date 2022-08-22 20:51
 * @Version 1.0
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
