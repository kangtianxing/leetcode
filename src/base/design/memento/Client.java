package base.design.memento;

/**
 * @author ktx
 * @data 2022-06-24 20:26
 */
public class Client {
    public static void main(String[] args) {
        CareTaker taker = new CareTaker();
        Emp emp = new Emp("高旗", 18, 900);
        System.out.println("第一次创建对象"+emp.getEname()+"----"+emp.getAge()+"---"+emp.getSalary());
        taker.setMemento(emp.memento());

        emp.setAge(38);

        System.out.println("第er次创建对象"+emp.getEname()+"----"+emp.getAge()+"---"+emp.getSalary());


    }

    @Deprecated
    public static void test01(){

    }
}
