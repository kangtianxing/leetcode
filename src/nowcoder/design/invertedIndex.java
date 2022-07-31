package nowcoder.design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName invertedIndex
 * @Description 倒排索引
 * @Author ktx
 * @Date 2022-07-30 20:24
 * @Version 1.0
 */
public class invertedIndex {
    public ArrayList<Integer> invertedIndex (ArrayList<Integer> ID, ArrayList<String> content, String word) {
        // write code here
        Map<String, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < content.size(); i++) {
            String[] split = content.get(i).split(" ");
            for (String s1 : split) {
                ArrayList<Integer> list = new ArrayList<>();
                if(!map.containsKey(s1)){
                    list.add(ID.get(i));
                }else {
                    list = map.get(s1);
                    if(!list.contains(ID.get(i))){
                        list.add(ID.get(i));
                    }
                }
                map.put(s1,list);
            }
        }
        return map.getOrDefault(word,new ArrayList<>());
    }
}
