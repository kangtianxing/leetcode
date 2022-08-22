package base.design.template;

/**
 * @ClassName TemplateMethod
 * @Description TODO
 * @Author ktx
 * @Date 2022-08-22 16:48
 * @Version 1.0
 */
public class TemplateMethod {
    public static void main(String[] args) {

        AbstractClient client = new Client("张三");

        client.TemplateMethod();

    }
}
