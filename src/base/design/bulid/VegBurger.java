package base.design.bulid;

/**
 * @author ktx
 * @data 2022-06-18 20:39
 */
public class VegBurger extends Burger {

    @Override
    public float price() {
        return 25.0f;
    }

    @Override
    public String name() {
        return "Veg Burger";
    }
}
