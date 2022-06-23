package base.design.flyweight;

/**
 * @author ktx
 * @data 2022-06-22 20:47
 */
public class Client {
    public static void main(String[] args) {
        ChessFlyWeight chess1 = ChessFlyWeightFactory.getChess("黑色");
        ChessFlyWeight chess2 = ChessFlyWeightFactory.getChess("黑色");
        System.out.println(chess1);
        System.out.println(chess2);
        System.out.println("------------------");
        chess1.display(new Coordinate(10,10));
        chess1.display(new Coordinate(20,20));
    }
}
