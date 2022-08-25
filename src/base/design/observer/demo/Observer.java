package base.design.observer.demo;

/**
 * @ClassName Observer
 * @Description TODO
 * @Author ktx
 * @Date 2022-08-24 23:03
 * @Version 1.0
 */
public abstract class Observer {
    protected Subject subject;
    public abstract void update();
}
