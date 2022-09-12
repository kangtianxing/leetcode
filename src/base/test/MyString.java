package base.test;

/**
 * @ClassName MyString
 * @Description TODO
 * @Author ktx
 * @Date 2022-09-12 17:55
 * @Version 1.0
 */
public class MyString {


    private String innerString;

// ...init & other methods

    // 支持老的方法
    public int length(){
        return innerString.length(); // 通过innerString调用老的方法
    }

    // 添加新方法
    public String toMyString(){
        //...
        return null;
    }

    public final void test() {
    }

    public final void test(String str) {
    }
}
