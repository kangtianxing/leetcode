package base.design.abstractFactory;

/**
 * @author ktx
 * @data 2022-06-18 19:51
 */
public abstract class AbstractFactory {
    public abstract Color getColor(String color);
    public abstract Shape getShape(String shape);
}
