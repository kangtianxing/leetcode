package leetcode.hot100;

import java.security.KeyPair;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName widthOfBinaryTree
 * @Description TODO
 * @Author ktx
 * @Date 2022-08-27 13:23
 * @Version 1.0
 */
public class widthOfBinaryTree {

    public int widthOfBinaryTree1(TreeNode root) {
        int res = 1;
        List<Pair<TreeNode, Integer>> arr = new ArrayList<Pair<TreeNode, Integer>>();
        arr.add(new Pair<TreeNode, Integer>(root, 1));
        while (!arr.isEmpty()) {
            List<Pair<TreeNode, Integer>> tmp = new ArrayList<Pair<TreeNode, Integer>>();
            for (Pair<TreeNode, Integer> pair : arr) {
                TreeNode node = pair.getKey();
                int index = pair.getValue();
                if (node.left != null) {
                    tmp.add(new Pair<TreeNode, Integer>(node.left, index * 2));
                }
                if (node.right != null) {
                    tmp.add(new Pair<TreeNode, Integer>(node.right, index * 2 + 1));
                }
            }
            res = Math.max(res, arr.get(arr.size() - 1).getValue() - arr.get(0).getValue() + 1);
            arr = tmp;
        }
        return res;
    }

    public int widthOfBinaryTree2(TreeNode root) {
        int res = 1;
        List<Pair<TreeNode,Integer>> arr = new ArrayList<>();
        arr.add(new Pair<>(root,1));
        while (!arr.isEmpty()){
            ArrayList<Pair<TreeNode, Integer>> tmp = new ArrayList<>();
            for (Pair<TreeNode, Integer> pair : arr) {
                TreeNode node = pair.getKey();
                Integer index = pair.getValue();
                if(node.left!=null){
                    tmp.add(new Pair<TreeNode,Integer>(node.left,index*2));
                }
                if(node.right!=null){
                    tmp.add(new Pair<TreeNode,Integer>(node.right,index*2+1));
                }
            }
            res = Math.max(res, arr.get(arr.size() - 1).getValue() - arr.get(0).getValue() + 1);
            arr = tmp;
        }
        return res;
    }

    class Pair <E,T> {
        public E key;
        public T value;

        public Pair(E key) {
            this.key = key;
        }

        public Pair(E key, T value) {
            this.key = key;
            this.value = value;
        }

        public E getKey() {
            return key;
        }

        public void setKey(E key) {
            this.key = key;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        if(root==null){
            return 0;
        }
        int max = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            int curSize = 0;
            for (int i = 0;i<size;i++){
                TreeNode node = queue.poll();
                if(i<size-1){
                    if(node.left!=null){
                        queue.offer(node.left);
                    }
                    curSize++;
                    if(node.right!=null){
                        queue.offer(node.right);
                    }
                    curSize++;
                }else if(i==size-1){
                    if(node.left==null &&node.right!=null){
                        queue.offer(node.right);
                        curSize+=2;
                    }else if(node.left!=null){
                        queue.offer(node.left);
                        curSize+=1;
                        if(node.right!=null){
                            queue.offer(node.right);
                        }
                    }
                }
            }
            max = Math.max(curSize,max);
        }
        return max;
    }
    class Pair1 <TreeNode,Integer> {
        TreeNode curNode;
        Integer size;



    }
}
