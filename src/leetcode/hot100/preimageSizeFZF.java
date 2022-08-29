package leetcode.hot100;

/**
 * @ClassName preimageSizeFZF
 * @Description TODO
 * @Author ktx
 * @Date 2022-08-28 14:51
 * @Version 1.0
 */
public class preimageSizeFZF {

    public int preimageSizeFZF(int k) {
        return (int) (calMinKZero(k+1)-calMinKZero(k));
    }

    private long calMinKZero(int k) {
        long left = 0L;
        long right = 5L*k;
        long ans = right;
        while (left<=right){
            long mid = left + (right - left) / 2;
            if(calZero(mid)>=k){
                right = mid-1;
                ans = mid;
            }else {
                left = mid+1;
            }
        }
        return ans;
    }

    private int calZero(long n) {
        int ans = 0;
        while (n!=0){
            n = n/5;
            ans+=n;
        }
        return ans;
    }
}
