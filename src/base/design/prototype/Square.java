package base.design.prototype;

/**
 * @author ktx
 * @data 2022-06-18 21:09
 */
public class Square extends Shape {

    public Square(){
        type = "Square";
    }

    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}
