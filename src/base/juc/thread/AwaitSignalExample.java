package base.juc.thread;

import java.lang.ref.PhantomReference;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName AwaitSignalExample
 * @Description TODO
 * @Author ktx
 * @Date 2022-09-10 15:13
 * @Version 1.0
 */
public class AwaitSignalExample {

    private Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    public void before(){
        lock.lock();
        try {
            System.out.println("before");
            condition.signalAll();
        }finally {
            lock.unlock();
        }
    }
    public void after(){
        lock.lock();
        try {
            condition.await();
            System.out.println("after");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        AwaitSignalExample example = new AwaitSignalExample();
        executorService.execute(()->example.after());
        executorService.execute(()->example.before());
    }
}
