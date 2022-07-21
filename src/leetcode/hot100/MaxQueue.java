package leetcode.hot100;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @ClassName MaxQueue
 * @Description 队列的最大值
 * 用两个栈组合实现一个可以O(1)获取最大/最小值的栈
 * 用两个队列组合实现一个可以O(1)获取最大/最小值队列
 * 其核心都是：使用辅助栈/辅助队列，加入元素时维护单调结构，删除元素时进行同步
 * 对于栈来说，维护单调结构和同步动作在一头进行；对于队列来说，维护单调结构和同步动作在两头进行。
 * @Author ktx
 * @Date 2022-07-21 18:02
 * @Version 1.0
 */
public class MaxQueue {
    private Deque<Integer> queue;
    private Deque<Integer> deque;
    public MaxQueue() {
        queue = new ArrayDeque<>();
        deque = new ArrayDeque<>();
    }

    public int max_value() {
        return deque.isEmpty()?-1:deque.peekFirst();
    }

    public void push_back(int value) {
        queue.offer(value);
        while (!deque.isEmpty()&&value>deque.peekLast()){
            deque.removeLast();
        }
        deque.addLast(value);
    }

    public int pop_front() {
        if(queue.isEmpty()){
            return -1;
        }
        int value = queue.poll();
        if(deque.peekFirst()==value){
            deque.removeFirst();
        }
        return value;
    }
}
