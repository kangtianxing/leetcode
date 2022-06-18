package base.design.singleton;

/**
 * @author ktx
 * @data 2022-06-18 20:03
 */
public class SingletonDCL {
    private volatile static SingletonDCL instance;
    private SingletonDCL(){}

    public static SingletonDCL getInstance() {
        if(instance==null){
            synchronized (SingletonDCL.class){
                if(instance==null){
                    instance = new SingletonDCL();
                }
            }
        }
        return instance;
    }
}
