package base.design.bridge;

/**
 * 品牌维度
 * @author ktx
 * @data 2022-06-21 14:35
 */
public interface Brand {
    void sale();
}
class Lenovo implements Brand{
    @Override
    public void sale() {
        System.out.println("销售联想电脑");
    }
}

class Dell implements Brand{

    @Override
    public void sale() {
        System.out.println("销售Dell电脑");
    }
}