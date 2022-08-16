package base.java.annotation;

/**
 * @ClassName MyException
 * @Description TODO
 * @Author ktx
 * @Date 2022-08-12 15:38
 * @Version 1.0
 */
public class MyException extends Exception {
    public MyException(){ }
    public MyException(String msg){
        super(msg);
    }
}
