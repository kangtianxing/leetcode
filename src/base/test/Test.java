package base.test;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

/**
 * @ClassName Test
 * @Description TODO
 * @Author ktx
 * @Date 2022-07-14 15:21
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        for (Integer integer : integers) {
            if(integer==2){
                break;
            }
            System.out.println(integer);
        }
    }


}
