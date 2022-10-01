package base.java.call;

/**
 * @ClassName Mother
 * @Description TODO
 * @Author ktx
 * @Date 2022-09-24 23:50
 * @Version 1.0
 */
public class Mother implements Callable{

    Son son;
    public Mother(Son son)
    {
        this.son=son;
    }

    public void parting1()
    {
        System.out.println("开始执行异步回调函数");
        new Thread(new Runnable() {
            @Override
            public void run() {
                son.rideTrain(Mother.this);
            }
        }).start();
        System.out.println("异步回调函数执行完成");//开启线程处理儿子坐火车的函数，这条打印语句会在回调函数执行完成前执行。
    }
    //表示妈妈和儿子的分别函数，儿子在这期间搭乘火车离开
    public void parting()
    {
        System.out.println("开始执行同步回调函数");
        son.rideTrain(this);
        System.out.println("同步回调函数执行完成");
    }
    @Override
    public void call() {
        System.out.println("儿子到学校了");
    }
}
