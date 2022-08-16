package leetcode.hot100;

/**
 * @ClassName maxChunksToSorted
 * @Description TODO
 * @Author ktx
 * @Date 2022-08-14 17:06
 * @Version 1.0
 */
public class maxChunksToSorted {

    public int maxChunksToSorted(int[] arr) {
        int length = arr.length;
        int[] leftMax= new int[length];
        int[] rightMin = new int[length];
        leftMax[0] = arr[0];
        rightMin[length-1] = arr[length-1];
        for (int i = 1;i<length;i++){
            leftMax[i] = Math.max(arr[i],leftMax[i-1]);
        }
        for (int j = length-2;j>=0;j--){
            rightMin[j] =Math.min(rightMin[j+1],arr[j]);
        }
        int count = 1;
        for (int i = 1;i<length;i++){
            if(leftMax[i-1]<=rightMin[i]){
                count++;
            }
        }
        return count;
    }
}
