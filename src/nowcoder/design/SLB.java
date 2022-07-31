package nowcoder.design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName SLB
 * @Description SLB负载均衡
 * @Author ktx
 * @Date 2022-07-30 20:55
 * @Version 1.0
 */
public class SLB {
    public ArrayList<Integer> SLB (ArrayList<ArrayList<Integer>> operators) {
        // write code here
        // write code here
        ArrayList<Integer> res = new ArrayList<>();
        for (ArrayList<Integer> list : operators) {
            if (list.size()==1) {
                int num = select();
                res.add(num);
            }else {
                if(list.get(0)==1){
                    add(list.get(1));
                }else if(list.get(0)==2){
                    delete(list.get(1));
                }else {
                    release(list.get(1));
                }
            }
        }
        return res;
    }
    class Node{
        int num;
        boolean aBoolean;
        public Node(){};
        public Node(int num,boolean b){
            this.num=num;
            this.aBoolean=b;
        }
    }
    Queue<Node> queue = new LinkedList<>();
    HashMap<Integer, Node> hashMap=new HashMap<>();
    private  void add(Integer integer) {
        Node node=hashMap.get(integer);
        if(node==null){
            Node node1=new Node(integer,true);
            queue.add(node1);
            hashMap.put(integer,node1);
        }

    }
    private  void delete(Integer integer) {
        Node node=hashMap.get(integer);
        if(node!=null){
            hashMap.remove(integer);
            queue.remove(node);
        }

    }
    private  void release(Integer integer) {
        Node node=hashMap.get(integer);
        if(node!=null){
            node.aBoolean=true;
        }

    }
    private  int select() {
        for (Node node:queue){
            if(node.aBoolean==true){
                node.aBoolean=false;
                return node.num;
            }
        }
        return hashMap.size();

    }
}
