package leetcode.hot100;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName hasPathMiGong
 * @Description TODO
 * @Author ktx
 * @Date 2022-08-22 10:16
 * @Version 1.0
 */
public class hasPathMiGong {
    private int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
    public boolean hasPath(int[][] maze,int[] start,int[] destination){
        int row = maze.length;
        if(row==0){
            return false;
        }
        int col = maze[0].length;
        if(col==0){
            return false;
        }
        boolean[][] verify = new boolean[row][col];
        return dfs(maze,start,destination,verify,row,col);
    }

    private boolean dfs(int[][] maze, int[] start, int[] destination, boolean[][] verify, int row, int col) {
        if(verify[start[0]][start[1]]==true){
            return false;
        }
        if(start[0]==destination[0]&&start[1]==destination[1]){
            return true;
        }
        verify[start[0]][start[1]] = true;
        int x = start[0];
        int y = start[1];
        for (int[] direction : directions) {
            int newX = x+direction[0];
            int newY =y+direction[1];
            while (newX>=0 &&newX<row &&newY>=0&&newY<col&&maze[newX][newY]==0){
                newX+=direction[0];
                newY+=direction[1];
            }
            newX-=direction[0];
            newY-=direction[1];
            if(dfs(maze,new int[]{newX,newY},direction,verify,row,col)){
                return true;
            }
        }
        return false;
    }
    private boolean bfs(int[][] maze, int[] start, int[] destination, int rows, int cols){
        boolean[][] visited = new boolean[rows][cols];	//判断该节点是否来过
        Queue<int[]> queue = new LinkedList<>();		//存储节点坐标
        queue.add(start);
        visited[start[0]][start[1]] = true;
        while (!queue.isEmpty()){
            int[] curPoint = queue.poll();
            int x = curPoint[0];
            int y = curPoint[1];
            if(x==destination[0]&&y==destination[1]){
                return true;
            }
            for (int[] direction : directions) {
                int newX = x + direction[0];
                int newY = y + direction[1];
                while (newX >= 0 && newX < rows && newY >= 0 && newY < cols && maze[newX][newY] == 0) {
                    // 只要是空格，就一路往前走，直到碰到墙壁
                    newX += direction[0];
                    newY += direction[1];
                }
                //结束 while 时，说明当前点是墙壁或者超出边界，往回走一格
                newX -= direction[0];
                newY -= direction[1];
                if(!visited[newX][newY]){
                    queue.add(new int[]{newX,newY});
                    visited[newX][newY] = true;
                }
            }
        }
        return false;
    }
}
