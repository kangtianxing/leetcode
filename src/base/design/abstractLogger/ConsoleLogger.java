package base.design.abstractLogger;

/**
 * @ClassName ConsoleLogger
 * @Description TODO
 * @Author ktx
 * @Date 2022-09-28 14:38
 * @Version 1.0
 */
public class ConsoleLogger extends AbstractLogger {

    public ConsoleLogger(int level){
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Standard Console::Logger: " + message);
    }
}
