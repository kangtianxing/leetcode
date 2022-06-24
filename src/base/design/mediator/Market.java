package base.design.mediator;

/**
 * @author ktx
 * @data 2022-06-24 13:18
 */
public class Market implements Department {
    private Mediator m;  // 持有中介者的引用

    public Market(Mediator m) {
        super();
        this.m = m;
        m.register("Market",this);
    }

    @Override
    public void selfAction() {
        System.out.println("跑项目");

    }

    @Override
    public void outAction() {
        System.out.println("汇报工作，承接项目的进度，需要资金支持");
        m.command("finacial");
    }
}
