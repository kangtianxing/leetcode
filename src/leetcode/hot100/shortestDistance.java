package leetcode.hot100;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @ClassName shortestDistance
 * @Description TODO
 * @Author ktx
 * @Date 2022-08-22 10:49
 * @Version 1.0
 */
public class shortestDistance {
    public int shortestDistance(int[][] maze, int[] start, int[] destination){
        int row = maze.length;
        int col = maze[0].length;
        // 遍历的方向
        int[] dx = new int[]{-1, 0, 1, 0};
        int[] dy = new int[]{0, 1, 0, -1};

        int[][] visited = new int[row][col];

        // 优先队列, 按照路径长度进行升序排列
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        queue.add(new int[]{0,start[0],start[1]});
        while (!queue.isEmpty()){
            int[] cur = queue.poll();
            if(visited[cur[1]][cur[2]]==1){
                continue;
            }
            visited[cur[1]][cur[2]] =1;
            if (Arrays.equals(new int[]{cur[1], cur[2]}, destination)) {
                return cur[0];
            }
            // 从四个方向遍历
            for (int d = 0; d < 4; d++) {
                int x = cur[1];
                int y = cur[2];
                int dist = cur[0];
                while (x >= 0 && x < row && y >= 0 && y < col && maze[x][y] == 0) {
                    x += dx[d];
                    y += dy[d];
                    dist++;
                }
                x -= dx[d];
                y -= dy[d];
                dist--;
                if (visited[x][y] == 0) {
                    queue.add(new int[]{dist, x, y});
                }
            }
        }
        return -1;
    }
}
