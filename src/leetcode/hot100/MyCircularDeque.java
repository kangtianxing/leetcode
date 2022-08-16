package leetcode.hot100;

/**
 * @ClassName MyCircularDeque
 * @Description TODO
 * @Author ktx
 * @Date 2022-08-16 9:45
 * @Version 1.0
 */
public class MyCircularDeque {
    private int[] elements;
    private int rear,front;
    private int capacity;

    public MyCircularDeque(int k) {
        capacity = k+1;
        rear = front = 0;
        elements = new int[k+1];
    }

    public boolean insertFront(int value) {
        if(isFull()){
            return false;
        }
        front = (front-1+capacity)%capacity;
        elements[front] = value;
        return true;
    }

    public boolean insertLast(int value) {
        if(isFull()){
            return false;
        }
        elements[rear] = value;
        rear = (rear + 1) % capacity;
        return true;
    }

    public boolean deleteFront() {
        if(isEmpty()){
            return false;
        }
        front = (front+1)%capacity;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        rear = (rear - 1 + capacity) % capacity;
        return true;

    }

    public int getFront() {
        if(isEmpty()){
            return -1;
        }
        return elements[front];
    }

    public int getRear() {
        if(isEmpty()){
            return -1;
        }
        return elements[(rear - 1 + capacity) % capacity];
    }

    public boolean isEmpty() {
        return rear==front;
    }

    public boolean isFull() {
        return (rear+1)%capacity==front;
    }
}
