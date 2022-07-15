package leetcode.hot100;

import java.util.Arrays;

/**
 * @ClassName minEatingSpeed875
 * @Description TODO
 * @Author ktx
 * @Date 2022-07-15 21:35
 * @Version 1.0
 */
public class minEatingSpeed875 {
    public int minEatingSpeed(int[] piles, int h){
        int left = 1;
        int right = Arrays.stream(piles).max().getAsInt();
        while (left<right){
            int mid = left+(right-left)/2;
            if(countHours(piles,mid)>h){
                left=mid+1;
            }else {
                right = mid;
            }
        }
        return left;
    }

    private int countHours(int[] piles, int speed) {
        int sum = 0;
        for (int pile : piles) {
            sum+=(pile+speed-1)/speed;
        }
        return sum;
    }
}
