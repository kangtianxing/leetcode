package leetcode.hot100;

/**
 * @ClassName shuffle
 * @Description TODO
 * @Author ktx
 * @Date 2022-08-30 17:39
 * @Version 1.0
 */
public class shuffle {

    public int[] shuffle(int[] nums, int n) {
        int[] resut = new int[2*n];
        for (int i = 0;i<n;i++){
            resut[i*2] = nums[i];
            resut[i*2+1] = nums[i+n];
        }
        return resut;
    }
}
