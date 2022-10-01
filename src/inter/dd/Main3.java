package inter.dd;

import java.util.*;
import java.util.concurrent.locks.Condition;

/**
 * @ClassName Main3
 * @Description TODO
 * @Author ktx
 * @Date 2022-09-19 19:09
 * @Version 1.0
 */
public class Main3 {
    static class Pair{
        public Integer key;
        public Integer index;

        public Pair(Integer key, Integer index) {
            this.key = key;
            this.index = index;
        }

        public Integer getKey() {
            return key;
        }

        public void setKey(Integer key) {
            this.key = key;
        }

        public Integer getIndex() {
            return index;
        }

        public void setIndex(Integer index) {
            this.index = index;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int p = scanner.nextInt(); //
        int q = scanner.nextInt();
        int[] arr = new int[p];
        LinkedHashMap<Integer,Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }
        for (int i = 0; i < q; i++) {
            map.put(scanner.nextInt(),i);
        }
        List<Pair> list = new ArrayList<>(p);
        for (int i = 0; i < arr.length; i++) {
            if(map.containsKey(arr[i])){
                list.add(new Pair(arr[i],map.get(arr[i])));
                arr[i] = 0;
            }
        }
        Collections.sort(list, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.index-o2.index;
            }
        });
        Arrays.sort(arr);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i).key+" ");
        }
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]!=0){
                System.out.print(arr[i]+" ");
            }
        }
    }
}
