package base.io.bio.file;

import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.UUID;

/**
 * @ClassName ServerReadThread
 * @Description TODO
 * @Author ktx
 * @Date 2022-10-04 16:36
 * @Version 1.0
 */
public class ServerReadThread extends Thread{
    private Socket socket;
    public ServerReadThread(Socket socket){
        this.socket = socket;
    }
    @Override
    public void run() {
        try {
//1.得到一个数据输入流来读取客户端发送过来的数据
            DataInputStream dis = new DataInputStream(socket.getInputStream());
//2.读取客户端发送过来的文件类型
            String suffix = dis.readUTF();
            System.out.println("服务端已经成功接收到了文件类型：" + suffix);
//3.定义一个字节输出管道，负责把客户端发来的文件数据写出去
            OutputStream os = new
                    FileOutputStream("C:\\Users\\Lenovo\\Desktop\\server\\"
                    + UUID.randomUUID().toString() + suffix);
//4.从数据输入流中读取文件数据，写出到字节输出流中去
            byte[] buffer = new byte[1024];
            int len;
            while ((len = dis.read(buffer)) > 0){
                os.write(buffer,0,len);
            }
            os.close();
            System.out.println("服务端接收文件保存成功！");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
