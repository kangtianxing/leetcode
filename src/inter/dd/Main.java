package inter.dd;

import java.util.Arrays;

/**
 * @ClassName Main
 * @Description TODO
 * @Author ktx
 * @Date 2022-09-04 19:28
 * @Version 1.0
 */
public class Main {
    public static void main(String[] args) {
        int n = 6;
        int k = 2;
        int[] arr = {1,100,1,100,100,1000};
        Arrays.sort(arr);
        int[] preSum = new int[n+1];
        for (int i = 1;i<=n;i++){
            preSum[i] =preSum[i-1]+arr[i-1];
        }
        int result = -1;
        for (int i = 1;i<=n;i++){
            if(((((float)preSum[i])/i)*k)<arr[i-1]){
                result = i-1;
                break;
            }
        }
        if(result==-1){
            result = n;
        }
        System.out.println(result);
    }
}
