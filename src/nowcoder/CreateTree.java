package nowcoder;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName CreateTree
 * @Description TODO
 * @Author ktx
 * @Date 2022-08-22 21:26
 * @Version 1.0
 */
public class CreateTree {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,-1,5};
        TreeNode root = createTree(arr);
        System.out.println(root);
        List<Integer> list = preorderTraversal(root);
        for (Integer integer : list) {
            System.out.println(integer);
        }

    }

    private static TreeNode createTree(int[] arr) {
        TreeNode root = null;
        root = preOrder(root,arr,0);
        return root;
    }
    public static List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> lists = new ArrayList<>();
        preorder(root,lists);
        return lists;
    }

    private static void preorder(TreeNode root, ArrayList<Integer> lists) {
        if(root == null) return;
        lists.add(root.val);
        preorder(root.left,lists);
        preorder(root.right,lists);

    }
    private static TreeNode preOrder(TreeNode node, int[] arr, int index) {
        if(index>arr.length-1||arr[index]==-1){
            return null;
        }
        if(node==null){
            node = new TreeNode(arr[index]);
        }
        node.left = preOrder(node.left,arr,index*2+1);
        node.right = preOrder(node.right,arr,index*2+2);
        return node;
    }
}
