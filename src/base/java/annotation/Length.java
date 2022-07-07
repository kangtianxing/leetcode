package base.java.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Length {
    int min();  // 允许字符串长度的最小值

    int max();  // 允许字符串长度的最大值

    String errorMsg(); // 自定义错误信息


}
