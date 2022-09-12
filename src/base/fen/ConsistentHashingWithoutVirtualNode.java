package base.fen;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @ClassName ConsistentHashingWithoutVirtualNode
 * @Description TODO
 * @Author ktx
 * @Date 2022-09-12 14:58
 * @Version 1.0
 */
public class ConsistentHashingWithoutVirtualNode {

    /**
     * 集群地址列表
     */
    private static String[] groups = {
            "192.168.0.0:111", "192.168.0.1:111", "192.168.0.2:111",
            "192.168.0.3:111", "192.168.0.4:111"
    };
    /**
     * 用于保存Hash环上的节点
     */
    private static SortedMap<Integer, String> sortedMap = new TreeMap<>();

    /**
     * 初始化，将所有的服务器加入Hash环中
     */
    static {
        // 使用红黑树实现，插入效率比较差，但是查找效率极高
        for (String group : groups) {
            int hash = HashUtil.getHash(group);
            System.out.println("[" + group + "] launched @ " + hash);
            sortedMap.put(hash, group);
        }
    }

    /**
     * 计算对应的widget加载在哪个group上
     *
     * @param widgetKey
     * @return
     */

    private static String getServer(String widgetKey){
        int hash = HashUtil.getHash(widgetKey);
        // 只取出所有大于该hash值的部分而不必遍历整个Tree
        SortedMap<Integer, String> subMap = sortedMap.tailMap(hash);
        if (subMap == null || subMap.isEmpty()) {
            // hash值在最尾部，应该映射到第一个group上
            return sortedMap.get(sortedMap.firstKey());
        }
        return subMap.get(subMap.firstKey());
    }

    public static void main(String[] args) {
        Map<String,Integer> resMap = new HashMap<>();
        for (int i = 0; i < 100000; i++) {
            Integer widgetId = (int)(Math.random() * 10000);
            String server = getServer(widgetId.toString());
            if (resMap.containsKey(server)) {
                resMap.put(server, resMap.get(server) + 1);
            } else {
                resMap.put(server, 1);
            }
        }

        resMap.forEach(
                (k, v) -> {
                    System.out.println("group " + k + ": " + v + "(" + v/1000.0D +"%)");
                }
        );
    }
}
