package leetcode.hot100;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName isIsomorphic
 * @Description TODO
 * @Author ktx
 * @Date 2022-09-25 12:44
 * @Version 1.0
 */
public class isIsomorphic {
    public boolean isIsomorphic(String s, String t) {

        Map<Character,Character> s2t = new HashMap<>();
        Map<Character,Character> t2s = new HashMap<>();
        int len = s.length();
        for (int i = 0;i<len;i++){
            char x = s.charAt(i),y = t.charAt(i);
            if((s2t.containsKey(x) && s2t.get(x)!=y)||(t2s.containsKey(y)&& t2s.get(y)!=x)){
                return false;
            }
            s2t.put(x,y);
            t2s.put(y,x);
        }
        return true;
    }
}
