package base.design.abstractFactory;

/**
 * @author ktx
 * @data 2022-06-18 19:51
 */
public class Green implements Color {

    @Override
    public void fill() {
        System.out.println("Inside Green::fill() method.");
    }
}
