package base.java.annotation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
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

    private static void readFile(String filePath) throws MyException {
        File file = new File(filePath);
        String result;
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            while((result = reader.readLine())!=null) {
                System.out.println(result);
            }
        } catch (IOException e) {
            System.out.println("readFile method catch block.");
            MyException ex = new MyException("read file failed.");
            ex.initCause(e);
            throw ex;
        } finally {
            System.out.println("readFile method finally block.");
            if (null != reader) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
