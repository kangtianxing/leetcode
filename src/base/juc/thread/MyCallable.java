package base.juc.thread;

import base.test.net.TestHttp;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @ClassName MyCallable
 * @Description TODO
 * @Author ktx
 * @Date 2022-09-10 14:53
 * @Version 1.0
 */
public class MyCallable implements Callable<Integer> {
    public Integer call() {
        return 123;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyCallable mc = new MyCallable();
        FutureTask<Integer> ft = new FutureTask<>(mc);
        Thread thread = new Thread(ft);
        thread.start();
        System.out.println(ft.get());
    }
}
