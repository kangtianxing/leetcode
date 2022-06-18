package nowcoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author ktx
 * @data 2022-06-17 22:09
 */
public class SumPrimeFactor23 {
    //定义存放的list的list(因为list中数组长度可变),用来存放每个数的素因子
    static List<List<Integer>> list = new ArrayList<List<Integer>>();
    static int deepth = 0;//深度，也就是正整数的个数；
    static int minRes = 10000;//返回的结果
    static int[] vis = new int[1000];//因为每个访问的数都不重复，所以vis[i]指i是否被访问过
    static int sum = 0;//搜索时的和
    static boolean flag = false; //flag为1说明已经找到了最小值（遍历到了最底层（说明每个数都有素因子，只要有一个数没有，则无法递归到最底层））
    //先找到每个数的素因子，然后再深度搜索满足条件的最小值，若不存在，则输出-1
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        deepth = Integer.parseInt(in.nextLine());
        String[] res = in.nextLine().split(" ");
        //获取每一个数的素因子，放入list中
        for(int i = 0;i<deepth;i++){
            prime(Integer.parseInt(res[i]),i);
        }
        //开始从第一层深度搜索
        dfs(0);
        //输出结果
        if (!flag) {
            System.out.println("-1");
        } else {
            System.out.println(minRes);
        }
    }

    private static void dfs(int y) {
        if (y == deepth) { //如果遍历深度到最底层，退出，只能往回找了
            flag = true;//此时说明每一层都有素因子，合法的，一定会有最小值
            minRes = Math.min(minRes, sum);
            return;
        }
        for (int i = 0; i < list.get(y).size(); i++) {
            if (vis[list.get(y).get(i)] == 0) { //说明没有被访问
                sum += list.get(y).get(i);
                vis[list.get(y).get(i)] = 1;//标记为已访问
                dfs(y + 1);//开始遍历下一层;
                vis[list.get(y).get(i)] = 0;//遍历后回溯要先将该点标记为未访问
                sum -= list.get(y).get(i);//标为未读后要将该点的值去掉
            }
        }
    }

    //找素因子,n为输入的数，x为在list中存放的位置(第几行)
    public static void prime(int n, int x) {
        List<Integer> tempList = new ArrayList<Integer>();
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                if (isSu(i)) {
                    tempList.add(i); //满足素数，则存入
                }
                //还要存对应的另外一个因子（因为只遍历到根号n），前提是另外一个因子和此因子不相等，且也为素数
                if (i * i != n && isSu(n / i)) {
                    tempList.add(n / i);
                }
            }
        }
        list.add(tempList);
    }
    //判断是否为素数
    public static boolean isSu(int n) {
        if (n == 1) {
            return false;
        }
        //从2开始到根号n之间，只要找到n可以除尽的数，说明n有其他因子，则n不是素数
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
