package base.design.decorator.demo;

/**
 * @author ktx
 * @data 2022-06-22 15:02
 */
public class Rectangle implements Shape {

    @Override
    public void draw() {
        System.out.println("Shape: Rectangle");
    }
}
