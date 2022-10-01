package base.design.proxy.jdk;

/**
 * @ClassName RealSubject
 * @Description TODO
 * @Author ktx
 * @Date 2022-09-26 17:18
 * @Version 1.0
 */

/**
 * 实际对象
 */
public class RealSubject implements Subject
{

    /**
     * 你好
     *
     * @param name
     * @return
     */
    public String SayHello(String name)
    {
        return "hello " + name;
    }

    /**
     * 再见
     *
     * @return
     */
    public String SayGoodBye()
    {
        return " good bye ";
    }
}

