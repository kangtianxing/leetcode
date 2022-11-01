package base.design.flyweight.demo;

/**
 * @ClassName BikeFlyWeight
 * @Description TODO
 * @Author ktx
 * @Date 2022-10-10 17:59
 * @Version 1.0
 */
public abstract class BikeFlyWeight {

    //内部状态
    protected Integer state = 0;  // 0是未使用，1是使用中

    // 外部
    abstract void ride(String userName);
    abstract void back();

    public Integer getState() {
        return state;
    }
}
