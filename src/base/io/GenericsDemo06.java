package base.io;

/**
 * @ClassName GenericsDemo06
 * @Description TODO
 * @Author ktx
 * @Date 2022-09-10 10:57
 * @Version 1.0
 */
class Point<T>{
    private T var;

    public T getVar() {
        return var;
    }

    public void setVar(T var) {
        this.var = var;
    }
}
public class GenericsDemo06 {
    public static void main(String[] args) {
        Point<String> p = new Point<>();
        p.setVar("it");
        System.out.println(p.getVar().length());
    }
}
