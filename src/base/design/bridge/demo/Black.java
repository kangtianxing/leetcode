package base.design.bridge.demo;

/**
 * @author ktx
 * @data 2022-06-21 14:56
 */
public class Black implements Color{

    public void bepaint(String shape) {
        System.out.println("黑色的" + shape);
    }
}
