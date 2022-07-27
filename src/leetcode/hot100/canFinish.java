package leetcode.hot100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName canFinish
 * @Description 拓扑排序
 * @Author ktx
 * @Date 2022-07-27 23:03
 * @Version 1.0
 */
public class canFinish {

    /*
    *【DFS实现】
	思路: 类似染色法，在DFS过程中进行染色，如果出现闭环立即判错
	flag[]数组类似draw[]数组：
     		*  0   表示未被访问过
     		*  1   表示在当前的DFS路径中正在被访问(再次指向该处，说明出现闭环)
     		* -1   一次DFS结束，该点"绝对安全"，即从该点开始DFS不可能出现闭环
    * */
    public boolean canFinish1(int numCourses, int[][] prerequisites){
        List<List<Integer>> list = new ArrayList<>();
        int[] flag = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            list.add(new ArrayList<>());
        }
        for (int[] arr : prerequisites) {
            list.get(arr[1]).add(arr[0]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (!DFS(list,flag,i)) {
                return false;
            }
        }
        return true;
    }

    private boolean DFS(List<List<Integer>> list, int[] flag, int node) {
        if(flag[node]==1){ // 这条DFS路径出现了闭环，直接判错
            return false;
        }
        if(flag[node]==-1){// 这个节点已经"绝对安全"，不需要再次从该点开始DFS
            return true;
        }
        flag[node] = 1;
        for (Integer index : list.get(node)) {
            if (!DFS(list,flag,index)) {
                return false;
            }
        }
        flag[node] = -1;
        return true;
    }

    /*
    * 【BFS实现】
     思路: 不使用flag[]数组，而是使用degree[]入度数组
      		1.在生成邻接表的同时生成入度数组
      		2.入度为0的节点先入队
      		3.开始BFS，每次出队一个节点，该节点的所有邻接节点(它指向的节点)入度减一
      		4.如果入度减一后变为0，则该节点入队
      		5.每次进行入队操作时，便计数+1，如果最后入队的次数为总节点数，说明所有节点均遍历一次(被学习过)，返回true
    * */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> list = new ArrayList<>();
        int[] degree = new int[numCourses];
        int count = 0;

        // 根据数组生成邻接表
        for(int i = 0; i < numCourses; i++){
            list.add(new ArrayList<>());
        }
        for(int[] arr : prerequisites){
            list.get(arr[1]).add(arr[0]);
            degree[arr[0]]++;
        }
        // BFS核心代码(★☆★)
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(degree[i] == 0){
                queue.offer(i);
                count++;
            }
        }
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for(int index : list.get(node)){
                degree[index]--;
                if(degree[index] == 0){
                    queue.offer(index);
                    count++;
                }
            }
        }
        return count==numCourses;

    }

}
