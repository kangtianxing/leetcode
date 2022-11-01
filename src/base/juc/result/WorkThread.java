package base.juc.result;

/**
 * @ClassName WorkThread
 * @Description TODO
 * @Author ktx
 * @Date 2022-11-01 10:46
 * @Version 1.0
 */
public class WorkThread extends Thread{
    private Result result ;

    public void init(Result result) {
        this.result = result;
    }

    public void run() {
        try {
            Thread.sleep(1000*10);//模拟程序执行
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        result.setValue("线程执行完毕，输出结果");
    }

}
