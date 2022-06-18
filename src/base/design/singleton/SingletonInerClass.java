package base.design.singleton;

/**
 * @author ktx
 * @data 2022-06-18 20:06
 */
public class SingletonInerClass {
    private static class SingletonHolder {
        private static final SingletonInerClass INSTANCE = new SingletonInerClass();
    }
    private SingletonInerClass (){}
    public static final SingletonInerClass getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
