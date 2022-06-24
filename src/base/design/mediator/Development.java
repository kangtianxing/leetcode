package base.design.mediator;

import base.design.adapter.MediaPlayer;

/**
 * @author ktx
 * @data 2022-06-24 13:14
 */
public class Development implements Department{
    private Mediator m;  // 持有中介者的引用

    public Development(Mediator m) {
        super();
        this.m = m;
        m.register("development",this);
    }

    @Override
    public void selfAction() {
        System.out.println("专心科研，开发项目");
    }

    @Override
    public void outAction() {
        System.out.println("汇报工作，没钱了，需要资金支持");
    }
}
