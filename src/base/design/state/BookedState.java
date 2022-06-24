package base.design.state;

/**
 * @author ktx
 * @data 2022-06-24 16:42
 */
public class BookedState implements State {
    @Override
    public void handle() {
        System.out.println("房间已预定，别人不能定");
    }
}
