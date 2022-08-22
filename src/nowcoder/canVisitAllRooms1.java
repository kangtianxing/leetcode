package nowcoder;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName canVisitAllRooms1
 * @Description TODO
 * @Author ktx
 * @Date 2022-08-21 10:49
 * @Version 1.0
 */
public class canVisitAllRooms1 {
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

        for (Integer integer : rooms.get(k)) {
            if(visited.get(integer)==false){
                visited.set(k,true);
                dfs(visited,rooms,integer);
            }
        }
    }
}
