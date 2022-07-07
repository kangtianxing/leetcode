package base.test.function;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

/**
 * @author ktx
 * @data 2022-07-07 21:53
 */
public class Test {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("afgdffadfads");
        list.add("@22");
        list.add("fasfetgg");
        String collect = list.stream()
                .filter(i -> !isNum(i))
                .filter(i -> i.length() > 5)
                .map(i -> i.toLowerCase())
                .distinct()
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.joining("%%"));
        System.out.println(collect);
    }
    public static boolean isNum(String str){
        for (int i = 0;i<str.length();i++){
            if(!Character.isDigit(str.charAt(i))){
                return false;
            }
        }
        return true;
    }
}
