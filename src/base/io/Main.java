package base.io;

/**
 * @ClassName Main
 * @Description TODO
 * @Author ktx
 * @Date 2022-09-10 11:23
 * @Version 1.0
 */
public class Main {


    public static void simpleTryCatch() {
        try {
            testNPE();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void testNPE() {

    }
}
