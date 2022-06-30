package nowcoder.classic;

import java.util.Arrays;

/**
 * 给定一个n，统计2-n中质数的个数
 * @author ktx
 * @data 2022-06-29 21:11
 */
public class countPrimes {

    private boolean isPrime(int n ){
        if(n<2){
            return false;
        }
        for (int i = 2;i<Math.sqrt(n);i++){
            if((n%i)==0){
                return false;
            }
        }
        return true;
    }
    // 暴力统计
    public int countPrimes(int n){
        int cnt = 0;
        for (int i =2;i<n;i++){
            cnt+=(isPrime(i)?1:0);
        }
        return cnt;
    }

    // 埃及筛
    //：设置一个大小为 n nn 的 i s P r i m e [ ] isPrime[]isPrime[] 数组，默认全为质数；遍历时，如果遇到质数，那么就把它的所有整倍数都标记为合数
    public int countPrimes1(int n ){
        boolean[] isPrimes = new boolean[n];
        Arrays.fill(isPrimes,true);
        int cnt = 0;
        for (int i = 2;i<n;i++){
            if(isPrimes[i]){
                cnt++;
                for (int j = 2*i;j<n;j+=i){
                    isPrimes[j] = false;
                }
            }
        }
        return cnt;
    }
}
