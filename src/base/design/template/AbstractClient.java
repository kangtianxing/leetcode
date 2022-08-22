package base.design.template;

/**
 * @ClassName AbstractClient
 * @Description TODO
 * @Author ktx
 * @Date 2022-08-22 16:46
 * @Version 1.0
 */
public abstract class AbstractClient {
    public String name;

    public AbstractClient(String name) {

    }

    public void registration(){
        System.out.println(name+"正在挂号");
    }

    public void queueUp(){
        System.out.println(name+"正在排队");
    }
    /**
     * 具体行为，交由子类实现
     */
    public abstract void behavior();

    /**
     * 评价方法，交由子类实现
     */
    public abstract void evaluate();

    /**
     * 钩子函数
     */
    public void hookMethod(){
        System.out.println("钩子函数，默认实现");
    }

    public void TemplateMethod(){
        registration();
        queueUp();
        behavior();
        evaluate();
        hookMethod();
    }
}
