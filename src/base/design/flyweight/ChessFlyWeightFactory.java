package base.design.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * 享元工厂类
 * @author ktx
 * @data 2022-06-22 20:45
 */
public class ChessFlyWeightFactory {
    // 享元池
    private static Map<String,ChessFlyWeight> map = new HashMap<>();
    public static ChessFlyWeight getChess(String color){
        if(map.get(color)!=null){
            return map.get(color);
        }else {
            ChessFlyWeight cfw = new ConcreteChess(color);
            map.put(color,cfw);
            return cfw;
        }
    }
}
