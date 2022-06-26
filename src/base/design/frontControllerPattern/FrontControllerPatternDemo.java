package base.design.frontControllerPattern;

/**
 * @author ktx
 * @data 2022-06-26 10:58
 */
public class FrontControllerPatternDemo {
    public static void main(String[] args) {
        FrontController frontController = new FrontController();
        frontController.dispatchRequest("HOME");
        frontController.dispatchRequest("STUDENT");
    }
}
