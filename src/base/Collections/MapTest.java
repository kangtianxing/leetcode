package base.Collections;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @ClassName MapTest
 * @Description 遍历Hashmap的几种方式
 * @Author ktx
 * @Date 2022-07-09 22:56
 * @Version 1.0
 */
public class MapTest {
    public static void main(String[] args) {
        testKeySet();

    }
    public static void testStream1(){
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1,"java");
        map.put(2,"jdk");
        map.put(3,"spring ");

        map.entrySet().stream().forEach((entry)->{
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        });
    }
    public static void testLambda(){
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1,"java");
        map.put(2,"jdk");
        map.put(3,"spring ");

        map.forEach((key,value)->{
            System.out.println(key);
            System.out.println(value);
        });
    }
    public static void testForeachKeySet(){
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1,"java");
        map.put(2,"jdk");
        map.put(3,"spring ");

        for (Integer key : map.keySet()) {
            System.out.print(key);
            System.out.print(map.get(key));
        }
    }
    public static void testForeachEntrySet(){
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1,"java");
        map.put(2,"jdk");
        map.put(3,"spring ");

        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.print(entry.getKey());
            System.out.print(entry.getValue());
        }
    }
    public static void testKeySet(){
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1,"java");
        map.put(2,"jdk");
        map.put(3,"spring ");

        Iterator<Integer> iterator = map.keySet().iterator();
        while (iterator.hasNext()){
            Integer key = iterator.next();
            System.out.println(key);
            System.out.println(map.get(key));
        }
    }
    public static void testEntrySet(){
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1,"java");
        map.put(2,"jdk");
        map.put(3,"spring ");

        Iterator<Map.Entry<Integer, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Integer, String> entry = iterator.next();
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
    }
}
