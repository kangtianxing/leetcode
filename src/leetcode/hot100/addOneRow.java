package leetcode.hot100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName addOneRow
 * @Description TODO
 * @Author ktx
 * @Date 2022-08-05 7:51
 * @Version 1.0
 */
public class addOneRow {

    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth==1){
            return new TreeNode(val,root,null);
        }
        List<TreeNode> curLevel = new ArrayList<>();
        curLevel.add(root);
        for (int i = 1; i < depth - 1; i++) {
            List<TreeNode> tmpt = new ArrayList<>();
            for (TreeNode node : curLevel) {
                if (node.left!=null) {
                    tmpt.add(node.left);
                }
                if (node.right!=null) {
                    tmpt.add(node.right);
                }
            }
            curLevel = tmpt;
        }
        for (TreeNode node : curLevel) {
            node.left = new TreeNode(val,node.left,null);
            node.right = new TreeNode(val,null,node.right);
        }
        return root;
    }

    public static void main(String[] args) {
        int i = 21;
        int j = -1;
        System.out.println(i&j);
    }
}
