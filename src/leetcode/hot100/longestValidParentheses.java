package leetcode.hot100;

import java.util.Stack;

/**
 * @ClassName longestValidParentheses
 * @Description TODO
 * @Author ktx
 * @Date 2022-07-23 11:23
 * @Version 1.0
 */
public class longestValidParentheses {
    /*
     * 【栈】
     *
     * 我们维护一个栈，值为下标
     * 		每次遇到'('时，毫不犹豫的将其下标入栈，等待被配对弹出；
     * 		每次遇到')'时，就执行一次弹出操作：
     * 				如果这时栈空了，说明没有'('能与其配对，它的下标入栈(除非遇到下一个无法配对的')'，它将永远垫底)
     * 				如果栈不空，则尝试更新maxLen，此时的有效括号长度为此时的小标，与弹出后此时的栈顶的下标之差
     *
     * 理解：
     * 		1.每次'('下标入栈，都是【等待被配对弹出】的；
     * 		    每次')'下标入栈，都说明此时有效串断了，它的下标现在垫底用的，作为【新串开始的前一个字符位置】
     * 		2.一个重要的技巧：先入栈一个-1。这相当于在原串的最前面加了个')'———这不影响结果，而且解决了第一个字符为')'的情况下，pop出错的问题
     * 		3.解决【括号字符串】问题有一个看似奇怪但绝对安全的思路： ')'去配对它左边的第一个'('，然后消掉 ，准没错!!!!!
     * 		4.还是那个重要思路： ')'是有可能作为结束一个有效串的标志的
     * 		5.再理解一下-1吧！它是一个有效串结束的标志，作为参照下标，等价于多出的')'。当下一个')'将其顶替后，它的使命也就结束了
     */
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.add(-1);
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='('){
                stack.add(i);
            }else {
                stack.pop();
                if(stack.isEmpty()){
                    stack.add(i);
                }else {
                    maxLen = Math.max(maxLen,i-stack.peek());
                }
            }
        }
        return maxLen;
    }
    public int longestValidParentheses1(String s) {
        int maxans = 0;
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if(s.charAt(i)==')'){
                if(s.charAt(i-1)=='(') {
                    dp[i] = (i>=2?dp[i-1]:0)+2;
                }else if(i-dp[i-1]>0 &&s.charAt(i - dp[i - 1] - 1) == '('){
                    dp[i] = dp[i-1]+((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                maxans = Math.max(maxans,dp[i]);
            }
        }
        return maxans;
    }
}
