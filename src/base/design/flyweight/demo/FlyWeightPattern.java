package base.design.flyweight.demo;

/**
 * @ClassName FlyWeightPattern
 * @Description TODO
 * @Author ktx
 * @Date 2022-10-10 19:29
 * @Version 1.0
 */
public class FlyWeightPattern {
    public static void main(String[] args) {
        BikeFlyWeight bike = BikeFlyWeightFactory.getInstance().getBike();
        bike.ride("ZhangSan");
        BikeFlyWeight bike2 = BikeFlyWeightFactory.getInstance().getBike();
        bike2.ride("zhaoSi");
        bike2.back();

        System.out.println(bike==bike2);
    }
}
