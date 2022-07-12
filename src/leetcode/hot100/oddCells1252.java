package leetcode.hot100;

/**
 * @ClassName oddCells1252
 * @Description TODO
 * @Author ktx
 * @Date 2022-07-12 10:35
 * @Version 1.0
 */
public class oddCells1252 {
    public int oddCells(int m, int n, int[][] indices) {
        int[][] matrix = new int[m][n];
        for (int[] index : indices) {
            int row = index[0];
            int col = index[1];
            for (int i = 0;i<m;i++){
                matrix[i][col]+=1;
            }
            for (int i = 0;i<n;i++){
                matrix[row][i] +=1;
            }
        }
        int res = 0;
        for (int i = 0;i<m;i++){
            for (int j = 0;j<n;j++){
                if(matrix[i][j]%2==1){
                    res++;
                }
            }
        }
        return res;
    }

    public int oddCells1(int m, int n, int[][] indices) {
        int[] rows = new int[m];
        int[] cols = new int[n];
        for (int[] index : indices) {
            rows[index[0]]++;
            cols[index[1]]++;
        }
        int res = 0;
        for (int i = 0;i<m;i++){
            for (int j = 0;j<n;j++){
                if((rows[i]+cols[j])%2==1){
                    res++;
                }
            }
        }
        return res;
    }












}
