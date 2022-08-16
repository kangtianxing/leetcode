package leetcode.hot100;

/**
 * @ClassName solveEquation
 * @Description TODO
 * @Author ktx
 * @Date 2022-08-12 9:30
 * @Version 1.0
 */
public class solveEquation {
    public String solveEquation(String equation) {
        String[] arr1 = equation.split("=");
        int left = 0;
        int right = 0;
        String[] arr2 = arr1[0].replace("-","+-").split("\\+");
        String[] arr3 = arr1[1].replace("-","+-").split("\\+");
        for (String s : arr2) {
            if(s.equals("x")){
                left+=1;
            }else if(s.equals("-x")){
                left+=-1;
            }else if(s.contains("x")){
                left+=Integer.parseInt(s.substring(0,s.length()-1));
            }else if(!s.equals("")){
                right-=Integer.parseInt(s);
            }
        }
        for (String s : arr3) {
            if (s.equals("x")) {
                left -= 1;
            } else if (s.equals("-x")) {
                left -= -1;
            } else if (s.contains("x")) {
                left -= Integer.parseInt(s.substring(0, s.length() - 1));
            } else if (!s.equals("")) {
                right += Integer.parseInt(s);
            }
        }
        if(left==0){
            if(right==0){
                return "Infinite solutions";
            }else {
                return "No solution";
            }
        }else {
            return "x="+right/left;
        }
    }
}
