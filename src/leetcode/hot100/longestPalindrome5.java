package leetcode.hot100;

/**
 * @author ktx
 * @data 2022/6/6 11:09
 */
public class longestPalindrome5 {

    public String longestPalindrome(String s) {
        if(s==null||s.length()<1){
            return "";
        }
        int start = 0,end = 0;
        for (int i = 0;i<s.length();i++){
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1,len2);
            if(len>end-start){
                start = i-(len-1)/2;
                end = i+len/2;
            }
        }
        return s.substring(start,end+1);
    }
    public int expandAroundCenter(String s,int left,int right){
        while (left>=0&&right<s.length()&&s.charAt(left)==s.charAt(right)){
            --left;
            ++right;
        }
        return right-left-1;
    }
    public String longestPalindrome1(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for (int i = 0;i<n;i++){
            dp[i][i] = true;
        }
        int maxLength = 0;
        int left = 0;
        int right = 0;
        for (int i = n-1;i>=0;i--){
            for (int j = i;j<n;j++){
                if(s.charAt(i)==s.charAt(j)){
                    if(j-i<=1){
                        dp[i][j] = true;
                    }else if(dp[i+1][j-1]){
                        dp[i][j] = true;
                    }
                }
                if(dp[i][j]&&(j-i+1>maxLength)){
                    maxLength = j-i+1;
                    left = i;
                }
            }
        }
        return s.substring(left,maxLength+left);
    }

}
