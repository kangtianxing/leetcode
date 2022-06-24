package base.design.observer;

/**
 * @author ktx
 * @data 2022-06-24 17:17
 */
public class ConcreteSubject extends Subject{
    private int state;
    public int getState(){
        return state;
    }

    public void setState(int state) {
        this.state = state;
        // 目标对象发生了变化，同时所有的观察者
        this.notifyAllObservers();
    }
}
