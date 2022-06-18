package base.design.factory;

/**
 * @author ktx
 * @data 2022-06-18 19:43
 */
public class Rectangle implements Shape {

    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}