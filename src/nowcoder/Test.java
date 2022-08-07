package nowcoder;

/**
 * @ClassName Test
 * @Description TODO
 * @Author ktx
 * @Date 2022-08-03 19:26
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        Integer i = new Integer(42);
        Long I = new Long(42);
        Double d = new Double(42.0);
        System.out.println(i.equals(d));
        System.out.println(d.equals(i));
        System.out.println(i.equals(42));

    }
}
