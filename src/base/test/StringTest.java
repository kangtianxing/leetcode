package base.test;

import java.lang.reflect.Field;

/**
 * @ClassName StringTest
 * @Description TODO
 * @Author ktx
 * @Date 2022-09-07 11:21
 * @Version 1.0
 */
public class StringTest {
    private static String s1;
    private static String s2;
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        String s = "hydra";
        System.out.println(s+":   "+s.hashCode());
        Field field = String.class.getDeclaredField("value");
        field.setAccessible(true);
        field.set(s,new byte[][]{});
        System.out.println(s+":   "+s.hashCode());
    }
}
