package base.design.chain.demo;

/**
 * @author ktx
 * @data 2022-06-23 20:31
 */
public class FileLogger  extends AbstractLogger {

    public FileLogger(int level){
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("File::Logger: " + message);
    }
}
