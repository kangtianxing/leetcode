package nowcoder.design;

import java.util.ArrayList;

/**
 * @ClassName typeahead
 * @Description 牛客代码自动补全
 * @Author ktx
 * @Date 2022-07-30 21:08
 * @Version 1.0
 */
public class typeahead {
    public ArrayList<ArrayList<String>> typeahead (ArrayList<String> dict, ArrayList<String> strings) {
        // write code here
        ArrayList<ArrayList<String>> res = new ArrayList<>();
        if(dict.size() == 0 || strings.size() == 0) return res;
        for(int i=0;i<strings.size();i++){
            ArrayList<String> arr = new ArrayList<>();
            for(int j=0;j<dict.size();j++){
                if(dict.get(j).indexOf(strings.get(i)) != -1) arr.add(dict.get(j));
            }
            res.add(arr);
        }
        return res;
    }
}
