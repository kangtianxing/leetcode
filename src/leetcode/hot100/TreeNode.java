package leetcode.hot100;

/**
 * @ClassName TreeNode
 * @Description TODO
 * @Author ktx
 * @Date 2022-07-25 22:47
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
