package base.design.staticProxy;

/**
 * @ClassName Main
 * @Description TODO
 * @Author ktx
 * @Date 2022-08-07 17:43
 * @Version 1.0
 */
public class Main {
    public static void main(String[] args) {
        //新建目标对象
        UserDaoImpl target = new UserDaoImpl();
        //创建代理对象, 并使用接口对其进行引用
        UserDao userDao = new TransactionHandler(target);
        //针对接口进行调用
        userDao.save();
    }
}
