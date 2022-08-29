package inter.meituan;

import java.util.*;

/**
 * @ClassName Main
 * @Description TODO
 * @Author ktx
 * @Date 2022-08-27 16:45
 * @Version 1.0
 */
public class Main {
    public static void main(String[] args) {
        String s = "aaaaaa";
        String[] target = {"aaaa","aa"};
        for (String s1 : target) {
            stringMap.put(s1,stringMap.getOrDefault(s1,0)+1);
            staticMap.put(s1,staticMap.getOrDefault(s1,0)+1);
        }
        Main main = new Main();
        main.partition(s);
        System.out.println(lists.size());
    }

     static List<List<String>> lists = new ArrayList<>();
     static Deque<String> deque = new LinkedList<>();
     static HashMap<String,Integer> stringMap = new HashMap<>();
    static HashMap<String,Integer> staticMap = new HashMap<>();
    public static List<List<String>> partition(String s) {
        backTracking(s, 0);
        return lists;
    }

    private static void backTracking(String s, int startIndex) {
        //如果起始位置大于s的大小，说明找到了一组分割方案
        if (startIndex >= s.length()) {
            lists.add(new ArrayList(deque));
            stringMap  = staticMap;
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            //如果是回文子串，则记录
            if (isPalindrome(s, startIndex, i)) {
                String str = s.substring(startIndex, i + 1);
                deque.addLast(str);
            } else {
                continue;
            }
            //起始位置后移，保证不重复
            backTracking(s, i + 1);
            deque.removeLast();
        }
    }
    //判断是否是回文串
    private static boolean isPalindrome(String s, int startIndex, int end) {
        String str = s.substring(startIndex,end+1);
        if(stringMap.containsKey(str)){
            Integer k = stringMap.get(str);
            if(k>0){
                stringMap.put(str,k-1);
                return true;
            }else {
                return false;
            }
        }
        return false;
    }
}
