package base.design.decorator;

import javax.swing.*;

/**
 * @author ktx
 * @data 2022-06-22 13:40
 */
//抽象构建
public interface ICar {
    void move();
}

// 具体构建脚色
class Car implements ICar{

    @Override
    public void move() {
        System.out.println("陆地上跑");
    }
}

class SuperCar implements ICar{

    private ICar car;

    public SuperCar(ICar car) {
        super();
        this.car = car;
    }

    @Override
    public void move() {
        car.move();
    }
}

class FlyCar extends SuperCar{

    public FlyCar(ICar car) {
        super(car);
    }
    public void fly(){
        System.out.println("天上飞");
    }

    @Override
    public void move() {
        super.move();
        fly();
    }
}
class WaterCar extends SuperCar{

    public WaterCar(ICar car) {
        super(car);
    }
    public void water(){
        System.out.println("水里游");
    }

    @Override
    public void move() {
        super.move();
        water();
    }
}
