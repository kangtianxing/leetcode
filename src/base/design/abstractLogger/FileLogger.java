package base.design.abstractLogger;

/**
 * @ClassName FileLogger
 * @Description TODO
 * @Author ktx
 * @Date 2022-09-28 14:39
 * @Version 1.0
 */
public class FileLogger extends AbstractLogger {

    public FileLogger(int level){
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("File::Logger: " + message);
    }
}