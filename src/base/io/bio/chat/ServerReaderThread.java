package base.io.bio.chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 * @ClassName ServerReaderThread
 * @Description TODO
 * @Author ktx
 * @Date 2022-10-04 18:01
 * @Version 1.0
 */
public class ServerReaderThread extends Thread{
    private Socket socket;
    public ServerReaderThread(Socket socket) {
        this.socket = socket;
    }
    @Override
    public void run() {
        try {
//1.从socket中去获取当前客户端的输入流
            BufferedReader br = new BufferedReader(new
                    InputStreamReader(socket.getInputStream()));
            String msg;
            while ((msg = br.readLine()) != null){
                System.out.println("服务器收到消息：" + msg);
//2.服务端接收到了客户端的消息后，需要推送给所有的当前在线的socket
                sendMsgToAllClient(msg,socket);
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("当前有人下线了！");
//从在线socket集合中移除本socket
            Server.allSocketOnLine.remove(socket);
        }
    }
    /**
     * 把当前客户端发送来的消息推送给全部在线的socket
     * @param msg
     */
    private void sendMsgToAllClient(String msg,Socket socket) throws Exception {
        for(Socket sk : Server.allSocketOnLine){
//只发送给除自己以外的其他客户端
            if(socket != sk){
                PrintStream ps = new PrintStream(sk.getOutputStream());
                ps.println(msg);
                ps.flush();
            }
        }
    }
}