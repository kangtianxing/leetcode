package base.juc.thread;

/**
 * @ClassName Demo
 * @Description TODO
 * @Author ktx
 * @Date 2022-07-21 23:02
 * @Version 1.0
 */
public class Demo {
    public static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("MyThread");
        }
    }

    public static class MyThread1 implements Runnable {
        @Override
        public void run() {
            System.out.println("MyThread");
        }
    }

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();

        new Thread(()->{
            System.out.println("java8弥明内部类");
        }).start();
    }
}
