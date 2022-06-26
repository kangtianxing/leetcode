package base.design.interceptingFilterPattern;

/**
 * @author ktx
 * @data 2022-06-26 11:02
 */
public class DebugFilter implements Filter {
    public void execute(String request){
        System.out.println("request log: " + request);
    }
}
