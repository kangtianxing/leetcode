package base.design.flyweight.demo;

/**
 * @ClassName MoBikeFlyWeight
 * @Description TODO
 * @Author ktx
 * @Date 2022-10-10 18:01
 * @Version 1.0
 */
public class MoBikeFlyWeight extends BikeFlyWeight{

    // 定义新的内部状态，车架号
    private String bikeId;

    public MoBikeFlyWeight(String bikeId) {
        this.bikeId = bikeId;
    }

    @Override
    void ride(String userName) {
        state = 1;
        System.out.println(userName+"骑"+bikeId+"号 自行车");
    }

    @Override
    void back() {
        state = 0;
    }
}
