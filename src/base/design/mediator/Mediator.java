package base.design.mediator;

/**
 * @author ktx
 * @data 2022-06-24 13:11
 */
public interface Mediator {

    void register(String name,Department d);
    void command(String dname);
}
