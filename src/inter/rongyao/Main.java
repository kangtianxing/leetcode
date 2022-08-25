package inter.rongyao;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Map.Entry.comparingByValue;
/**
 * @ClassName Main
 * @Description TODO
 * @Author ktx
 * @Date 2022-08-23 19:01
 * @Version 1.0
 */
public class Main {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String[] splitName = scanner.nextLine().trim().split(",");
        String str = "Tom,Lily,Tom,Lucy,Lucy,Jack";
        String[] splitName = str.trim().split(",");
        TreeMap<String, Integer> map = new TreeMap<>();
        for (String s : splitName) {
            map.put(s,map.getOrDefault(s,0)+1);
        }
        // HashMap的entry放到List中
        List<Map.Entry<String, Integer> > list =
                new LinkedList<Map.Entry<String, Integer> >(map.entrySet());

        //  对List按entry的value排序
        Collections.sort(list, new Comparator<Map.Entry<String, Integer> >() {
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2)
            {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });
        System.out.println(list.get(0).getKey());

    }
}
