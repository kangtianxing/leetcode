package base.test.inter;

/**
 * @ClassName Test
 * @Description TODO
 * @Author ktx
 * @Date 2022-07-10 12:07
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(Math.min(Double.MIN_VALUE,0.0d));
        returnTryExec();
        returnCatchExec();
        exitTryExec();
        exitCatchExec();
    }

    public static int returnTryExec() {
        try {
            return 0;
        } catch (Exception e) {
        } finally {
            System.out.println("finally returnTryExec");
            return -1;
        }
    }

    public static int returnCatchExec() {
        try { } catch (Exception e) {
            return 0;
        } finally {
            System.out.println("finally returnCatchExec");
            return -1;
        }
    }

    public static void exitTryExec() {
        try {
            System.exit(0);
        } catch (Exception e) {
        } finally {
            System.out.println("finally exitTryExec");
        }
    }

    public static void exitCatchExec() {
        try { } catch (Exception e) {
            System.exit(0);
        } finally {
            System.out.println("finally exitCatchExec");
        }
    }
}
