package base.design.state;

/**
 * @author ktx
 * @data 2022-06-24 16:43
 */
public class CheckedInState implements State {
    @Override
    public void handle() {
        System.out.println("房间已入住，请勿打扰");
    }
}
