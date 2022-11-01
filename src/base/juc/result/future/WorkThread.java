package base.juc.result.future;

import base.juc.result.Result;

import java.util.concurrent.Callable;

/**
 * @ClassName WorkThread
 * @Description TODO
 * @Author ktx
 * @Date 2022-11-01 11:01
 * @Version 1.0
 */
public class WorkThread  implements Callable<Result> {
    public Result call() throws Exception {
        Thread.sleep(5000);
        Result result = new Result();
        result.setValue(Thread.currentThread().getName()+"线程执行完毕，输出结果");
        return result;
    }
}
