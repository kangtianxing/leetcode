package base.io.bio.chat;

import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * @ClassName Client
 * @Description TODO
 * @Author ktx
 * @Date 2022-10-04 18:05
 * @Version 1.0
 */
public class Client {
    public static void main(String[] args){
        try {
//1.请求与服务端的Socket对象连接
            Socket socket = new Socket("127.0.0.1", 9999);
//收消息
            Thread clientThread = new ClientReaderThread(socket);
            clientThread.start();
            while (true){
//发消息
                OutputStream os = socket.getOutputStream();
                PrintStream ps = new PrintStream(os);
//3. 使用循环不断的发送消息给服务端接收
                Scanner sc = new Scanner(System.in);
//System.out.print("client send message：");
                String msg =sc.nextLine();
                ps.println(msg);
                ps.flush();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
