package base.design.bulid;

/**
 * @author ktx
 * @data 2022-06-18 20:39
 */
public class ChickenBurger extends Burger {

    @Override
    public float price() {
        return 50.5f;
    }

    @Override
    public String name() {
        return "Chicken Burger";
    }
}
