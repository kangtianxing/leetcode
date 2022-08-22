package nowcoder;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName canVisitAllRooms
 * @Description TODO
 * @Author ktx
 * @Date 2022-08-21 0:45
 * @Version 1.0
 */
public class canVisitAllRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms){
        List<Boolean> visited = new ArrayList<>();
        for (int i = 0; i < rooms.size(); i++) {
            visited.add(false);
        }
        dfs(visited,rooms,0);
        for (Boolean aBoolean : visited) {
            if(!aBoolean){
                return false;
            }
        }
        return true;
    }

    private void dfs(List<Boolean> visited, List<List<Integer>> rooms, int k) {
        if(visited.get(k)==true){
            return;
        }
        visited.set(k,true);
        for (Integer integer : rooms.get(k)) {
            dfs(visited,rooms,integer);
        }
    }
}
