package base.java.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value = ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SxtAnnotation01 {
    String studentName() default "";
    int id() default 1;
    String[] school() default  { "清华大学","北京大学"};
}
