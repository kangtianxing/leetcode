package base.design.decorator;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author ktx
 * @data 2022-06-22 13:45
 */
public class Client {
    public static void main(String[] args) {
        Car car = new Car();
        car.move();
        System.out.println("添加新功能");
        FlyCar flyCar = new FlyCar(car);
        flyCar.move();

        System.out.println("新增新购功能，水里游");
        WaterCar waterCar = new WaterCar(flyCar);
        waterCar.move();

    }
}
