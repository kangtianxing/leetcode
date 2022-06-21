package base.design.adapter.demo;


/**
 * 客户端类
 * 相当于笔记本，只有 Usb
 * @author ktx
 * @data 2022-06-19 10:45
 */
public class Client {

    public void test1(Target t){
        t.headleReq();
    }

    public static void main(String[] args) {
        Client client = new Client();
        Target target = new Adapter(new Adpatee());
        client.test1(target);
    }
}
