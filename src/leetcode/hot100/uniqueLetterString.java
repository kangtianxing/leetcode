package leetcode.hot100;

import org.w3c.dom.ls.LSInput;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName uniqueLetterString
 * @Description TODO
 * @Author ktx
 * @Date 2022-09-06 19:50
 * @Version 1.0
 */
public class uniqueLetterString {
    public int uniqueLetterString(String s){
        Map<Character, List<Integer>> map = new HashMap<>();
        char[] sc = s.toCharArray();
        for (int i = 0; i < sc.length; i++) {
            if (!map.containsKey(sc[i])) {
                map.put(sc[i],new ArrayList<>());
            }
            map.get(sc[i]).add(i);
        }
        int result = 0;
        for (Map.Entry<Character, List<Integer>> entry : map.entrySet()) {
            int head = -1,tail = -1;
            List<Integer> item = entry.getValue();
            for (int i = 0; i < item.size(); i++) {
                tail = (i<item.size()-1)?item.get(i+1):sc.length;
                result+=(item.get(i)-head)*(tail-item.get(i));
                head = item.get(i);
            }
        }
        return result;

    }
}
