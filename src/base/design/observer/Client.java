package base.design.observer;

/**
 * @author ktx
 * @data 2022-06-24 17:21
 */
public class Client {
    public static void main(String[] args) {
        ConcreteSubject subject = new ConcreteSubject();
        ObserverA obs1 = new ObserverA();
        ObserverA obs2 = new ObserverA();
        ObserverA obs3 = new ObserverA();

        subject.register(obs1);
        subject.register(obs2);
        subject.register(obs3);

        subject.setState(20000);
        System.out.println(obs1.getMyState());
        System.out.println(obs2.getMyState());
        System.out.println(obs3.getMyState());

    }
}
