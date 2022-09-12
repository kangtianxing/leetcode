package leetcode.hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName convert
 * @Description TODO
 * @Author ktx
 * @Date 2022-09-06 10:56
 * @Version 1.0
 */
public class convert {
    public String convert(String s, int numRows) {
        if(numRows<2)return s;
        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0;i<numRows;i++){
            rows.add(new StringBuilder());
        }
        int i = 0,flag = -1;
        for (char c : s.toCharArray()) {
            rows.get(i).append(c);
            if(i==0||i==numRows-1)flag = -flag;
            i+=flag;
        }
        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }
        return result.toString();
    }
}
