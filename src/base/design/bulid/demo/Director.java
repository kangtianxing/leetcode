package base.design.bulid.demo;

/**
 * @author ktx
 * @data 2022-06-18 20:47
 */
public class Director {
    Builder mBuilser=null;


    public Director(Builder builer) {
        this.mBuilser = builer;
    }


    public void construct(String board,String display){
        mBuilser.buildDisplay(display);
        mBuilser.buildBoard(board);
        mBuilser.buildOs();
    }
}
