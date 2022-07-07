package base.java.annotation;

import java.lang.reflect.Field;

/**
 * @author ktx
 * @data 2022-07-07 22:20
 */
public class Test {

    public static String validate(Object object) throws IllegalAccessException {
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field : fields) {
            if(field.isAnnotationPresent(Length.class)){
                Length length = field.getAnnotation(Length.class);
                field.setAccessible(true);
                int value = ((String) field.get(object)).length();
                if(value<length.min()||value>length.max()){
                    return length.errorMsg();
                }
            }
        }
        return null;
    }
}
