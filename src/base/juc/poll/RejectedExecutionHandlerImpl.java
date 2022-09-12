package base.juc.poll;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @ClassName RejectedExecutionHandlerImpl
 * @Description TODO
 * @Author ktx
 * @Date 2022-09-12 21:10
 * @Version 1.0
 */


public class RejectedExecutionHandlerImpl implements RejectedExecutionHandler {

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println(r.toString() + " is rejected");
    }

}
