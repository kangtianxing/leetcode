package nowcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @ClassName findThreePositions
 * @Description TODO
 * @Author ktx
 * @Date 2022-10-19 15:15
 * @Version 1.0
 */
public class findThreePositions {
    public static void main(String[] args) {
        int[] arr = {1,2,3,3};
        findThreePositions findThreePositions = new findThreePositions();
        int[][] threePositions = findThreePositions.findThreePositions(arr, 6);
        System.out.println(threePositions);
    }
    public int[][] findThreePositions(int[] arr,int n){
        Arrays.sort(arr);
        int length = arr.length;
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0;i<length;i++){
            int left = i+1,right = length-1;
            while (left<right){
                int sum = arr[i]*arr[left]*arr[right];
                if(sum>n){
                    right--;
                }else if(sum<n){
                    left++;
                }else {
                    ArrayList<Integer> path = new ArrayList<>();
                    path.add(i);
                    path.add(left);
                    path.add(right);
                    result.add(path);
                    while (left<right&& arr[left]==arr[left+1]){
                        left++;
                        ArrayList<Integer> path1 = new ArrayList<>();
                        path1.add(i);
                        path1.add(left);
                        path1.add(right);
                        result.add(path1);
                    }
                    while (left<right&&arr[right]==arr[right-1]){
                        right--;
                        ArrayList<Integer> path2 = new ArrayList<>();
                        path2.add(i);
                        path2.add(left);
                        path2.add(right);
                        result.add(path2);
                    }
                    left++;
                    right--;
                }
            }
        }
        if(result.size()==0){
            int[][] re = new int[1][3];
            re[0][0]=-1;re[0][1]=-1;re[0][2]=-1;
            return re;
        }

        int[][] numResult = new int[result.size()][3];
        for (int i = 0; i < result.size(); i++) {
            List<Integer> list = result.get(i);
            numResult[i][0] = list.get(0);
            numResult[i][1] = list.get(1);
            numResult[i][2] = list.get(2);
        }
        Arrays.sort(numResult, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]!=o2[0]){
                    return o1[0]-o2[0];
                }else if(o1[1]!=o2[1]){
                    return o1[1]-o2[1];
                }else {
                    return o1[2]-o2[2];
                }
            }
        });
        return numResult;
    }
}
