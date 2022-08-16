package base.java.annotation;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName TestMethodAnnotation
 * @Description TODO
 * @Author ktx
 * @Date 2022-08-12 15:07
 * @Version 1.0
 */
public class TestMethodAnnotation {

    @Override
    @MyMethodAnnotation(title = "toStringMethod", description = "override toString method")
    public String toString() {
        return "Override toString method";
    }

    @Deprecated
    @MyMethodAnnotation(title = "old static method", description = "deprecated old static method")
    public static void oldMethod() {
        System.out.println("old method, don't use it.");
    }

    @SuppressWarnings({"unchecked", "deprecation"})
    @MyMethodAnnotation(title = "test method", description = "suppress warning static method")
    public static void genericsTest() throws FileNotFoundException {
        List l = new ArrayList();
        l.add("abc");
        oldMethod();
    }
}
