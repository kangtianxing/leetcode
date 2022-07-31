package leetcode.hot100;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName maxLevelSum1161
 * @Description TODO
 * @Author ktx
 * @Date 2022-07-31 12:59
 * @Version 1.0
 */
public class maxLevelSum1161 {

    public int maxLevelSum(TreeNode root) {
        Deque<TreeNode> d = new ArrayDeque<>();
        int max = -0x3f3f3f3f, depth = 1, ans = 0;
        d.addLast(root);
        while (!d.isEmpty()) {
            int sz = d.size(), cur = 0;
            while (sz-- > 0) {
                TreeNode t = d.pollFirst();
                if (t.left != null) d.addLast(t.left);
                if (t.right != null) d.addLast(t.right);
                cur += t.val;
            }
            if (cur > max) {
                max = cur; ans = depth;
            }
            depth++;
        }
        return ans;
    }
}
