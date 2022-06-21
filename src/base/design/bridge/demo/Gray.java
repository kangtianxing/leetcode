package base.design.bridge.demo;

/**
 * @author ktx
 * @data 2022-06-21 14:55
 */
public class Gray implements Color{

    public void bepaint(String shape) {
        System.out.println("灰色的" + shape);
    }
}
