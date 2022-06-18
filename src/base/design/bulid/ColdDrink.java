package base.design.bulid;

/**
 * @author ktx
 * @data 2022-06-18 20:38
 */
public abstract class ColdDrink implements Item {

    @Override
    public Packing packing() {
        return new Bottle();
    }

    @Override
    public abstract float price();
}
