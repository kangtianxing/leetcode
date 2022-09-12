package leetcode.hot100;

/**
 * @ClassName constructArray
 * @Description TODO
 * @Author ktx
 * @Date 2022-09-08 10:14
 * @Version 1.0
 */
public class constructArray {
    public int[] constructArray(int n, int k) {
        int[] answer = new int[n];
        int index = 0;
        for (int i = 1;i<n-k;i++){
            answer[index] = i;
            ++index;
        }
        for (int i =n-k,j=n;i<=j;++i,--j){
            answer[index] = i;
            ++index;
            if(i!=j){
                answer[index] = j;
                ++index;
            }
        }
        return answer;


    }
}
