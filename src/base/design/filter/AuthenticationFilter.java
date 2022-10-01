package base.design.filter;

/**
 * @ClassName AuthenticationFilter
 * @Description TODO
 * @Author ktx
 * @Date 2022-09-28 14:51
 * @Version 1.0
 */
public class AuthenticationFilter implements Filter {
    public void execute(String request){
        System.out.println("Authenticating request: " + request);
    }
}
