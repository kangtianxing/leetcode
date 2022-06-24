package base.design.observer;

/**
 * @author ktx
 * @data 2022-06-24 17:19
 */
public class ObserverA implements Observer{
    private int myState;

    @Override
    public void update(Subject subject) {
        myState =((ConcreteSubject)subject).getState();
    }

    public int getMyState() {
        return myState;
    }

    public void setMyState(int myState) {
        this.myState = myState;
    }
}
