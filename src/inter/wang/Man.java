package inter.wang;

import java.util.HashMap;

/**
 * @ClassName Man
 * @Description TODO
 * @Author ktx
 * @Date 2022-09-04 16:19
 * @Version 1.0
 */
public class Man {
    public static void main(String[] args) {
        int[] arr ={1,2,3,4,5};
        int k = 2;
        HashMap<Integer,Integer> mapCount = new HashMap<>();
        int maxResult = 0;
        int max = 0;

        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max,arr[i]);
        }
        for (int i =0;i<arr.length;i++){
            while (Math.abs(arr[i]-max)>=k){
                arr[i] = arr[i]+k;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            mapCount.put(arr[i],mapCount.getOrDefault(arr[i],0)+1);
            maxResult = Math.max(maxResult,mapCount.get(arr[i]));
        }
        System.out.println(maxResult);

    }
}
