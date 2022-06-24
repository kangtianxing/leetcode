package base.design.mediator;

/**
 * @author ktx
 * @data 2022-06-24 13:23
 */
public class Client {
    public static void main(String[] args) {
        Mediator m = new President();
        Market market = new Market(m);
        Development development = new Development(m);
        Finacial finacial = new Finacial(m);
        market.selfAction();
        market.outAction();
    }
}
