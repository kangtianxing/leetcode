package base.test.interfac;

/**
 * @ClassName Teacher
 * @Description TODO
 * @Author ktx
 * @Date 2022-10-06 15:50
 * @Version 1.0
 */
public class Teacher implements BackInterface{

    private Student student;

    public Teacher(Student student){
        this.student = student;
    }

    public void doEvent(){
        System.out.println("老师让学生去做联系");
        student.doPractice(this);
    }

    @Override
    public void backMethod() {
        System.out.println("老师接收到学生做完课堂练习的消息");
    }
}
