package base.design.memento;

/**
 * 负责人类，管理备忘录类
 * @author ktx
 * @data 2022-06-24 20:25
 */
public class CareTaker {
    private EmpMemento memento;

    public EmpMemento getMemento() {
        return memento;
    }

    public void setMemento(EmpMemento memento) {
        this.memento = memento;
    }
}
