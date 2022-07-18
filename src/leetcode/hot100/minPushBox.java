package leetcode.hot100;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName minPushBox
 * @Description 推箱子
 * @Author ktx
 * @Date 2022-07-18 22:10
 * @Version 1.0
 */
public class minPushBox {
    /**
     *【BFS+DFS】
     * 以箱子的视角进行BFS
     * 以人的视角进行DFS
     * 后者作为前者得以进行的前提
     */

    public int minPushBox(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // 遍历一次，找出箱子起点/终点，人的初始位置
        int startX = -1;
        int startY = -1;
        int targetX = -1;
        int targetY = -1;
        int personX = -1;
        int personY = -1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 'B') {
                    startX = i;
                    startY = j;
                }
                if (grid[i][j] == 'T') {
                    targetX = i;
                    targetY = j;
                    grid[i][j] = '.';
                }
                if (grid[i][j] == 'S') {
                    personX = i;
                    personY = j;
                    grid[i][j] = '.';
                }
            }
        }
        // 初始化队列，加入元素以启动BFS
        boolean[][][] visited = new boolean[m][n][4];
        Queue<Box> queue = new LinkedList<>();
        for (int i = 0; i < 4; i++) {
            int[] direction = directions[i];
            if (personCanReach(grid, m, n, personX, personY, startX - direction[0], startY - direction[1], new boolean[m][n])) {
                queue.add(new Box(startX, startY, i));
                visited[startX][startY][i] = true;
            }
        }
        // 以箱子的视角开始BFS
        int step = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            while (size-->0){
                Box box = queue.poll();
                grid[box.x][box.y] = 'B';
                personX = box.x - directions[box.from][0];
                personY = box.y - directions[box.from][1];
                if (box.x == targetX && box.y == targetY) {
                    return step;
                }
                for (int i = 0; i < 4; i++) {
                    int[] direction = directions[i];
                    int nextX = box.x + direction[0];
                    int nextY = box.y + direction[1];
                    // 人是否能绕到箱子的后面？
                    if (!personCanReach(grid, m, n, personX, personY, box.x - direction[0], box.y - direction[1], new boolean[m][n])) {
                        continue;
                    }
                    // 箱子的下个位置是否合法？
                    if (!isValid(grid, m, n, nextX, nextY)) {
                        continue;
                    }
                    // 箱子的下一个状态是不是重复了？
                    if (visited[nextX][nextY][i]) {
                        continue;
                    }
                    queue.add(new Box(nextX, nextY, i));
                    visited[nextX][nextY][i] = true;
                }
                grid[box.x][box.y] = '.';

            }
            step++;
        }
        return -1;

    }

    // 其含义是从【上】【下】【左】【右】
    private final static int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    // 静态内部类是个顶级类，可当成外部类来看
    private static class Box {
        int x;
        int y;
        int from;
        public Box(int x, int y, int from) {
            this.x = x;
            this.y = y;
            this.from = from;
        }
    }
    // 人是否可以某一位置(startX, startY)到达另一位置(targetX, targetY)
    private boolean personCanReach(char[][] grid, int m, int n, int startX, int startY, int targetX, int targetY, boolean[][] visited) {
        if(startX==targetX&&startY==targetY){
            return true;
        }
        visited[startX][startY] = true;
        for (int[] direction : directions) {
            int nextX = startX + direction[0];
            int nextY = startY + direction[1];
            if(isValid(grid,m,n,nextX,nextY)&&!visited[nextX][nextY]){
                if(personCanReach(grid,m,n,nextX,nextY,targetX,targetY,visited)){
                    return true;
                }
            }
        }
        return false;
    }
    // 某位置是否可以踏足
    private boolean isValid(char[][] grid, int m, int n, int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == '.';
    }
}
