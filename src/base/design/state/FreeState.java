package base.design.state;

/**
 * 空闲状态
 * @author ktx
 * @data 2022-06-24 16:41
 */
public class FreeState implements State{
    @Override
    public void handle() {
        System.out.println("房间空闲，没人住");
    }
}
