package leetcode.hot100;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @ClassName MedianFinder
 * @Description 中位数
 * @Author ktx
 * @Date 2022-08-30 11:43
 * @Version 1.0
 */
public class MedianFinder {
    private PriorityQueue<Integer> maxHeap;
    private PriorityQueue<Integer> minHeap;
    /** initialize your data structure here. */
    public MedianFinder() {
        maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        minHeap = new PriorityQueue<>(Integer::compareTo);
    }
    public void addNum(int num){
        if(maxHeap.isEmpty()||maxHeap.peek()>num){
            maxHeap.offer(num);
        }else {
            minHeap.offer(num);
        }
        int size1 = maxHeap.size();
        int size2 = minHeap.size();
        if(size1-size2>0){
            minHeap.offer(maxHeap.poll());
        }else {
            maxHeap.offer(minHeap.poll());
        }
    }
    public double findMedian(){
        int size1 = maxHeap.size();
        int size2 = minHeap.size();
        return size1==size2
                ?(maxHeap.peek()+minHeap.peek())*1.0/2:
                (size1>size2?maxHeap.peek():minHeap.peek());
    }

}
