package leetcode.hot100;

import base.test.Main;

/**
 * @ClassName maximumSwap
 * @Description TODO
 * @Author ktx
 * @Date 2022-09-13 10:21
 * @Version 1.0
 */
public class maximumSwap {

    public int maximumSwap(int num) {
        if(num%10==num)return num;
        char[] arr = String.valueOf(num).toCharArray();
        for (int i = 0;i<arr.length;i++){
            int maxIndex = i;
            for (int j = arr.length-1;j>=i+1;j--){
                if(arr[j]>arr[maxIndex]){
                    maxIndex = j;
                }
            }
            if(maxIndex!=i){
                char tmp = arr[i];
                arr[i] = arr[maxIndex];
                arr[maxIndex] = tmp;
                return Integer.parseInt(new String(arr));
            }
        }
        return num;
    }
}
