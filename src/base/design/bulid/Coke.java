package base.design.bulid;

/**
 * @author ktx
 * @data 2022-06-18 20:39
 */
public class Coke extends ColdDrink {

    @Override
    public float price() {
        return 30.0f;
    }

    @Override
    public String name() {
        return "Coke";
    }
}
