package base.design.abstractFactory;

/**
 * @author ktx
 * @data 2022-06-18 19:50
 */
public class Red implements Color {

    @Override
    public void fill() {
        System.out.println("Inside Red::fill() method.");
    }
}
