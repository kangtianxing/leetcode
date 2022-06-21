package base.design.bridge;

/**
 * @author ktx
 * @data 2022-06-21 14:41
 */
public class Client {
    public static void main(String[] args) {
        // 销售联想笔记本
        Laptop laptop = new Laptop(new Lenovo());
        laptop.sale();
    }
}
