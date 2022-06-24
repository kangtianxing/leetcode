package base.design.state;

/**
 * @author ktx
 * @data 2022-06-24 16:44
 */
public class Context {
    //
    private State state;

    public void setState(State state) {
        System.out.println("修改状态");

        this.state = state;
        state.handle();
    }
}
