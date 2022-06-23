package base.design.chain;

/**
 * @author ktx
 * @data 2022-06-23 13:32
 */
public class SuperManager extends Leader{

    public SuperManager(String name) {
        super(name);
    }

    @Override
    public void handleRequest(LeaveRequest request) {
        if(request.getLeaveDays()<30){
            System.out.println("员工"+request.getEmpName()+"请假，天数"+request.getLeaveDays()+"理由"+request.getReason());
            System.out.println("总经理+"+this.name+"审批");
        }else {
            System.out.println("莫非"+request.getEmpName()+"想辞职,请假"+request.getLeaveDays());
        }
    }
}
