package base.test.int1;

/**
 * @ClassName Test
 * @Description TODO
 * @Author ktx
 * @Date 2022-08-07 23:53
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {

//        Integer x = new Integer(123);
//        Integer y = new Integer(123);
//        System.out.println(x == y);    // false
        Integer z = Integer.valueOf(123);
        Integer k = Integer.valueOf(123);
        System.out.println(z == k);   // true
    }
}
