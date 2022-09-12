package base.juc.thread;

import java.net.PortUnreachableException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName SiSuo
 * @Description TODO
 * @Author ktx
 * @Date 2022-09-07 9:37
 * @Version 1.0
 */
public class SiSuo {
    private final Object lockA = new Object();
    private final Object lockB = new Object();
    public void a(){
        synchronized (lockA){
            synchronized (lockB){
                System.out.println("function A");
            }
        }
    }
    public void b() {
        synchronized (lockA) {
            synchronized (lockB) {
                System.out.println("function b");
            }
        }
    }
}
