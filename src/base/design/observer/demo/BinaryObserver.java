package base.design.observer.demo;

/**
 * @ClassName BinaryObserver
 * @Description TODO
 * @Author ktx
 * @Date 2022-08-24 23:03
 * @Version 1.0
 */
public class BinaryObserver  extends Observer {
    public BinaryObserver(Subject subject){
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println( "Binary String: "
                + Integer.toBinaryString( subject.getState() ) );
    }
}
