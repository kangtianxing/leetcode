package base.design.interceptingFilterPattern;

/**
 * @author ktx
 * @data 2022-06-26 11:02
 */
public class Target {
    public void execute(String request){
        System.out.println("Executing request: " + request);
    }
}
