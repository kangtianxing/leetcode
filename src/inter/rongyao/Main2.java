package inter.rongyao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName Main2
 * @Description TODO
 * @Author ktx
 * @Date 2022-08-23 19:20
 * @Version 1.0
 */
public class Main2 {
    public static void main(String[] args) {
        List<? super Integer> list = new ArrayList<Number>();
        list.add(1);
        Number[] arr = new Integer[3];
        arr[1]=1;
        List<Number> list1 = new ArrayList<>();
        list1.add(new Integer(1));
//        List<? extends Number> list1 = new ArrayList<Integer>();
//        list1.add(1);

//        Scanner scanner = new Scanner(System.in);
//        int num = scanner.nextInt();
//        for (int i = 2;i<=16;i++){
//            String fun = fun(i, num);
//            boolean palindrome = isPalindrome(fun);
//            if(palindrome){
//                System.out.println(i);
//            }
//
//        }
    }

    // 十进制转换为 n 进制
    public static String fun(int n,int num) {
        // n 表示目标进制, num 要转换的值
        String str= "";
        int yushu ;      // 保存余数
        int shang = num;      // 保存商
        while (shang>0) {
            yushu = shang %n;
            shang = shang/n;

            // 10-15 -> a-f
            if(yushu>9) {
                str =(char)('a'+(yushu-10)) + str;
            }else {
                str = yushu+str;
            }
        }

        return str;
    }
    public static boolean isPalindrome(String str) {
        StringBuffer sb = new StringBuffer(str);
        sb.reverse();// 把字符串反转
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == sb.charAt(i)) {
                count++; //统计相同字符的个数
            }
        }
        if (count == str.length()) {
            return true;
        } else {
            return false;
        }

    }
}
