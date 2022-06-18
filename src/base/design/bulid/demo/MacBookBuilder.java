package base.design.bulid.demo;

/**
 * @author ktx
 * @data 2022-06-18 20:46
 */
public class MacBookBuilder  extends Builder{
    private Computer mComputer=new MacBook();
    @Override
    void buildBoard(String board) {
        mComputer.setBoard(board);
    }

    @Override
    void buildDisplay(String display) {
        mComputer.setDisplay(display);
    }

    @Override
    void buildOs() {
        mComputer.setOs();
    }

    @Override
    Computer build() {
        return mComputer;
    }
}
