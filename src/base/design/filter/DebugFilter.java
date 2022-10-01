package base.design.filter;

/**
 * @ClassName DebugFilter
 * @Description TODO
 * @Author ktx
 * @Date 2022-09-28 14:52
 * @Version 1.0
 */
public class DebugFilter implements Filter {
    public void execute(String request){
        System.out.println("request log: " + request);
    }
}
