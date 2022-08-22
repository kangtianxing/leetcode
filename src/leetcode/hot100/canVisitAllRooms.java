package leetcode.hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName canVisitAllRooms
 * @Description TODO
 * @Author ktx
 * @Date 2022-08-16 10:01
 * @Version 1.0
 */
public class canVisitAllRooms {
    public static void main(String[] args) {
        int sum = 0;
        int count = 0;
        for (int i = 0;i!=10;i++){
            sum+=i;
            count++;

        }
        System.out.println(count);
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        List<Boolean> visited = new ArrayList<>();
        for (int i = 0;i< rooms.size();i++){
            visited.add(false);
        }
        dfs(0,rooms,visited);
        for (Boolean flag : visited) {
            if(!flag){
                return false;
            }
        }
        return true;
    }

    private void dfs(int k, List<List<Integer>> rooms, List<Boolean> visited) {
        if(visited.get(k)==true){
            return;
        }
        visited.set(k,true);
        for (Integer i : rooms.get(k)) {
            dfs(i,rooms,visited);
        }

    }
}
