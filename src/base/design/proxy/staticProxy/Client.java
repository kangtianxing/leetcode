package base.design.proxy.staticProxy;

/**
 * @author ktx
 * @data 2022/6/9 20:00
 */
public class Client {
    public static void main(String[] args) {
        //房东要租房
        Host host = new Host();
        //中介帮助房东
        Proxy proxy = new Proxy(host);
        //你去找中介！
        proxy.rent();
    }
}
