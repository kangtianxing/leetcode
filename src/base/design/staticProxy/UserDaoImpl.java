package base.design.staticProxy;

/**
 * @ClassName UserDaoImpl
 * @Description TODO
 * @Author ktx
 * @Date 2022-08-07 17:42
 * @Version 1.0
 */
public class UserDaoImpl implements UserDao{
    @Override
    public void save() {
        System.out.println("正在保存用户...");
    }
}
