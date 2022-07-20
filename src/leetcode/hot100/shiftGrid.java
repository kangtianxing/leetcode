package leetcode.hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName shiftGrid
 * @Description TODO
 * @Author ktx
 * @Date 2022-07-20 22:51
 * @Version 1.0
 */
public class shiftGrid {
    public List<List<Integer>> shiftGrid(int[][] grid, int k){
        int m = grid.length,n = grid[0].length;
        List<List<Integer>> ret = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            List<Integer> row = new ArrayList<Integer>();
            for (int j = 0; j < n; j++) {
                row.add(0);
            }
            ret.add(row);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int index1 = (i * n + j + k) % (m * n);
                ret.get(index1 / n).set(index1 % n, grid[i][j]);
            }
        }
        return ret;

    }
}
