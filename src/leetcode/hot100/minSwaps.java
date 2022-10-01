package leetcode.hot100;

/**
 * @ClassName minSwaps
 * @Description TODO
 * @Author ktx
 * @Date 2022-09-13 17:08
 * @Version 1.0
 */
public class minSwaps {
    public int minSwaps(String s) {
        int count = 0,res = 0;
        for (char c : s.toCharArray()) {
            if(c=='['){
                count++;
            }else {
                count--;
                if(count<0){
                    count = 0;
                    res++;
                }
            }
        }
        return (res+1)/2;
    }
}
