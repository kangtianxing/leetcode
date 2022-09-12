package base.juc.poll;

import java.util.concurrent.*;

/**
 * @ClassName Test
 * @Description TODO
 * @Author ktx
 * @Date 2022-09-12 21:53
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        ExecutorService es = Executors.newCachedThreadPool();
        Future<String> future = es.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return "future result";
            }
        });

        try {
            String result = future.get();
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
