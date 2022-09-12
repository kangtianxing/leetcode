package inter.tonghuashun;

import inter.wang.Maix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @ClassName Main
 * @Description TODO
 * @Author ktx
 * @Date 2022-09-05 10:31
 * @Version 1.0
 */
public class Main {
    public static void main(String[] args) {

//        List<String> list = new ArrayList<>(Arrays.asList(",",null,"1","0","j","q","k","a"));
//        Iterator<String> iterator = list.iterator();
//        while (iterator.hasNext()){
//            String item = iterator.next();
//            if(item==null||item.equals("x")){
//                list.remove(item);
//            }
//        }
        List<String > list =new ArrayList<>(Arrays.asList("null","this","null"));
        Main main = new Main();
        String filter = main.filter(list);
    }
    public String filter(List<String> list){
        for (String str : list) {
            if("null".equals(str))
                list.remove(str);
        }
        System.out.println(list.get(0));
        return list.get(0);
    }
}
