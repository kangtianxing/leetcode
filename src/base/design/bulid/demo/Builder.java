package base.design.bulid.demo;

/**
 * @author ktx
 * @data 2022-06-18 20:46
 */
public abstract class Builder {

    abstract void buildBoard(String board);
    abstract void buildDisplay(String display);
    abstract void buildOs();
    abstract Computer build();

}
