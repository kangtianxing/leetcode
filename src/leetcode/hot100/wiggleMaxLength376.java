package leetcode.hot100;

/**
 * 摆动数组的答案比较模板化———用两个变量记录此时摆动数组的长度情况(up, down)
 * up的意义是，遍历到该处时，假设摆动数组正处于上升状态，它的长度；down的意义是，遍历到该处时，假设摆动数组正处于下降状态，它的长度
 * 必须要理解的是，这两个摆动数组并不是同一个，因为我们假设了其结尾分别处于上升/下降状态
 * 关键还在于这两个状态的转换，即up和down交叉转换（联系股票问题）
 * 因为Q1要求连续，因此当摆动数组断裂时，up/down要重置为1；而Q2不要求连续，即摆动数组隐藏在整个数组中，up/down不需要重置，只需要继承（关键区别）
 * @author ktx
 * @data 2022-07-07 22:38
 */
public class wiggleMaxLength376 {
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        int up = 1;
        int down = 1;
        int res = 1;
        for (int i = 1;i<n;i++){
            if(nums[i]>nums[i-1]){
                up = down+1;
                down = 1;
            }else if(nums[i]<nums[i-1]){
                down = up+1;
                up = 1;
            }else {
                down = 1;
                up = 1;
            }
            res = Math.max(res,Math.max(down,up));
        }
        return res;
    }
    public int wiggleMaxLength1(int[] nums) {
        int n = nums.length;
        int up = 1;
        int down = 1;
        int res = 1;
        for (int i = 1;i<n;i++){
            if(nums[i]>nums[i-1]){
                up = down+1;
            }else if(nums[i]<nums[i-1]){
                down = up+1;
            }
            res = Math.max(res,Math.max(down,up));
        }
        return res;
    }

}
