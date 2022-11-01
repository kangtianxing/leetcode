package base.design.component;

import org.w3c.dom.css.Counter;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Count
 * @Description TODO
 * @Author ktx
 * @Date 2022-10-10 17:36
 * @Version 1.0
 */
public interface Count {
    int count();
}

class City implements Count{
    private int sum =0;

    public City(int sum) {
        this.sum = sum;
    }

    @Override
    public int count() {
        return sum;
    }
}

class Composite implements Count{

    private List<Count> countList = new ArrayList<>();

    public void add(Count count){
        countList.add(count);
    }

    public void delete(Count count){
        countList.remove(count);
    }

    @Override
    public int count() {
        int sum = 0;
        for (Count count : countList) {
            sum+=count.count();
        }
        return sum;
    }
}
