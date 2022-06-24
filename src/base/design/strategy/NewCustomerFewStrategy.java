package base.design.strategy;

/**
 * @author ktx
 * @data 2022-06-24 13:55
 */
public class NewCustomerFewStrategy implements Strategy {
    @Override
    public double getPrice(double standardPrices) {
        System.out.println("不打折，原价");
        return standardPrices;
    }
}
