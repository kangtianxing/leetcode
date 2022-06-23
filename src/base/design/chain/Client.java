package base.design.chain;

/**
 * @author ktx
 * @data 2022-06-23 13:34
 */
public class Client {
    public static void main(String[] args) {
        Leader a = new Director("张三");
        Leader b = new Manager("李四");
        Leader c = new SuperManager("王五");
        a.setNextLeader(b);
        b.setNextLeader(c);
        LeaveRequest leaveRequest = new LeaveRequest("Tom", 33, "回家");
        a.handleRequest(leaveRequest);
    }
}
