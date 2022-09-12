package base.juc.poll;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @ClassName T3
 * @Description TODO
 * @Author ktx
 * @Date 2022-09-12 22:24
 * @Version 1.0
 */
public class T3 {


    volatile List list = new ArrayList();

    public void add(int i){
        list.add(i);
    }

    public int getSize(){
        return list.size();
    }



    public static void main(String[] args) {
        T3 t = new T3();
        CountDownLatch countDownLatch = new CountDownLatch(1);

        new Thread(() -> {
            System.out.println("t2 start");
            if(t.getSize() != 5){
                try {
                    countDownLatch.await();
                    System.out.println("t2 end");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"t2").start();

        new Thread(()->{
            System.out.println("t1 start");
            for (int i = 0;i<9;i++){
                t.add(i);
                System.out.println("add"+ i);
                if(t.getSize() == 5){
                    System.out.println("countdown is open");
                    countDownLatch.countDown();
                }
            }
            System.out.println("t1 end");
        },"t1").start();
    }
}
