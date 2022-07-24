package leetcode.hot100;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * @ClassName generateParenthesis
 * @Description 生成括号
 * @Author ktx
 * @Date 2022-07-23 10:28
 * @Version 1.0
 */
public class generateParenthesis {
    /*
     * 【回溯算法】
     * 思路 ：其实这是很典型的需要减枝的回溯算法，应该不难想到
     *
     * String tempString是暂存串
     * int L, int R 记录左右括号的个数，是用于减枝的（右括号不可能多于左括号）
     *
     * 其实，剪枝的条件（右括号不可能多于左括号）也是再给出现一个有效串做铺垫：
     * 	如果出现left==right，则这串不一定有效
     * 	当限制了右括号不可能多于左括号时，如果出现left==right则一定是right追上了left，则这串一定有效
     *
     * 这就是【左右括号计数】解决括号匹配问题的思路————抛开栈的一个新思路
     */
    public List<String> generateParenthesis(int n) {
        traceBack(n, "", 0, 0);
        return resList;
    }

    private void traceBack(int n, String tempString, int L, int R) {
        if(R+L==2*n){
            if(R==n&&L==n){
                resList.add(tempString.toString());
                return;
            }else {
                return;
            }
        }
        if(L<R){
            return;
        }
        traceBack(n,tempString+"(",L+1,R);
        traceBack(n,tempString+")",L,R+1);
    }

    public List<String> resList = new ArrayList<>();

}
