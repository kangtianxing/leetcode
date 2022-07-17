package leetcode.hot100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @ClassName Rob3Main
 * @Description TODO
 * @Author ktx
 * @Date 2022-07-16 13:38
 * @Version 1.0
 */
public class Rob3Main {
    static int[] val;
    static int[][] child;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        String[] s = reader.readLine().split("\\s+");
        val = new int[n];
        for(int i=0; i<n; i++){
            val[i] = Integer.parseInt(s[i]);
        }
        s = reader.readLine().split("\\s+");
        child = new int[n][2];
        for(int i = 0;i<n;i++){
            child[i][0] = child[i][1]= -1;
            int p = Integer.parseInt(s[i]);
            if(p>0){
                int[] c= child[p-1];
                if(c[0]==-1){
                    c[0] = i;
                }else{
                    c[1] = i;
                }
            }

        }
        int[] res = helper(0);
        System.out.print(Math.max(res[0], res[1]));

    }
    static int[] helper(int index){
        if(index==-1){
            return new int[2];
        }
        int[] left = helper(child[index][0]);
        int[] right = helper(child[index][1]);
        int dp0 = val[index] + left[1] + right[1];
        int dp1 = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return new int[]{dp0, dp1};
    }
}
