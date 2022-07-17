package base.interview.xinghuan;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

/**
 * @ClassName Main
 * @Description TODO
 * @Author ktx
 * @Date 2022-07-16 14:14
 * @Version 1.0
 */
public class Main {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int t = Integer.parseInt(scanner.nextLine());
//        while (t-->0){
//            int n = Integer.parseInt(scanner.nextLine());
//            int[] arr = new int[n];
//            for (int i = 0;i<n;i++){
//                arr[i] = scanner.nextInt();
//            }
//        }
        int[] arr = {1,6,3,4,5,6};
        int result = getResult1(arr);
        System.out.println(result);
    }
    static int getResult(int[] arr){
        int n = arr.length;
        int result = 0;
        for(int i = 1;i<n;i++){
            for (int j = 0;j<i;j++){
                if(arr[i]-arr[j]==i-j){
                    result++;
                }
            }
        }
        return result;
    }
    static int getResult1(int[] arr){
        Map<Integer,Integer> map = new HashMap<>();
        int n = arr.length;
        int sum = 0;
        for (int i = 0;i<n;i++){
            map.put(arr[i]-i,map.getOrDefault(arr[i]-i,0)+1);
        }
        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Integer, Integer> next = iterator.next();
            sum+=(next.getValue()*(next.getValue()-1))/2;
        }
        return sum;
    }
}
