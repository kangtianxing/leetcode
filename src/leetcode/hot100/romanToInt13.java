package leetcode.hot100;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName romanToInt13
 * @Description TODO
 * @Author ktx
 * @Date 2022-07-20 22:28
 * @Version 1.0
 */
public class romanToInt13 {


    // 贪心做法
    public String intToRoman(int num){
        // 数字与罗马数字的哈希映射
        Map<Integer, String> map = new HashMap<>();
        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");
        // HashMap是无序的，为了保证剥离下来的数字是从大到小的，还需要一个数组
        int[] arr = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        StringBuilder stringBuilder = new StringBuilder();
        for (int n : arr) {
            while (num/n>0){
                num-=n;
                stringBuilder.append(map.get(n));
            }
        }
        return stringBuilder.toString();
    }

    public int romanToInt(String s) {
        HashMap<Character,Integer> map = new HashMap<Character ,Integer>();
        map.put('M', 1000);
        map.put('D', 500);
        map.put('C', 100);
        map.put('L', 50);
        map.put('X', 10);
        map.put('V', 5);
        map.put('I', 1);

        int sum = 0;
        for(int i =s.length()-1;i>=0;i--) {

            if(i<(s.length()-1))
            {
                if(map.get(s.charAt(i))>=map.get(s.charAt(i+1)))
                {
                    sum = sum+map.get(s.charAt(i));

                }
                else {
                    sum = sum-map.get(s.charAt(i));

                }
            }
            else {
                sum = sum+map.get(s.charAt(i));
            }
        }

        return sum;
    }
    public int romanToInt_2(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('M', 1000);
        map.put('D', 500);
        map.put('C', 100);
        map.put('L', 50);
        map.put('X', 10);
        map.put('V', 5);
        map.put('I', 1);

        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            // 出现递增反常，则用减法；否则用加法
            if (i + 1 < s.length() && map.get(s.charAt(i)) < map.get(s.charAt(i + 1))) {
                num -= map.get(s.charAt(i));
            } else {
                num += map.get(s.charAt(i));
            }
        }
        return num;
    }

}
