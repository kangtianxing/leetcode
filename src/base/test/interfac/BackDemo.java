package base.test.interfac;

/**
 * @ClassName BackDemo
 * @Description TODO
 * @Author ktx
 * @Date 2022-10-06 15:54
 * @Version 1.0
 */
public class BackDemo {
    public static void main(String[] args) {
        Teacher teacher = new Teacher(new Student());
        teacher.doEvent();
    }
}
