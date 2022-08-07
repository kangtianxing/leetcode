package leetcode.hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName stringMatching
 * @Description TODO
 * @Author ktx
 * @Date 2022-08-06 23:20
 * @Version 1.0
 */
public class stringMatching {

    public List<String> stringMatching(String[] words) {
        List<String> ret = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = 0;j<words.length;j++){
                if(i!=j &&words[j].contains(words[i])){
                    ret.add(words[i]);
                    break;
                }
            }
        }
        return ret;
    }
}
