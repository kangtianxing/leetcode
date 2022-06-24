package base.design.iterator;

/**
 * @author ktx
 * @data 2022-06-24 11:05
 */
public interface MyIterator {
    void first();
    void next();
    boolean hasNext();

    boolean isFirst();
    boolean isLast();

    Object getCurrentObj();  // 获取游标指向对象
}
