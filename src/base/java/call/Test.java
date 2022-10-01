package base.java.call;

/**
 * @ClassName Test
 * @Description TODO
 * @Author ktx
 * @Date 2022-09-24 23:53
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        Son jack=new Son();
        Mother mother=new Mother(jack);
        mother.parting();
    }
}
