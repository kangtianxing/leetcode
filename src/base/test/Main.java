package base.test;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @ClassName Main
 * @Description TODO
 * @Author ktx
 * @Date 2022-09-12 19:33
 * @Version 1.0
 */
public class Main {
    private int val;

    public Main(int val) {
        this.val = val;
    }
    //    private static int a;

    public static void main(String[] args) {
//        modify(a);
//        System.out.println(a);
//        String s = null;
//        System.out.println("s="+s);
//        float fa = new float[20];
//        char cd = "fds";
//        Object oa = new float[20];
//
//        ArrayList<Integer> a = new ArrayList<>();
//        a.add(1);
//        a.add(5);
//        a.add(3);
//        Collections.sort(a);
//        a.add(2);
//        Collections.reverse(a);
//        System.out.println(a);

        Main a = new Main(10);
        Main b = new Main(10);
        Main c =a;
        int d = 10;
        double e =10.0;

        System.out.println(a==c);
        System.out.println(d==e);
//        System.out.println(d==b);
        System.out.println(a==b);
        System.out.println(b==c);

    }

//    private static void modify(int a) {
//        a++;
//    }
}
