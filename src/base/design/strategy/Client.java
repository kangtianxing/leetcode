package base.design.strategy;

/**
 * @author ktx
 * @data 2022-06-24 14:00
 */
public class Client {
    public static void main(String[] args) {
        Strategy s1 = new OlderCustomerManyStrategy();
        Context context = new Context(s1);
        context.pringPrice(998);
    }
}
