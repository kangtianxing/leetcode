package base.design.adapter.demo;

/**
 * 适配器
 * @author ktx
 * @data 2022-06-19 10:47
 */
public class Adapter implements Target {
    Adpatee adpatee;

    public Adapter(Adpatee adpatee) {
        this.adpatee = adpatee;
    }

    @Override
    public void headleReq() {
        adpatee.request();
    }
}
