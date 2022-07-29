package leetcode.hot100;

import java.util.Arrays;

/**
 * @ClassName validSquare
 * @Description TODO
 * @Author ktx
 * @Date 2022-07-29 21:35
 * @Version 1.0
 */
public class validSquare {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        // 任选三个点，都是一个直角三角形
        return isRightTriangle(p1,p2,p3) && isRightTriangle(p1,p2,p4) &&
                isRightTriangle(p2,p3,p4) &&isRightTriangle(p1,p3,p4);
    }

    private boolean isRightTriangle(int[] p1, int[] p2, int[] p3) {
        int d1 = (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
        int d2 = (p2[0] - p3[0]) * (p2[0] - p3[0]) + (p2[1] - p3[1]) * (p2[1] - p3[1]);
        int d3 = (p3[0] - p1[0]) * (p3[0] - p1[0]) + (p3[1] - p1[1]) * (p3[1] - p1[1]);
        if(d1>d2 && d2==d3 && d2+d3==d1 ||
           d2>d1 && d1==d3 && d1+d3==d2 ||
           d3>d1 && d1==d2 && d1+d2==d3){
            return true;
        }
        return false;
    }
}
