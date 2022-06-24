package base.design.mediator;

/**
 * 同事类的接口
 * @author ktx
 * @data 2022-06-24 13:12
 */
public interface Department {
    void selfAction();  // 做本部门的事情
    void outAction();  // 向总经理发出申请
}
