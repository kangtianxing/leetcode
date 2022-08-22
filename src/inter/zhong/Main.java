package inter.zhong;

/**
 * @ClassName Main
 * @Description TODO
 * @Author ktx
 * @Date 2022-08-20 9:47
 * @Version 1.0
 */
public class Main {
    public static void main(String[] args) {
        String str = "1.0.0.0.0.0.2";
        boolean result = getResult(str);
        if(result){
            long ip = ipv4StringToNum(str);
            System.out.println(ip);
        }else {
            System.out.println(-1);
        }
    }

    private static boolean getResult(String str) {
        String t[] = str.split("\\.",-1);
        if(t.length!=7)return false;
        for (int i = 0;i<7;i++){
            if(i==0||i==6){
                if(i==0&&t[i].equals("0")){
                    return false;
                }
                // 前后不能省略
                if(t[i].equals("")){
                    return false;
                }
            }
            if(t[i].length()>3||(t[i].length()>1&&t[i].charAt(0)=='0')){
                return false;
            }
            int sum = 0;
            for (char c : t[i].toCharArray()) {
                if(!Character.isDigit(c)){
                    return false;
                }
                sum=sum*10+c-'0';
            }
            if(sum>255)return false;
        }
        return true;
    }

    public  static  Long ipv4StringToNum(String  ip){
        String[] ips =  ip.split("\\.");
        if(ips == null || ips.length != 7){
            return null;
        }
        long  ip_num = 0;
        ip_num = (Long.valueOf(ips[0]) << 48) +
                (Long.valueOf(ips[1])  << 40) +
                (Long.valueOf(ips[2])  << 32) +
                (Long.valueOf(ips[3])  << 24)+
                (Long.valueOf(ips[4])  << 16)+
                (Long.valueOf(ips[5])  << 8)+
                (Long.valueOf(ips[6]));

        return  ip_num;
    }

}
