package base.design.flyweight.demo;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName BikeFlyWeightFactory
 * @Description TODO
 * @Author ktx
 * @Date 2022-10-10 18:03
 * @Version 1.0
 */
public class BikeFlyWeightFactory {
    private static BikeFlyWeightFactory instance = new BikeFlyWeightFactory();

    private Set<BikeFlyWeight> pool = new HashSet<>();

    public static BikeFlyWeightFactory getInstance() {
        return instance;
    }
    private BikeFlyWeightFactory(){
        for (int i = 0; i < 2; i++) {
            pool.add(new MoBikeFlyWeight(i+"号"));
        }
    }
    public BikeFlyWeight getBike(){
        for (BikeFlyWeight bike : pool) {
            if(bike.getState()==0){
                return bike;
            }
        }
        return null;
    }
}
