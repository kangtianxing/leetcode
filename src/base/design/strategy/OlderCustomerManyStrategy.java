package base.design.strategy;

/**
 * @author ktx
 * @data 2022-06-24 13:57
 */
public class OlderCustomerManyStrategy  implements Strategy {
    @Override
    public double getPrice(double standardPrices) {
        System.out.println("打8折，原价");
        return standardPrices * 0.8;
    }
}
