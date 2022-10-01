package base.design.abstractLogger;

/**
 * @ClassName ErrorLogger
 * @Description TODO
 * @Author ktx
 * @Date 2022-09-28 14:39
 * @Version 1.0
 */
public class ErrorLogger extends AbstractLogger {

    public ErrorLogger (int level){
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Error  Console::Logger: " + message);
    }
}
