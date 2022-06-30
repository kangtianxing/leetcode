package nowcoder.classic;

import java.util.Arrays;

/**
 * 求符合条件的方案数，使得所有质数都放在质数索引上，所有合数放在合数索引上，质数放置和合数放置是相互独立的，
 * 总的方案数即为「所有质数都放在质数索引上的方案数」\times×「所有合数都放在合数索引上的方案数」
 *
 * @author ktx
 * @data 2022-06-29 21:38
 */
public class numPrimeArrangements1175 {
    static final int MOD = 1000000007;
    public int numPrimeArrangements(int n){
        int numPrimes = 0;
        boolean[] isPrimes = new boolean[n];
        Arrays.fill(isPrimes,true);
        for (int i =2;i<n;i++){
            if(isPrimes[i]){
                numPrimes++;
                for (int j = 2*i;j<n;j+=i){
                    isPrimes[j] = false;
                }
            }
        }
        return (int)(factional(numPrimes)*factional(n-numPrimes)%MOD);

    }
    public long factional(int n){
        long res = 1;
        for (int i=1;i<=n;i++){
            res*=i;
            res%=MOD;
        }
        return res;
    }
}
