package base.design.filter;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName FilterChain
 * @Description TODO
 * @Author ktx
 * @Date 2022-09-28 15:08
 * @Version 1.0
 */
public class FilterChain {
    private List<Filter> filters = new ArrayList<Filter>();
    private Target target;

    public void addFilter(Filter filter){
        filters.add(filter);
    }

    public void execute(String request){
        for (Filter filter : filters) {
            filter.execute(request);
        }
        target.execute(request);
    }

    public void setTarget(Target target){
        this.target = target;
    }
}
