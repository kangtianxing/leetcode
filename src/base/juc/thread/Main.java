package base.juc.thread;

import java.time.LocalDateTime;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName Main
 * @Description TODO
 * @Author ktx
 * @Date 2022-10-13 15:48
 * @Version 1.0
 */
public class Main {

//    @SneakyThrows
    public static void timer() {
        // start timer
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            public void run() {
                System.out.println("timer-task @{}"+ LocalDateTime.now());
            }
        }, 1000);

        // waiting to process(sleep to mock)
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // stop timer
        timer.cancel();
    }
    public static void main(String[] args) {
        timer();
//        Thread t1 = new Thread(new Runnable() {
//            public void run() {
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println(Thread.currentThread().getName() + " run 1");
//            }
//        }, "T1");
//        Thread t2 = new Thread(new Runnable() {
//            public void run() {
//                try {
//                    Thread.sleep(2000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println(Thread.currentThread().getName() + " run 2");
//            }
//        }, "T2");
//        Thread t3 = new Thread(new Runnable() {
//            public void run() {
//                try {
//                    Thread.sleep(3000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println(Thread.currentThread().getName() + " run 3");
//            }
//        }, "T3");
//        ExecutorService executor = Executors.newSingleThreadExecutor();
//        executor.submit(t3);
//        executor.submit(t2);
//        executor.submit(t1);
//        executor.shutdown();
    }

}
