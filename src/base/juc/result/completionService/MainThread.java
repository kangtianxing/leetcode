package base.juc.result.completionService;

import base.juc.result.Result;

import java.util.Date;
import java.util.concurrent.*;

/**
 * @ClassName MainThread
 * @Description TODO
 * @Author ktx
 * @Date 2022-11-01 11:06
 * @Version 1.0
 */
public class MainThread {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService exec = new ThreadPoolExecutor(10, 20, 1000, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<Runnable>(5), Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy());

        //定义一个阻塞队列
        BlockingQueue<Future<Result>> futureQueue =    new LinkedBlockingQueue<Future<Result>>();

        //传入ExecutorService与阻塞队列，构造一个completionService
        CompletionService<Result> completionService = new ExecutorCompletionService<Result>(
                exec,futureQueue);

        for(int i=0;i<10;i++) {

            completionService.submit(new WorkThread(i));
        }

        for(int i=0;i<10;i++) {
            Result res = completionService.take().get();//注意阻塞队列take操作，如果获取不到数据时处于阻塞状态的
            System.out.println(new Date()+ "--"+res.getValue());
        }
    }
}
