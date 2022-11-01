package base.io.bio.one;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;

/**
 * @ClassName Client
 * @Description TODO
 * @Author ktx
 * @Date 2022-10-04 15:43
 * @Version 1.0
 */
public class Client {
    public static void main(String[] args) {
        try {
//1.创建Socket对象请求服务端的连接
            Socket socket = new Socket("127.0.0.1",9999);
//2.从Socket对象中获取一个字节输出流
            OutputStream os = socket.getOutputStream();
//3.把字节输出流包装成一个打印流
            PrintStream ps = new PrintStream(os);
//ps.print("hello World! 服务端，你好");
            ps.println("hello World! 服务端，你好");
            ps.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
