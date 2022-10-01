package base.design.proxy.jdk;

/**
 * @ClassName Subject
 * @Description TODO
 * @Author ktx
 * @Date 2022-09-26 17:18
 * @Version 1.0
 */
public interface Subject {
    /**
     * 你好
     *
     * @param name
     * @return
     */
    public String SayHello(String name);

    /**
     * 再见
     *
     * @return
     */
    public String SayGoodBye();

}
