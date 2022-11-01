package base.io.bio.chat;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * @ClassName ClientReaderThread
 * @Description TODO
 * @Author ktx
 * @Date 2022-10-04 18:06
 * @Version 1.0
 */
public class ClientReaderThread extends Thread {
    private Socket socket;
    public ClientReaderThread(Socket socket) {
        this.socket = socket;
    }
    @Override
    public void run() {
        try{
            while (true){
                InputStream is = socket.getInputStream();
//4.把字节输入流包装成一个缓存字符输入流
                BufferedReader br = new BufferedReader(new
                        InputStreamReader(is));
                String msg;
/* while ((msg = br.readLine()) != null){
System.out.println("client recive message：" + msg);
}*/
                if((msg = br.readLine()) != null){
//System.out.println("client recive message：" + msg);
                    System.out.println(msg);
                }
            }
        }catch (Exception e){
        }
    }
}
