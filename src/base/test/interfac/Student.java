package base.test.interfac;

/**
 * @ClassName Student
 * @Description TODO
 * @Author ktx
 * @Date 2022-10-06 15:51
 * @Version 1.0
 */
public class Student {
    //学生做课堂练习,并告诉老师
    public void doPractice(BackInterface BackInterface) {
        System.out.println("学生做练习...");
        System.out.println("学生告诉老师做完练习...");
        BackInterface.backMethod();
    }
}
