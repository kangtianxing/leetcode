package leetcode.hot100;

/**
 * @ClassName reorderSpaces
 * @Description TODO
 * @Author ktx
 * @Date 2022-09-07 9:48
 * @Version 1.0
 */
public class reorderSpaces {


    public String reorderSpaces(String text) {
        int length = text.length();
        String[] words = text.trim().split("\\s+");
        int cntSpace = length;
        for (String word : words) {
            cntSpace-=word.length();
        }
        StringBuilder sb = new StringBuilder();
        if(words.length==1){
            sb.append(words[0]);
            for (int i = 0;i<cntSpace;i++){
                sb.append(' ');
            }
            return sb.toString();
        }
        int perSpace = cntSpace/(words.length-1);
        int restSpace = cntSpace%(words.length-1);
        for (int i = 0; i < words.length; i++) {
            if(i>0){
                for (int j = 0;j<perSpace;j++){
                    sb.append(' ');
                }
            }
            sb.append(words[i]);
        }
        for (int i = 0;i<restSpace;i++){
            sb.append(' ');
        }
        return sb.toString();
    }
}
