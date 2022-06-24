package base.design.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ktx
 * @data 2022-06-24 17:15
 */
public class Subject {

    protected List<Observer> list = new ArrayList<>();

    public void register(Observer obs){
        list.add(obs);
    }
    public void removeObserver(Observer obs){
        list.remove(obs);
    }
    // 通知所有观察者更新状态
    public void notifyAllObservers(){
        for (Observer observer : list) {
            observer.update(this);
        }
    }

}
