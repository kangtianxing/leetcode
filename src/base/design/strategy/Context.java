package base.design.strategy;

/**
 * @author ktx
 * @data 2022-06-24 13:58
 */
public class Context {
    private Strategy strategy;  // 当前采用的算法对象

    public Context(Strategy strategy) {
        super();
        this.strategy = strategy;
    }

    public Strategy getStrategy() {
        return strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void pringPrice(double s){
        System.out.println("你该报价+"+strategy.getPrice(s));
    }
}
