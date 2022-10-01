package base.design.filter;

/**
 * @ClassName InterceptingFilterDemo
 * @Description TODO
 * @Author ktx
 * @Date 2022-09-28 15:09
 * @Version 1.0
 */
public class InterceptingFilterDemo {
    public static void main(String[] args) {
        FilterManager filterManager = new FilterManager(new Target());
        filterManager.setFilter(new AuthenticationFilter());
        filterManager.setFilter(new DebugFilter());

        Client client = new Client();
        client.setFilterManager(filterManager);
        client.sendRequest("HOME");
    }
}
