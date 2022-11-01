package base.juc.result.countdownLatch;

import base.juc.result.Result;

import java.util.Vector;
import java.util.concurrent.CountDownLatch;

/**
 * @ClassName MainThread
 * @Description TODO
 * @Author ktx
 * @Date 2022-11-01 10:55
 * @Version 1.0
 */
public class MainThread {
    public static void main(String[] args) throws InterruptedException {
        Vector<Result> vectors = new Vector<>();
        final CountDownLatch countDownLatch = new CountDownLatch(5);

        // 启动多个工作线程
        for (int i = 0; i < 5; i++) {
            WorkThread workThread = new WorkThread(countDownLatch);
            workThread.init(vectors);
            workThread.start();
        }
        System.out.println("主线程等待工作线程执行");
        countDownLatch.await();
        for (int i=0; i<vectors.size(); i++) {
            System.out.println(vectors.get(i).getValue());
        }
    }
}
