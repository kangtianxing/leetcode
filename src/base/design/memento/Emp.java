package base.design.memento;

import base.design.strategy.Strategy;

/**
 * 源发器类
 * @author ktx
 * @data 2022-06-24 17:43
 */
public class Emp {
    private String ename;
    private int age;
    private double salary;

    // 备忘操作，并返回备忘录对象
    public EmpMemento memento(){
        return new EmpMemento(this);
    }

    public void recovery(EmpMemento mmt){
        this.ename = mmt.getEname();
        this.age = mmt.getAge();
        this.salary = mmt.getSalary();
    }

    public Emp() {
    }

    public Emp(String ename, int age, double salary) {
        this.ename = ename;
        this.age = age;
        this.salary = salary;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
