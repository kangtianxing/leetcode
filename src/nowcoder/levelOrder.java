package nowcoder;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName levelOrder
 * @Description TODO
 * @Author ktx
 * @Date 2022-08-22 20:48
 * @Version 1.0
 */
public class levelOrder {
    public int levelOrder(TreeNode root) {
        if(root==null){
            return 0;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        int levelCount = 2;
        int manCount = 0;
        int sum = 1;
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> integers = new ArrayList<>();
            int curLevel = 0;
            for (int i = 0;i<size;i++){
                TreeNode cur = queue.remove();
                integers.add(cur.val);
                if(cur.left!= null){
                    queue.add(cur.left);
                    sum++;
                    curLevel++;
                }
                if(cur.right != null) {
                    queue.add(cur.right);
                    sum++;
                    curLevel++;
                }
            }
            if(curLevel==levelCount){
                levelCount = levelCount*2;
            }else {
                manCount = countMan(levelCount);
            }
        }
        return sum-manCount;
    }

    private int countMan(int levelCount) {
        int max = 0;
        levelCount/=2;
        while (levelCount!=0){
            max+=levelCount;
            levelCount/=2;
        }
        return max;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.left.left = new TreeNode(5);
        root.right.left= new TreeNode(6);
        levelOrder levelOrder = new levelOrder();
        int i = levelOrder.levelOrder(root);
        System.out.println(i);
    }
}
