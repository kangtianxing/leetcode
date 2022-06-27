package base.test.enum1;

/**
 * @author ktx
 * @data 2022-06-27 16:14
 */
public class Test {
    public static void main(String[] args) {
        for (ScriptEnum script : ScriptEnum.values()) {
            if(script.toString().equals("PENDING")){
                System.out.println(script.getName());
            }
        }
    }
}
