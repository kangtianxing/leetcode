package base.io;

/**
 * @ClassName GenericsDemo09
 * @Description TODO
 * @Author ktx
 * @Date 2022-09-10 10:59
 * @Version 1.0
 */

class Notepad<K,V>{
    private K key;
    private V value;

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
}

public class GenericsDemo09 {

    public static void main(String args[]){
        Notepad<String,Integer> t = null ;        // 定义两个泛型类型的对象
        t = new Notepad<String,Integer>() ;       // 里面的key为String，value为Integer
        t.setKey("汤姆") ;        // 设置第一个内容
        t.setValue(20) ;            // 设置第二个内容
        System.out.print("姓名；" + t.getKey()) ;      // 取得信息
        System.out.print("，年龄；" + t.getValue()) ;       // 取得信息

    }
}
