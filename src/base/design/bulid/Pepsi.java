package base.design.bulid;

/**
 * @author ktx
 * @data 2022-06-18 20:39
 */
public class Pepsi extends ColdDrink {

    @Override
    public float price() {
        return 35.0f;
    }

    @Override
    public String name() {
        return "Pepsi";
    }
}
