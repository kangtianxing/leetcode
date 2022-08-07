package base.design.strategy;

/**
 * @ClassName HelloImpl
 * @Description TODO
 * @Author ktx
 * @Date 2022-08-07 17:47
 * @Version 1.0
 */
public class HelloImpl implements IHello {
    @Override
    public void sayHello() {
        System.out.println("Hello world!");
    }
}
