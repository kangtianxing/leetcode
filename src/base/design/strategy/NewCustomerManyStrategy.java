package base.design.strategy;

/**
 * @author ktx
 * @data 2022-06-24 13:56
 */
public class NewCustomerManyStrategy implements Strategy {
    @Override
    public double getPrice(double standardPrices) {
        System.out.println("打9折，原价");
        return standardPrices*0.9;
    }
}

