package leetcode.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName canVisitAllRooms
 * @Description TODO
 * @Author ktx
 * @Date 2022-10-01 16:43
 * @Version 1.0
 */
public class canVisitAllRooms {

    public boolean canVisitAllRooms(List<List<Integer>> rooms){
        List<Boolean> visited = new ArrayList<>();
        for (int i = 0;i<rooms.size();i++){
            visited.add(false);
        }
        dfs(0,rooms,visited);
        for (Boolean flag : visited) {
            if(flag==false){
                return false;
            }
        }
        return true;
    }

    private void dfs(int key, List<List<Integer>> rooms, List<Boolean> visited) {
        if(visited.get(key)){
            return;
        }
        visited.set(key,true);
        for (Integer integer : rooms.get(key)) {
            dfs(integer,rooms,visited);
        }
    }
}
