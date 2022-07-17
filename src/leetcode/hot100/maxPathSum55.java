package leetcode.hot100;

import java.util.Scanner;

/**
 * @ClassName maxPathSum55
 * @Description TODO
 * @Author ktx
 * @Date 2022-07-16 12:03
 * @Version 1.0
 */
public class maxPathSum55 {
    public static void main(String[] args){
        int n;
        Scanner sc = new Scanner(System.in);
//        n = sc.nextInt();
//        int[] node = new int[n];
//        int[] parent = new int[n];
//        for (int i = 0; i < n; i++) {
//            node[i] = sc.nextInt();
//        }
//        for (int i = 0; i < n; i++) {
//            parent[i] = sc.nextInt();
//        }
        n = 3;
        int[] node = {1,2,3};
        int[] parent = {0,1,1};

        // 记录子节点
        int[][] child = new int[n][2];

        for (int i = 0; i < n; i++) {
            child[i][0] = child[i][1] = -1;

            if (parent[i] > 0) {
                int[] childNode = child[parent[i] - 1];
                if (childNode[0] == -1) {
                    childNode[0] = i;
                } else {
                    childNode[1] = i;
                }
            }
        }

        int max = node[0];
        int[] dp = new int[n];
        // 从子节点往父节点记录dp
        for (int i = n - 1; i >= 0; i--) {
            int left = 0, right = 0;
            if (child[i][0] != -1)
                left = dp[child[i][0]];
            if (child[i][1] != -1)
                right = dp[child[i][1]];
            dp[i] = Math.max(Math.max(left, right), 0) + node[i];
            max = max(max, node[i], node[i] + left, node[i] + right, node[i] + left + right);
        }
        System.out.println(max);

    }

    public static int max(int a, int b, int c, int d, int e) {
        return Math.max(Math.max(Math.max(Math.max(a, b), c), d), e);
    }
}
