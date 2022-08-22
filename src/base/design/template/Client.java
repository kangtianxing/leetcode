package base.design.template;

/**
 * @ClassName Client
 * @Description TODO
 * @Author ktx
 * @Date 2022-08-22 16:47
 * @Version 1.0
 */
public class Client extends AbstractClient{
    public Client(String name) {
        super(name);
    }

    @Override
    public void behavior() {
        System.out.println(name+"正在取钱");
    }

    @Override
    public void evaluate() {
        System.out.println(name+"给银行打出了五星好评");
    }

    //重写钩子函数，实现给银行工作人员打分
    @Override
    public void hookMethod() {
        System.out.println(name+"给银行工作人员打了100分");
    }
}
