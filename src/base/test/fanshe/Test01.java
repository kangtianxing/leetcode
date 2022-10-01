package base.test.fanshe;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @ClassName Test01
 * @Description TODO
 * @Author ktx
 * @Date 2022-09-16 19:26
 * @Version 1.0
 */
public class Test01 {
    public static void main(String args[]){
        Exam e=new Exam();  //初始化Exam实例
        System.out.println("获取类中所有的属性：");
        Field field[] = e.getClass().getFields();
        for(Field f : field){
            System.out.println(f);
        }
        System.out.println("获取类中所有的方法：");
        Method[] method = e.getClass().getMethods();
        for(Method m : method){
            System.out.println(m);
        }

    }
}
