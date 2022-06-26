package base.design.interceptingFilterPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ktx
 * @data 2022-06-26 11:03
 */
public class FilterChain {
    private List<Filter> filters = new ArrayList<>();
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
