package base.design.bridge;

/**
 * 电脑类型维度
 * @author ktx
 * @data 2022-06-21 14:37
 */
public class Computer {
    protected  Brand brand;

    public Computer() {
    }

    public Computer(Brand brand) {
        this.brand = brand;
    }
    public void sale(){
        brand.sale();
    }
}

class Desktop extends Computer{

    public Desktop(Brand b){
        super(b);
    }
    @Override
    public void sale() {
        super.sale();
        System.out.println("销售台式机");
    }
}
class Laptop extends Computer{

    public Laptop(Brand b){
        super(b);
    }
    @Override
    public void sale() {
        super.sale();
        System.out.println("销售笔记本");
    }
}