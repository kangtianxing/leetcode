package leetcode.hot100;

/**
 * @ClassName maxScore
 * @Description TODO
 * @Author ktx
 * @Date 2022-08-14 17:56
 * @Version 1.0
 */
public class maxScore {

    public static void main(String[] args) {
        maxScore maxScore = new maxScore();
        int i = maxScore.maxScore("00");
        System.out.println(i);
    }
    public int maxScore(String s) {
        int n = s.length();
        int[] leftZero = new int[n];
        int[] rightOne = new int[n];
        if(s.charAt(0)=='0'){
            leftZero[0] =1;
        }
        if(s.charAt(n-1)=='1'){
            rightOne[n-1] = 1;
        }
        for (int i = 1;i<n;i++){
            if(s.charAt(i)=='0'){
                leftZero[i] = leftZero[i-1]+1;
            }else {
                leftZero[i] = leftZero[i-1];
            }
        }
        for (int i = n-2;i>=0;i--){
            if(s.charAt(i)=='1'){
                rightOne[i] = rightOne[i+1]+1;
            }else {
                rightOne[i] = rightOne[i+1];
            }
        }
        int max = 0;
        for (int i = 1;i<n;i++){
            max = Math.max(max,rightOne[i]+leftZero[i-1]);
        }
        return max;
    }
}
