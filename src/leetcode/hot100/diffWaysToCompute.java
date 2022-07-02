package leetcode.hot100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ktx
 * @data 2022-07-01 15:05
 */
public class diffWaysToCompute {
    public List<Integer> diffWaysToCompute(String input){
        if(input.length()==0){
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        int num = 0;
        //考虑是全数字的情况
        int index = 0;
        while (index<input.length()&&!isOperation(input.charAt(index))){
            num = num*10+input.charAt(index)-'0';
            index++;
        }
        //将全数字的情况直接返回
        if(index==input.length()){
            result.add(num);
            return result;
        }
        for (int i = 0;i<input.length();i++){
            if(isOperation(input.charAt(i))){
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i + 1));
                for (int j = 0;j<left.size();j++){
                    for (int k = 0;k<right.size();k++){
                        char op = input.charAt(i);
                        result.add(caculate(left.get(j),op,right.get(k)));
                    }
                }
            }
        }
        return result;
    }

    private int caculate(int num1, char op, Integer num2) {
        switch (op) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
        }
        return -1;

    }

    private boolean isOperation(char charAt) {
        return charAt=='+'||charAt=='-'||charAt=='*';
    }

    Map<String,List<Integer>> map = new HashMap<>();
    public List<Integer> diffWaysToCompute1(String input){
        if(input.length()==0){
            return new ArrayList<>();
        }
        if(map.containsKey(input)){
            return map.get(input);
        }
        List<Integer> result = new ArrayList<>();
        int num = 0;
        int index = 0;
        while (index<input.length()&&!isOperation(input.charAt(index))){
            num= num*10+input.charAt(index)-'0';
            index++;
        }
        if(index==input.length()){
            result.add(num);
            map.put(input,result);
            return result;
        }
        for (int i = 0;i<input.length();i++){
            if(isOperation(input.charAt(i))){
                List<Integer> left = diffWaysToCompute1(input.substring(0,i));
                List<Integer> right = diffWaysToCompute1(input.substring(i+1));
                for (int j = 0;j<left.size();j++){
                    for (int k = 0;k<right.size();k++){
                        char op = input.charAt(i);
                        result.add(caculate(left.get(j),op,right.get(k)));
                    }
                }
            }
        }
        map.put(input,result);
        return result;
    }
}

