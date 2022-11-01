package base.juc.result;

/**
 * @ClassName MainThread
 * @Description TODO
 * @Author ktx
 * @Date 2022-11-01 10:49
 * @Version 1.0
 */
public class MainThread {
    public static void main(String[] args) throws InterruptedException {
        Result result = new Result();
        WorkThread workThread = new WorkThread();
        workThread.init(result);
        System.out.println("线程启动");
        workThread.start();
        System.out.println("线程等待");
        // 等待work线程运行完再继续运行
        workThread.join();
        System.out.println("线程执行结果："+result.getValue());
    }
}
