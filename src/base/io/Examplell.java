package base.io;

import java.io.*;

/**
 * @ClassName Examplell
 * @Description TODO
 * @Author ktx
 * @Date 2022-09-22 11:10
 * @Version 1.0
 */
public class Examplell {
    public static void main(String[] args) throws IOException {
        FileInputStream in = new FileInputStream("F:\\code\\algorithm\\leetcode\\src\\base\\io\\reader.txt");
        InputStreamReader isr = new InputStreamReader(in);
        BufferedReader br = new BufferedReader(isr);
        FileOutputStream out = new FileOutputStream("writer.txt");
        OutputStreamWriter osw = new OutputStreamWriter(out);
        BufferedWriter bw = new BufferedWriter(osw);
        String line = null;
        while ((line=br.readLine())!=null){
            bw.write(line);
            bw.newLine();
        }
        br.close();
        bw.close();
    }
}
