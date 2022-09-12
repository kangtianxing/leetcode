package base.spring;

/**
 * @ClassName Factory
 * @Description TODO
 * @Author ktx
 * @Date 2022-09-11 11:23
 * @Version 1.0
 */


interface Fruit {
    public abstract void eat();
}
class Apple implements Fruit {
    public void eat(){
        System.out.println("Apple");
    }
}
class Orange implements Fruit {
    public void eat(){
        System.out.println("Orange");
    }
}
 class Factory {

    public static Fruit getInstance(String ClassName){
        Fruit f = null;

        try {
            f=(Fruit)Class.forName(ClassName).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;
    }
}
public class Client{
    public static void main(String[] args) {
        Fruit f = Factory.getInstance("aa");
        if(f!=null){
            f.eat();
        }
    }
}
