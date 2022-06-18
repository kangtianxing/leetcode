package base.design.proxy.staticProxy;

/**
 * @author ktx
 * @data 2022/6/9 19:59
 */
public class Host implements Rent {
    @Override
    public void rent() {
        System.out.println("房屋出租");
    }
}
