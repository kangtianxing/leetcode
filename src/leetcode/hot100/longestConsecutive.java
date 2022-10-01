package leetcode.hot100;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName longestConsecutive
 * @Description TODO
 * @Author ktx
 * @Date 2022-09-18 10:52
 * @Version 1.0
 */
public class longestConsecutive {
    public int longestConsecutive(int[] nums) {
        Set<Integer> num_set = new HashSet<>();
        for (int num : nums) {
            num_set.add(num);
        }
        int longestStreak = 0;
        for (Integer num : num_set) {
            if(!num_set.contains(num-1)){
                int currentNum = num;
                int currentStreak = 1;
                while (num_set.contains(currentNum+1)){
                    currentNum+=1;
                    currentStreak+=1;
                }
                longestStreak = Math.max(longestStreak,currentStreak);
            }
        }
        return longestStreak;
    }
}
