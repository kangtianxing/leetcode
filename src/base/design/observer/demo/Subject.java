package base.design.observer.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Subject
 * @Description TODO
 * @Author ktx
 * @Date 2022-08-24 23:02
 * @Version 1.0
 */
public class Subject {
    private List<Observer> observers
            = new ArrayList<Observer>();
    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        notifyAllObservers();
    }

    public void attach(Observer observer){
        observers.add(observer);
    }

    public void notifyAllObservers(){
        for (Observer observer : observers) {
            observer.update();
        }
    }
}
