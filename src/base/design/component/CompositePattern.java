package base.design.component;

/**
 * @ClassName CompositePattern
 * @Description TODO
 * @Author ktx
 * @Date 2022-10-10 17:40
 * @Version 1.0
 */
public class CompositePattern {
    public static void main(String[] args) {
        Composite chia = new Composite();
        chia.add(new City(1000));
        chia.add(new City(100000));

        Composite shanxi = new Composite();
        shanxi.add(new City(12));
        shanxi.add(new City(3333));

        chia.add(shanxi);
        System.out.println(chia.count());
    }
}
