package leetcode.hot100;

/**
 * @ClassName JieMuGun
 * @Description TODO
 * @Author ktx
 * @Date 2022-09-04 15:33
 * @Version 1.0
 */
public class JieMuGun {
    static int minResult = 0;
    public static void main(String[] args) {
        int n = 10;
        int result = getMin(n);
        System.out.println(minResult);
    }

    private static int getMin(int n) {
        if(n==0||n==1){
            return n;
        }
        if(n%2==0){
            minResult+=getMin(n/2);
        }else {
            minResult+=getMin(n/2+1);
        }
        return minResult;
    }
}
