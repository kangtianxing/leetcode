package inter.yuan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @ClassName Main
 * @Description TODO
 * @Author ktx
 * @Date 2022-08-26 19:27
 * @Version 1.0
 */
public class Main {
    public static void main(String[] args) {
        int k = 17;
        int[] arr = {1};
        ArrayList<Integer> list = new ArrayList<>();
        getNum(list,k);
        int[] target = new int[list.size()];
        for (int i = 0; i < target.length; i++) {
            target[i] = list.get(i);
        }
        int i = minWindow(arr, target);
        if(i==Integer.MAX_VALUE){
            i = 0;
        }
        System.out.println(i);
    }
    public static int minWindow(int[] arr, int[] target) {
        HashMap<Integer, Integer> need = new HashMap<>();
        HashMap<Integer, Integer> window = new HashMap<>();
        for (int i : target) {
            need.put(i,need.getOrDefault(i,0)+1);
        }
        int left = 0;
        int right = 0;
        int valid = 0;
        int start = 0;
        int len = Integer.MAX_VALUE;
        while (right<arr.length){
            int c = arr[right];
            right++;
            if(need.containsKey(c)){
                window.put(c,window.getOrDefault(c,0)+1);
                if(window.get(c).equals(need.get(c))){
                    valid++;
                }
            }
            while (valid==need.size()){
                if(right-left<len){
                    start = left;
                    len = right-left;
                }
                int d= arr[left];
                left++;
                if(need.containsKey(d)){
                    if(window.get(d).equals(need.get(d))){
                        valid--;
                    }
                    window.put(d,window.getOrDefault(d,0)-1);
                }
            }
        }
        return len;
    }
    private static void getNum(List<Integer> list, int number) {
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                list.add(i);
                getNum(list, number / i);
                return;
            }
        }
        list.add(number);
    }
//    public static List<Integer> factor(int k) {
//        List<Integer> list = new ArrayList<>();
//        for (int factor = 2; factor <= k; ++factor) {
//            if (k % factor == 0) {
//                int facor2 = k/factor;
//                if(isPrime(factor)){
//                    list.add(factor);
//                }
//                if(isPrime(facor2)){
//                    list.add(facor2);
//                }
//            }
//        }
//        return list;
//    }
//
//    // 判断是否是质数
//    private static boolean isPrime(int n ){
//        if(n<2){
//            return false;
//        }
//        for (int i = 2;i<=Math.sqrt(n);i++){
//            if((n%i)==0){
//                return false;
//            }
//        }
//        return true;
//    }
}
