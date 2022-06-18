package base.design.abstractFactory;

/**
 * @author ktx
 * @data 2022-06-18 19:50
 */
public class Square implements Shape {

    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}
