package leetcode.hot100;

/**
 * @ClassName sortedArrayToBST
 * @Description TODO
 * @Author ktx
 * @Date 2022-09-28 10:38
 * @Version 1.0
 */
public class sortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        int len = nums.length;
        return build(nums,0,len-1);
    }

    private TreeNode build(int[] nums, int left, int right) {
        if(left>right)return null;
        int mid = left+(right-left)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = build(nums,left,mid-1);
        root.right = build(nums,mid+1,right);
        return root;
    }

}
