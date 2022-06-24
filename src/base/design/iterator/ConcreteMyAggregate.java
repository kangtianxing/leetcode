package base.design.iterator;

import javax.management.ObjectName;
import java.util.ArrayList;
import java.util.List;

/**
 * 自定义的聚合类
 * @author ktx
 * @data 2022-06-24 11:07
 */
public class ConcreteMyAggregate {
    private List<Object> list = new ArrayList<>();


    public ConcreteMyAggregate(List<Object> list) {
        super();
        this.list = list;
    }

    public ConcreteMyAggregate() {

    }

    public void addObject(Object obj){
        this.list.add(obj);
    }

    public void removeObject(Object obj){
        this.list.remove(obj);
    }

    public List<Object> getList() {
        return list;
    }

    public void setList(List<Object> list) {
        this.list = list;
    }

    // 获得迭代对象
    public MyIterator createIterator(){
        return new ConcreIterator();
    }

    // 使用内部类定义迭代器，可以直接使用外部类的属性
    private class ConcreIterator implements MyIterator{

        private int cursor;  // 定义游标用于记录遍历时的位置

        @Override
        public void first() {
            cursor = 0;
        }

        @Override
        public void next() {
            if(cursor<list.size()){
                cursor++;
            }
        }

        @Override
        public boolean hasNext() {
            if(cursor<list.size()){
                return true;
            }
            return false;
        }

        @Override
        public boolean isFirst() {
            return cursor==0?true:false;
        }

        @Override
        public boolean isLast() {
            return cursor==(list.size()-1)?true:false;
        }

        @Override
        public Object getCurrentObj() {
            return list.get(cursor);
        }
    }
}
