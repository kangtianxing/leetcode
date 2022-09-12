package leetcode.hot100;

/**
 * @ClassName numSpecial
 * @Description TODO
 * @Author ktx
 * @Date 2022-09-04 21:22
 * @Version 1.0
 */
public class numSpecial {
    public int numSpecial(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[] rowsSum = new int[m];
        int[] colsSum = new int[n];
        for (int i = 0;i<m;i++){
            for (int j = 0;j<n;j++){
                rowsSum[i]+=mat[i][j];
                colsSum[j]+=mat[i][j];
            }
        }
        int res = 0;
        for (int i = 0;i<m;i++){
            for (int j = 0;j<n;j++){
                if(mat[i][j]==1 &&rowsSum[i]==1 &&colsSum[j] ==1){
                    res++;
                }
            }
        }
        return res;
    }
}
