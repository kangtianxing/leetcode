package base.juc.poll;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName TestPool
 * @Description TODO
 * @Author ktx
 * @Date 2022-10-03 14:54
 * @Version 1.0
 */
public class TestPool {
}

class ThreadPool{
    private BlockingQueue<Runnable> taskQueue;

    private HashSet<Worker> workers = new HashSet();


    private int coreSize;

    private long timeout;

    private TimeUnit timeUnit;

    // 执行任务
    public void execute(Runnable task){
        // 当任务数没有超过coreSize
        synchronized (workers){
            if(workers.size()<coreSize){
                Worker worker = new Worker(task);
                workers.add(worker);
                worker.start();
            }else {
                taskQueue.put(task);
            }
        }
    }

    public ThreadPool(int coreSize, long timeout, TimeUnit timeUnit,int queueCapacity) {
        this.coreSize = coreSize;
        this.timeout = timeout;
        this.timeUnit = timeUnit;
        this.taskQueue = new BlockingQueue<>(queueCapacity);
    }

    class Worker extends Thread{
        private Runnable task;

        public Worker( Runnable runnable) {
            this.task = runnable;
        }

        @Override
        public void run() {
            // 执行任务
            while (task!=null||(task=taskQueue.take())!=null){
                try {
                    task.run();
                }catch (Exception e){

                }finally {
                    task = null;
                }
            }
            synchronized (workers){
                workers.remove(this);
            }
        }
    }
}


class BlockingQueue<T>{
    private Deque<T> deque = new ArrayDeque();

    private ReentrantLock lock = new ReentrantLock();

    private Condition fullWaitSet = lock.newCondition();

    private Condition emptyWaitSet = lock.newCondition();

    private int capacity;

    public BlockingQueue(int capacity) {
        this.capacity = capacity;
    }

    public T pull(long timeout, TimeUnit unit){
        lock.lock();
        try {
            long nonos = unit.toNanos(timeout);

            while (deque.isEmpty()){
                try {
                    if(nonos<0){
                        return null;
                    }
                    nonos = emptyWaitSet.awaitNanos(nonos);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            T t = deque.removeFirst();
            fullWaitSet.signal();
            return t;
        }finally {
            lock.unlock();
        }
    }

    public T take(){
        lock.lock();
        try {
            while (deque.isEmpty()){
                try {
                    emptyWaitSet.await();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            T t = deque.removeFirst();
            fullWaitSet.signal();
            return t;
        }finally {
            lock.unlock();
        }
    }

    public void put(T element){
        lock.lock();
        try {
            while (deque.size()==capacity){
                try {
                    fullWaitSet.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            deque.addLast(element);
            emptyWaitSet.signal();
        }finally {
            lock.unlock();
        }
    }

    public int size(){
        lock.lock();
        try {
            return deque.size();
        }finally {
            lock.unlock();
        }
    }
}