package base.juc.thread;

/**
 * @ClassName JoinExample
 * @Description TODO
 * @Author ktx
 * @Date 2022-09-10 15:10
 * @Version 1.0
 */
public class JoinExample {
    private class A extends Thread{
        @Override
        public void run() {
            System.out.println("A");
        }
    }

    private class B extends Thread{
        private A a;
        B(A a) {
            this.a = a;
        }

        @Override
        public void run(){

            try {
                a.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("B");
        }
    }
    public void test() {
        A a = new A();
        B b = new B(a);
        b.start();
        a.start();
    }


    public static void main(String[] args) {
        JoinExample example = new JoinExample();
        example.test();
    }
}
