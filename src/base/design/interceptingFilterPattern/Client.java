package base.design.interceptingFilterPattern;

/**
 * @author ktx
 * @data 2022-06-26 11:05
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
