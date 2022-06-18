package base.design.prototype;

/**
 * @author ktx
 * @data 2022-06-18 21:10
 */
public class Circle extends Shape {

    public Circle(){
        type = "Circle";
    }

    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}
