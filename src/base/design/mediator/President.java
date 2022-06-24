package base.design.mediator;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ktx
 * @data 2022-06-24 13:20
 */
public class President implements Mediator{

    private Map<String,Department> map = new HashMap<>();

    @Override
    public void register(String name, Department d) {
        map.put(name,d);
    }

    @Override
    public void command(String dname) {
        map.get(dname).selfAction();
    }
}
