package leetcode.graph;

/**
 * @ClassName GetLocation
 * @Description TODO
 * @Author ktx
 * @Date 2022-09-18 20:19
 * @Version 1.0
 */
public class GetLocation {
    public static void main(String[] args) {
        GetLocation getLocation = new GetLocation();
        int[] ints = getLocation.GeLocaton(4, 4, 2, 3, new int[]{0, 1, 1, 2, 3, 4, 0});
        System.out.println(ints[0]+""+ints[1]);
    }
    public int[] GeLocaton(int m,int n,int x,int y,int[] dirs){
        int curX = x;
        int curY = y;
        for (int dir : dirs) {
            if(dir==0){
                continue;
            }else if(dir==1){
                // 北
                if(curY>=n-1){
                    continue;
                }else {
                    curY+=1;
                }
            }else if(dir==2){
                // 东
                if(curX>=m-1){
                    continue;
                }else {
                    curX+=1;
                }
            }else if(dir==3){
                //南
                if(curY<=0){
                    continue;
                }else {
                    curY-=1;
                }
            }else {
                //xi
                if(curX<=0){
                    continue;
                }else {
                    curX-=1;
                }
            }
        }
        return new int[]{curX,curY};
    }
}
