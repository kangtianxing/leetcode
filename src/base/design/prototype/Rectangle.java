package base.design.prototype;

/**
 * @author ktx
 * @data 2022-06-18 21:09
 */
public class Rectangle extends Shape {

    public Rectangle(){
        type = "Rectangle";
    }

    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}
