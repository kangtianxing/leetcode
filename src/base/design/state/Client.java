package base.design.state;

/**
 * @author ktx
 * @data 2022-06-24 16:46
 */
public class Client {
    public static void main(String[] args) {
        Context context = new Context();
        context.setState(new FreeState());
        context.setState(new CheckedInState());
    }
}
