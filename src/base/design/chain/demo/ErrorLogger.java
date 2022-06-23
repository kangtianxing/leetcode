package base.design.chain.demo;

/**
 * @author ktx
 * @data 2022-06-23 20:31
 */
public class ErrorLogger extends AbstractLogger {

    public ErrorLogger(int level){
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Error Console::Logger: " + message);
    }
}
