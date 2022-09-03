package leetcode.hot100;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName lengthOfLongestSubstring
 * @Description TODO
 * @Author ktx
 * @Date 2022-07-28 21:38
 * @Version 1.0
 */
public class lengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> window = new HashMap<>();
        int left = 0,right =0;
        int res = 0; // 记录结果
        while (right<s.length()){
            char c = s.charAt(right);
            right++;
            // 窗口更新
            window.put(c,window.getOrDefault(c,0)+1);
            while (window.get(c)>1){
                char d = s.charAt(left);
                left++;
                // 进行窗口更新
                window.put(d,window.getOrDefault(d,0)-1);
            }
            res = Math.max(res,right-left);
        }
        return res;
    }

    public int lengthOfLongestSubstring1(String s) {
        Map<Character,Integer> window = new HashMap<>();
        int left = 0,right = 0;
        int res = 0;
        while (right<s.length()){
            char c = s.charAt(right);
            right++;
            window.put(c,window.getOrDefault(c,0)+1);
            while (window.get(c)>1){
                char d = s.charAt(left);
                left++;
                window.put(d,window.getOrDefault(d,0)-1);
            }
            res = Math.max(res,right-left);
        }
        return res;
    }
}
