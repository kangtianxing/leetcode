package inter.oppo;

/**
 * @ClassName Main
 * @Description TODO
 * @Author ktx
 * @Date 2022-09-02 16:29
 * @Version 1.0
 */
public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        int result = main.findStr1("Hello world", "ow");
        System.out.println(result);

    }
    public int findStr1(String str,String mod){
        int m = str.length(),n = mod.length();
        StringBuilder sb  =new StringBuilder(mod);
        mod = sb.reverse().toString();
        for(int i = 0;i<=m-n;i++){
            boolean flag = true;
            for(int j =0;j<n;j++){
                if(mod.charAt(j)!='*'&& str.charAt(i+j) != mod.charAt(j)){
                    flag = false;
                    break;
                }
            }
            if(flag){
                return i-1+mod.length();
            }
        }
        return -1;
    }
    public int findStr(String str,String mod){
        StringBuilder sb  =new StringBuilder(str);
        str = sb.reverse().toString();
        if (str.length() < mod.length() || mod.length() == 0){
            return -1;
        }

        if(mod.length() < 1) return 0;

        int n = str.length();
        int m = mod.length();
        // 将haystack和needle转为数组，使s串和p串都从数组下标1开始计数
        char[] s = (" " + str).toCharArray();
        char[] p = (" " + mod).toCharArray();
        // 定义ne数组
        int[] ne = new int[m + 10];
        // 构建ne数组
        // 注意：此处构建ne数组，i是从2开始的
        for(int i = 2,j = 0;i <= m;i ++)
        {
            // !!核心!!：跳转
            while(j != 0 && p[i] != p[j + 1]) j = ne[j];
            // 如果字符串匹配，则匹配下一个字符
            if(s[i] == p[j + 1]||p[j+1]=='*') j ++;
            ne[i] = j;
        }
        // 根据ne数组进行匹配
        // 注意：进行匹配时，i是从1开始的
        for(int i = 1,j = 0;i <= n;i ++)
        {
            while(j != 0 && s[i] != p[j + 1]) j = ne[j];
            // 如果匹配，则继续匹配下一个字符
            if(s[i] == p[j + 1]||p[j+1]=='*') j ++;
            // 如果完全匹配
            if(j == m)
            {
                j = ne[j];
                // 返回匹配开始的下标
                return n-(i - m)-1;
            }
        }
        // 不存在，返回-1
        return -1;
    }
}
