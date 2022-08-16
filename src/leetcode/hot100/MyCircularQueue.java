package leetcode.hot100;

/**
 * @ClassName MyCircularQueue
 * @Description TODO
 * @Author ktx
 * @Date 2022-08-16 9:39
 * @Version 1.0
 */
public class MyCircularQueue {

    private int front;
    private int rear;
    private int capacity;
    private int[] elements;

    public MyCircularQueue(int k) {
        capacity = k+1;
        front = 0;
        rear = 0;
        elements = new int[k+1];
    }

    public boolean enQueue(int value) {
        if(isFull()){
            return false;
        }
        elements[rear] = value;
        rear = (rear+1)%capacity;
        return true;
    }

    public boolean deQueue() {
        if(isEmpty()){
            return false;
        }
        front = (front+1)%capacity;
        return true;
    }

    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return elements[front];
    }

    public int Rear() {
        if(isEmpty()){
            return -1;
        }
        return elements[(rear-1+capacity)%capacity];
    }

    public boolean isEmpty() {
        return rear==front;
    }

    public boolean isFull() {
        return ((rear+1)%capacity)==front;
    }
}
