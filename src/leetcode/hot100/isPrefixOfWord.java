package leetcode.hot100;

/**
 * @ClassName isPrefixOfWord
 * @Description TODO
 * @Author ktx
 * @Date 2022-08-27 13:19
 * @Version 1.0
 */
public class isPrefixOfWord {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] str = sentence.split(" ");
        for (int i = 0; i < str.length; i++) {
            if(str[i].startsWith(searchWord)){
                return i+1;
            }
        }
        return -1;
    }
}
