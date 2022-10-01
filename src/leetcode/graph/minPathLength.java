package leetcode.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName minPathLength
 * @Description TODO
 * @Author ktx
 * @Date 2022-09-18 16:27
 * @Version 1.0
 */
public class minPathLength {

    public int minPathLength(int[][] grids, int tr, int tc) {
        final int[][] direction = {{1,0},{-1,0},{0,1},{0,-1}};

        final int m = grids.length, n = grids[0].length;
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();


        queue.add(new Pair<>(0, 0));
        int pathLength = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            pathLength++;
            while (size-- > 0) {
                Pair<Integer, Integer> cur = queue.poll();
                for (int[] d : direction) {
                    int nr = cur.getKey() + d[0], nc = cur.getValue() + d[1];
                    Pair<Integer, Integer> next = new Pair<>(nr, nc);
                    if (next.getKey() < 0 || next.getValue() >= m
                            || next.getKey() < 0 || next.getValue() >= n) {

                        continue;
                    }
                    grids[next.getKey()][next.getValue()] = 0; // 标记
                    if (next.getKey() == tr && next.getValue() == tc) {
                        return pathLength;
                    }
                    queue.add(next);
                }
            }
        }
        return -1;
    }

    class Pair<T,K>{
        Integer key;
        Integer value;

        public Pair(Integer key, Integer value) {
            this.key = key;
            this.value = value;
        }

        public Integer getKey() {
            return key;
        }

        public void setKey(Integer key) {
            this.key = key;
        }

        public Integer getValue() {
            return value;
        }

        public void setValue(Integer value) {
            this.value = value;
        }
    }
}
