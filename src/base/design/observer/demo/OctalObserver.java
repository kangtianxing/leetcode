package base.design.observer.demo;

/**
 * @ClassName OctalObserver
 * @Description TODO
 * @Author ktx
 * @Date 2022-08-24 23:04
 * @Version 1.0
 */
public class OctalObserver extends Observer{

    public OctalObserver(Subject subject){
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println( "Octal String: "
                + Integer.toOctalString( subject.getState() ) );
    }
}
