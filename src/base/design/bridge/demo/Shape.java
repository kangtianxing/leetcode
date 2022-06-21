package base.design.bridge.demo;

/**
 * @author ktx
 * @data 2022-06-21 14:53
 */
public abstract class Shape {
    Color color;

    public void setColor(Color color) {
        this.color = color;
    }

    public abstract void draw();

}
