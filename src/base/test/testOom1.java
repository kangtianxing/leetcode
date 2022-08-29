package base.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName testOom1
 * @Description TODO
 * @Author ktx
 * @Date 2022-08-25 12:30
 * @Version 1.0
 */
public class testOom1 {
    public static void main(String[] args) {

//        while (true){
//            Enhancer  enhancer = new Enhancer() ;
//            enhancer.setSuperclass(HeapOOM.class);
//            enhancer.setUseCache(false) ;
//            enhancer.setCallback(new MethodInterceptor() {
//                @Override
//                public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
//                    return methodProxy.invoke(o,objects) ;
//                }
//            });
//            enhancer.create() ;
//
//        }
    }

    public void testOom1() {
        List<Map<String, Object>> mapList = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {
            Map<String, Object> map = new HashMap<>();
            for (int j = 0; j < i; j++) {
                map.put(String.valueOf(j), j);
            }
            mapList.add(map);
        }
    }
}
