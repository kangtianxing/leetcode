package base.test.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author ktx
 * @data 2022-06-13 11:26
 */
public class Main {
    public static void main(String[] args) throws ParseException {
        String beginTime=new String("2017-06-09 10:22:22");
        String endTime=new String("2017-05-08 11:22:22");
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date sd1=df.parse(beginTime);
        Date sd2=df.parse(endTime);
        System.out.println(sd1.before(sd2));
        System.out.println(sd1.after(sd2));

    }
}
