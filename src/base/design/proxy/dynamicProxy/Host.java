package base.design.proxy.dynamicProxy;

/**
 * @author ktx
 * @data 2022/6/9 20:05
 */
//真实角色: 房东，房东要出租房子
public class Host implements Rent{
    public void rent() {
        System.out.println("房屋出租");
    }
}
