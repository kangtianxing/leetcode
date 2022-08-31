package leetcode.hot100;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @ClassName validateStackSequences
 * @Description TODO
 * @Author ktx
 * @Date 2022-08-31 10:36
 * @Version 1.0
 */
public class validateStackSequences {
    public boolean validateStackSequences(int[] pushed, int[] popped){
        int n = pushed.length;
        Stack<Integer> stack = new Stack<>();
        int j = 0;
        for (int i = 0;i<n;i++){
            stack.push(pushed[i]);
            while (!stack.isEmpty()&&stack.peek()==popped[j]){
                j++;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
