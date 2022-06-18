package base.design.bulid.demo;

/**
 * @author ktx
 * @data 2022-06-18 20:47
 */
public class Test {
    public static void main(String[] args){
        Builder builder=new MacBookBuilder();
        Director pcDirector=new Director(builder);
        pcDirector.construct("英特尔主板","Retina显示器");

        Computer computer = builder.build();
        System.out.println(computer.toString());
    }
}
