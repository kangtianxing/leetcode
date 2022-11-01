package base.juc.result.countdownLatch;

import base.juc.result.Result;
import base.juc.thread.CountDownLatchDemo;

import java.util.Vector;
import java.util.concurrent.CountDownLatch;

/**
 * @ClassName WorkThread
 * @Description TODO
 * @Author ktx
 * @Date 2022-11-01 10:53
 * @Version 1.0
 */
public class WorkThread extends Thread {
    private Vector<Result> vectors ;
    private CountDownLatch countDownLatch;
    public WorkThread(CountDownLatch countDownLatch) {
        this.countDownLatch=countDownLatch;
    }

    public void init(Vector<Result> vectors) {
        this.vectors = vectors;
    }

    public void run() {
        try {
            Thread.sleep(1000*3);//模拟程序执行
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Result result = new Result();
        result.setValue(Thread.currentThread().getName()+"线程执行完毕，输出结果");
        vectors.add(result);//结果放入Vector中
        countDownLatch.countDown();
    }

}
