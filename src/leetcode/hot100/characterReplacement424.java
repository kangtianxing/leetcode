package leetcode.hot100;

/**
 * 可相同的字符数量
 * @author ktx
 * @data 2022-07-02 18:00
 */
public class characterReplacement424 {

    public int characterReplacement(String s, int k) {
        int n = s.length();
        int L = 0,R = 0;
        int maxCount = 0;
        int res = 0;
        int[] count = new int[26];
        while(R<n){
            count[s.charAt(R)-'A']++;
            maxCount = Math.max(maxCount,count[s.charAt(R)-'A']);
            while (maxCount+k<R-L+1){
                count[s.charAt(L)-'A']--;
                L++;
            }
            res = Math.max(res,R-L+1);
            R++;
        }
        return res;
    }
}
