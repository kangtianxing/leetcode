package leetcode.hot100;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName pathSum437
 * @Description TODO
 * @Author ktx
 * @Date 2022-09-03 12:23
 * @Version 1.0
 */
public class pathSum437 {

//    public int pathSum(TreeNode root, int targetSum) {
//        if(root==null){
//            return 0;
//        }
//        int ret = rootSum(root,targetSum);
//        ret+=pathSum(root.left,targetSum);
//        ret+=pathSum(root.right,targetSum);
//        return  ret;
//    }
//
//    private int rootSum(TreeNode root, int targetSum) {
//        int ret = 0;
//        if(root==null){
//            return 0;
//        }
//        int val = root.val;
//        if(val==targetSum){
//            ret++;
//        }
//        ret+=rootSum(root.left,targetSum-root.val);
//        ret+=rootSum(root.right,targetSum-root.val);
//        return ret;
//    }


    Map<Integer,Integer> mem = new HashMap<>();
    int target;
    public int pathSum(TreeNode root,int targetSum){
        target = targetSum;
        mem.put(0,1);
        return dfs(root,0);
    }

    private int dfs(TreeNode root, int curSum) {
        if(root==null)return 0;
        curSum+=root.val;//得到当前前缀树的值
        int res = 0;
        res =  mem.getOrDefault(curSum-target,0);//得到我们想要前缀树的个数，想要前缀树值就是当前前缀树值减去目标值
        mem.put(curSum,mem.getOrDefault(curSum,0)+1);// 将当前前缀树的值保存
        int left = dfs(root.left,curSum);
        int right = dfs(root.right,curSum);
        mem.put(curSum,mem.get(curSum)-1);
        return res+left+right;
    }
}
