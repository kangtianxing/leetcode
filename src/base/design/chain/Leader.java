package base.design.chain;

/**
 * 抽象类
 * @author ktx
 * @data 2022-06-23 13:26
 */
public abstract class Leader {
    protected String name;
    protected Leader nextLeader;

    public Leader(String name) {
        super();
        this.name = name;
    }
    // 设置后继对象
    public void setNextLeader(Leader nextLeader) {
        this.nextLeader = nextLeader;
    }
    public abstract void handleRequest(LeaveRequest request);
}
