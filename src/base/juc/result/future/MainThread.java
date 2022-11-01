package base.juc.result.future;

import base.juc.result.Result;

import java.util.concurrent.*;

/**
 * @ClassName MainThread
 * @Description TODO
 * @Author ktx
 * @Date 2022-11-01 11:01
 * @Version 1.0
 */
public class MainThread {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService taskPool = new ThreadPoolExecutor(5, 15, 1000, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<>(10), new ThreadPoolExecutor.CallerRunsPolicy());

        Future<Result> future = taskPool.submit(new WorkThread());
        System.out.println("线程池执行工作线程");
        Result result = future.get();//注意这里get操作是阻塞，future仍属于同步返回，主线程需要阻塞等待结果返回
        //result = future.get(3,TimeUnit.SECONDS);//设置阻塞超时时间
        System.out.println(result.getValue());
    }
}
