package leetcode.hot100;

import java.util.Stack;

/**
 * @ClassName asteroidCollision
 * @Description TODO
 * @Author ktx
 * @Date 2022-07-13 9:29
 * @Version 1.0
 */
public class asteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int asteroid : asteroids) {
            boolean flag = true;
            while (!stack.isEmpty()){
                Integer peek = stack.peek();
                if(peek>0&&asteroid<0){
                    if(Math.abs(peek)>Math.abs(asteroid)){
                        break;
                    }else if(Math.abs(peek)==Math.abs(asteroid)){
                        stack.pop();
                        flag = false;
                        break;
                    }else {
                        stack.pop();
                    }
                }else {
                    stack.push(asteroid);
                    break;
                }
            }
            if(stack.isEmpty()&&flag){
                stack.push(asteroid);
            }
        }
        if(stack.isEmpty()){
            return new int[]{};
        }
        int size = stack.size();
        int[] ans = new int[size];
        for (int i = size - 1; i >= 0; i--) {
            ans[i] = stack.pop();
        }
        return ans;

    }

    public static void main(String[] args) {
        int[] arr = {-8,8};
        asteroidCollision asteroidCollision = new asteroidCollision();
        int[] ints = asteroidCollision.asteroidCollision(arr);

    }
}
