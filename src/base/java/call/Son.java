package base.java.call;

/**
 * @ClassName Son
 * @Description TODO
 * @Author ktx
 * @Date 2022-09-24 23:51
 * @Version 1.0
 */
public class Son {
    public void rideTrain(Callable callable){
        try {
            //模拟坐火车
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        callable.call();//到了打电话给妈妈
    }
}
