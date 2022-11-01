package base.io.bio.chat;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Server
 * @Description TODO
 * @Author ktx
 * @Date 2022-10-04 17:59
 * @Version 1.0
 */
public class Server {
    //定义一个静态集合
    public static List<Socket> allSocketOnLine = new ArrayList<>();
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(9999);
            while (true){
                Socket socket = ss.accept();
//把登录的客户端socket存入到一个在线集合中去
                allSocketOnLine.add(socket);
                //为当前登录成功的socket分配一个独立的线程来处理与之通信
                new ServerReaderThread(socket).start();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
