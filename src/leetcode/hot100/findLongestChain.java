package leetcode.hot100;

import java.util.Arrays;

/**
 * @ClassName findLongestChain
 * @Description TODO
 * @Author ktx
 * @Date 2022-09-03 13:30
 * @Version 1.0
 */
public class findLongestChain {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs,(a,b)->(a[1]-b[1]));
        int res = 1,tem = pairs[0][1];
        for (int i =1;i<pairs.length;i++){
            if(pairs[i][0]>tem){
                res++;
                tem = pairs[i][1];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println((10/3)*3+5%3);
    }
}
