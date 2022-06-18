package base.design.bulid.demo;

/**
 * @author ktx
 * @data 2022-06-18 20:45
 */
public abstract  class Computer {
    protected String mBoard;
    protected String mDisplay;
    protected String mOs;


    protected Computer(){
    }


    public void setBoard(String board){
        mBoard=board;
    }

    public void setDisplay(String display) {
        this.mDisplay = display;
    }


    public abstract void setOs() ;


    @Override
    public String toString() {
        return "Computer{" +
                "mBoard='" + mBoard + '\'' +
                ", mDisplay='" + mDisplay + '\'' +
                ", mOs='" + mOs + '\'' +
                '}';
    }
}
