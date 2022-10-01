package inter.dd;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @ClassName Main2
 * @Description TODO
 * @Author ktx
 * @Date 2022-09-18 15:52
 * @Version 1.0
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        HashMap<Integer,Integer> mapCount = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            mapCount.put(arr[i],mapCount.getOrDefault(arr[i],0)+1);
        }
        int result = 0;
        for (Map.Entry<Integer, Integer> entry : mapCount.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            if(mapCount.get(key-1)!=null){
                value+=mapCount.get(key-1);
            }
            if(mapCount.get(key+1)!=null){
                value+=mapCount.get(key+1);
            }

            result = Math.max(value,result);
        }
        System.out.println(result);
    }
}
