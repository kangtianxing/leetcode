package base.design.iterator;

/**
 * @author ktx
 * @data 2022-06-24 11:35
 */
public class Client {
    public static void main(String[] args) {
        ConcreteMyAggregate cma = new ConcreteMyAggregate();
        cma.addObject("aa");
        cma.addObject("bb");
        cma.addObject("cc");
        MyIterator iterator = cma.createIterator();
        while (iterator.hasNext()){
            System.out.println(iterator.getCurrentObj());
            iterator.next();
        }

    }
}
