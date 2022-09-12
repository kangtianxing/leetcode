package base.test;

/**
 * @ClassName Son
 * @Description TODO
 * @Author ktx
 * @Date 2022-09-12 17:54
 * @Version 1.0
 */


public class Son extends Base{
    public void test() {
    }
    public static void main(String[] args) {
        Son son = new Son();
        Base father = son;
//        father.test();
    }
}
