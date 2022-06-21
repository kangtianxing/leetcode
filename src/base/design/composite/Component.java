package base.design.composite;

/**
 * @author ktx
 * @data 2022-06-21 15:06
 */
public interface Component {
    void operation();
}

interface Leaf extends Component{

}

interface Composite extends Component{
    void add(Component c);
    void remove(Component c);
    Component getChild(int index);
}
