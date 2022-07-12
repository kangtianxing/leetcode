package base.Collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author ktx
 * @data 2022-07-08 21:40
 */
public class ListTest {
    public static void main(String[] args) {
//        testRemoveList();
        ArrayList<String> list = new ArrayList<>();
        list.add("nihao");
        list.add("lisi");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            if(iterator.next().equals("lisi")){
                iterator.remove();
            }
        }
        for (String element : list) {
            System.out.println(element);
        }
    }
    public static void testAsList(){
        String[] arrays = {"1","2","3"};
        List<String> list = Arrays.asList(arrays);
        list.add("other element");
    }
    public static void testVar(){
        var upList1 = List.of("liu", "zhao", "zhang");
    }
//    public static void testRemoveList(){
//        String[] arrays = {"1","2","3"};
//        List<String> list = new ArrayList<>(Arrays.asList(arrays));
//        for (String str : list) {
//            if(str.equals("1")){
//                list.remove(str);
//            }
//        }
//
//    }


}
