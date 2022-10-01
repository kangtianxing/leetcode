package base.design.filter;

/**
 * @ClassName FilterManager
 * @Description TODO
 * @Author ktx
 * @Date 2022-09-28 15:09
 * @Version 1.0
 */
public class FilterManager {
    FilterChain filterChain;

    public FilterManager(Target target){
        filterChain = new FilterChain();
        filterChain.setTarget(target);
    }
    public void setFilter(Filter filter){
        filterChain.addFilter(filter);
    }

    public void filterRequest(String request){
        filterChain.execute(request);
    }
}
