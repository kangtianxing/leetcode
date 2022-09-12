package base.juc.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName SynchronizedExample
 * @Description TODO
 * @Author ktx
 * @Date 2022-09-10 14:59
 * @Version 1.0
 */
public class SynchronizedExample {
    public void func1(){
        synchronized (this) {
            for (int i = 0; i < 10; i++) {
                System.out.print(i + " ");
            }
        }
    }

    public static void main(String[] args) {

        SynchronizedExample e1 = new SynchronizedExample();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> e1.func1());
        executorService.execute(() -> e1.func1());
    }
}
