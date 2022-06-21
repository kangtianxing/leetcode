package base.test.re;

import java.util.regex.Pattern;

/**
 * @author ktx
 * @data 2022-06-19 15:12
 */
public class RegexExample1 {
    public static void main(String[] args){
        String content = "I am noob " +
                "from runoob.com.";

        String pattern = ".*runoob.*";

        boolean isMatch = Pattern.matches(pattern, content);
        System.out.println("字符串中是否包含了 'runoob' 子字符串? " + isMatch);
    }
}
