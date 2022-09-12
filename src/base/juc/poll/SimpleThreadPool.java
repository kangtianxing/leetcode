package base.juc.poll;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName SimpleThreadPool
 * @Description TODO
 * @Author ktx
 * @Date 2022-09-12 21:05
 * @Version 1.0
 */
public class SimpleThreadPool {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 10; i++) {
            WorkerThread worker = new WorkerThread("" + i);
            executorService.execute(worker);
        }

        executorService.shutdown(); // This will make the executor accept no new threads and finish all existing threads in the queue
        while (!executorService.isTerminated()) { // Wait until all threads are finish,and also you can use "executor.awaitTermination();" to wait
        }
        System.out.println("Finished all threads");
    }
}
