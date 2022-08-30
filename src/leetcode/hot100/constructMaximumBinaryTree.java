package leetcode.hot100;

/**
 * @ClassName constructMaximumBinaryTree
 * @Description TODO
 * @Author ktx
 * @Date 2022-08-30 22:46
 * @Version 1.0
 */
public class constructMaximumBinaryTree {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return construct(nums,0,nums.length-1);
    }

    private TreeNode construct(int[] nums, int left, int right) {
        if(left>right){
            return null;
        }
        int best = left;
        for (int i = left+1;i<=right;i++){
            if(nums[i]>nums[best]){
                best = i;
            }
        }
        TreeNode node = new TreeNode(nums[best]);
        node.left = construct(nums,left,best-1);
        node.right = construct(nums,best+1,right);
        return node;
    }
}
