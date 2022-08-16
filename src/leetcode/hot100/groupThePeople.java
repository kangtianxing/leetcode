package leetcode.hot100;

import java.util.*;

/**
 * @ClassName groupThePeople
 * @Description TODO
 * @Author ktx
 * @Date 2022-08-12 9:56
 * @Version 1.0
 */
public class groupThePeople {

    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < groupSizes.length; i++) {
            List<Integer> list = map.computeIfAbsent(groupSizes[i], k -> new ArrayList<>());
            list.add(i);
        }
        List<List<Integer>> results = new LinkedList<>();
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            Integer groupLength = entry.getKey();
            List<Integer> list = entry.getValue();
            // N个人要分多少个组
            int count = list.size()/groupLength;
            for (int i = 0, index = 0; i < count; i++) {
                List<Integer> aResult = new ArrayList<>(groupLength);
                for (int j = 0; j < groupLength; j++) {
                    aResult.add(list.get(index++));
                }
                results.add(aResult);
            }
        }
        return results;
    }
}
