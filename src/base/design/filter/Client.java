package base.design.filter;

/**
 * @ClassName Client
 * @Description TODO
 * @Author ktx
 * @Date 2022-09-28 15:09
 * @Version 1.0
 */
public class Client {
    FilterManager filterManager;

    public void setFilterManager(FilterManager filterManager){
        this.filterManager = filterManager;
    }

    public void sendRequest(String request){
        filterManager.filterRequest(request);
    }
}
