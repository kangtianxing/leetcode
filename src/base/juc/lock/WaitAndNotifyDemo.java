package base.juc.lock;

/**
 * @ClassName WaitAndNotifyDemo
 * @Description TODO
 * @Author ktx
 * @Date 2022-09-12 20:28
 * @Version 1.0
 */


class MyThread extends Thread {

    public void run() {
        synchronized (this) {
            System.out.println("before notify");
            notify();
            System.out.println("after notify");
        }
    }
}
public class WaitAndNotifyDemo {

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        synchronized (myThread){
            try {
                myThread.start();
                Thread.sleep(3000);
                System.out.println("before wait");
                myThread.wait();
                System.out.println("after wait");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
