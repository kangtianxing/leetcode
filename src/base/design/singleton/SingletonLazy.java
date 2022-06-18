package base.design.singleton;

/**
 * @author ktx
 * @data 2022-06-18 20:02
 */
public class SingletonLazy {
    private static SingletonLazy instance;
    private SingletonLazy (){}
    public static synchronized SingletonLazy getInstance() {
        if (instance == null) {
            instance = new SingletonLazy();
        }
        return instance;
    }
}
