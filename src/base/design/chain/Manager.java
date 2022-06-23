package base.design.chain;

/**
 * @author ktx
 * @data 2022-06-23 13:32
 */
public class Manager extends Leader{

    public Manager(String name) {
        super(name);
    }

    @Override
    public void handleRequest(LeaveRequest request) {
        if(request.getLeaveDays()<10){
            System.out.println("员工"+request.getEmpName()+"请假，天数"+request.getLeaveDays()+"理由"+request.getReason());
            System.out.println("经理+"+this.name+"审批");
        }else {
            if(this.nextLeader!=null){
                this.nextLeader.handleRequest(request);
            }
        }
    }
}
